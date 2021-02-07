package com.learning.controller;

import com.learning.model.ToDoData;
import com.learning.model.ToDoItem;
import com.learning.service.ToDoItemService;
import com.learning.util.AttributeNames;
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
public class ToDoItemController {

    // properties
    private final ToDoItemService toDoItemService;

    // constructor
    @Autowired
    public ToDoItemController(ToDoItemService toDoItemService) {
        this.toDoItemService = toDoItemService;
    }

    // model attributes
    @ModelAttribute
    public ToDoData toDoData() {
        return toDoItemService.getData();
    }

    // http://localhost:8080/items
    @GetMapping(Mapping.ITEMS)
    public String items() {
        return ViewName.ITEMS_LIST;
    }

    @GetMapping(Mapping.ADD_ITEM)
    public String addEditItem(@RequestParam(required = false, defaultValue = "-1") int id, Model model) {
        log.info("editing id = {}", id);
        ToDoItem todoItem = toDoItemService.getItem(id);

        if (todoItem == null) {
            log.info("add tem NULL");
            todoItem = new ToDoItem("", "", LocalDate.now());
        }

        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return ViewName.ADD_ITEM;
    }

    // http://localhost:8080/addItem
    @PostMapping(Mapping.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) ToDoItem todoItem) {
        log.info("todoItem from from = {}", todoItem);
        if (todoItem.getId() == 0) {
            toDoItemService.addItem(todoItem);
        } else {
            toDoItemService.updateItem(todoItem);
        }
        return "redirect:/" + Mapping.ITEMS;
    }

    // http://localhost:8080/deleteItem
    @GetMapping(Mapping.DELETE_ITEM)
    public String deleteItem(@RequestParam int id) {
        log.info("delete an item");
        toDoItemService.removeItem(id);
        return "redirect:/" + Mapping.ITEMS;
    }
}
