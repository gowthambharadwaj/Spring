package com.learning.model;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

@Slf4j
public class TodoData {
    // properties
    private static Integer idValue = 1;

    private final List<TodoItem> items = new ArrayList<>();

    // constructors
    public TodoData() {

        addItem(new TodoItem("Get groceries", "Dal, veggies, curd", LocalDate.now()));
        addItem(new TodoItem("Upskill", "Programming, springboot", LocalDate.now()));
        addItem(new TodoItem("Network", "Linkedin, apply", LocalDate.now()));
        addItem(new TodoItem("Health", "Eat well, meditate", LocalDate.now()));

    }

    // public methods
    public List<TodoItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void addItem(@NonNull TodoItem toAdd) {
        log.info("added item " + toAdd.toString());
        toAdd.setId(idValue);
        items.add(toAdd);
        idValue++;
    }

    public void removeItem(Integer id) {
        ListIterator<TodoItem> itemIterator = items.listIterator();

        while (itemIterator.hasNext()) {
            TodoItem item = itemIterator.next();

            if (item.getId() == id) {
                itemIterator.remove();
                log.info("removed item with Id " + id);
                break;
            }
        }
    }

    public TodoItem getItem(Integer id) {
        for (TodoItem item : items) {
            if (item.getId() == id) {
                log.info("fetched item with id " + id);
                return item;
            }
        }
        return null;
    }

    public void updateItem(@NonNull TodoItem toUpdate) {
        ListIterator<TodoItem> itemIterator = items.listIterator();

        while (itemIterator.hasNext()) {
            TodoItem item = itemIterator.next();

            if (item.equals(toUpdate)) {
                itemIterator.set(toUpdate);
                log.info("updated item " + toUpdate.toString());
                break;
            }
        }
    }
}
