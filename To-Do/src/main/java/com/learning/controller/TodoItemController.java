package com.learning.controller;

import com.learning.model.TodoData;
import com.learning.model.TodoItem;
import com.learning.service.Serviceable;
import com.learning.util.AttributeName;
import com.learning.util.Mapping;
import com.learning.util.ViewName;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Slf4j
@Controller
public class TodoItemController {

    // properties
    private final Serviceable serviceable;

    // constructor
    @Autowired
    public TodoItemController(Serviceable serviceable) {
        this.serviceable = serviceable;
    }

    // model attributes
    @ModelAttribute
    public TodoData todoData() {
        return serviceable.getData();
    }

    // http://localhost:8080/items
    @GetMapping(Mapping.ITEMS)
    public String items() {
        log.info("rendering items_list");
        return ViewName.ITEMS_LIST;
    }

    // http://localhost:8080/addItem
    @GetMapping(Mapping.ADD_ITEM)
    public String addEditItem(@RequestParam(required = false, defaultValue = "-1") int id, Model model) {

        log.info("editing id = {}", id);
        TodoItem todoItem = serviceable.getItem(id);

        if (todoItem == null) {
            todoItem = new TodoItem("", "", LocalDate.now());
        }

        model.addAttribute(AttributeName.TODO_ITEM, todoItem);
        log.info("rendering add_item");
        return ViewName.ADD_ITEM;
    }

    // http://localhost:8080/addItem
    @PostMapping(Mapping.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeName.TODO_ITEM) TodoItem todoItem) {
        log.info("todoItem from from = {}", todoItem);

        if (todoItem.getId() == 0) {
            serviceable.addItem(todoItem);
        } else {
            serviceable.updateItem(todoItem);
        }
        log.info("rendering items after adding");
        return "redirect:/" + Mapping.ITEMS;
    }

    // http://localhost:8080/deleteItem
    @GetMapping(Mapping.DELETE_ITEM)
    public String deleteItem(@RequestParam int id) {
        log.info("delete an item");
        serviceable.removeItem(id);
        log.info("rendering items after deleting");
        return "redirect:/" + Mapping.ITEMS;
    }

    // http://localhost:8080/viewItem
    @GetMapping(Mapping.VIEW_ITEM)
    public String deleteItem(@RequestParam int id, Model model) {
        TodoItem todoItem = serviceable.getItem(id);
        model.addAttribute(AttributeName.TODO_ITEM, todoItem);
        log.info("rendering view_item to view");
        return ViewName.VIEW;
    }
}
