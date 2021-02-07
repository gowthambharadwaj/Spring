package com.learning.model;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

@Slf4j
public class ToDoData {
    // properties
    private static int idValue = 1;

    private final List<ToDoItem> items = new ArrayList<>();

    // constructors
    public ToDoData() {

        addItem(new ToDoItem("Get groceries","Dal, veggies, curd", LocalDate.now()));
        addItem(new ToDoItem("Upskill","Programming, springboot", LocalDate.now()));
        addItem(new ToDoItem("Network","Linkedin, apply", LocalDate.now()));
        addItem(new ToDoItem("Health","Eat well, meditate", LocalDate.now()));

    }

    // public methods
    public List<ToDoItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void addItem(@NonNull ToDoItem toAdd) {
        toAdd.setId(idValue);
        log.info("Id set " + idValue);
        items.add(toAdd);
        log.info("Item added" + toAdd.toString());
        idValue++;
    }

    public void removeItem(int id) {
        ListIterator<ToDoItem> itemIterator = items.listIterator();
        while (itemIterator.hasNext()) {
            ToDoItem item = itemIterator.next();
            if (item.getId() == id) {
                log.info(item.toString() + " removed");
                itemIterator.remove();
                break;
            }
        }
    }

    public ToDoItem getItem(int id) {
        for (ToDoItem item : items) {
            if (item.getId() == id)
                log.info(item.toString() + " found and returned");
            return item;
        }
        log.info("Item not found");
        return null;
    }

    public void updateItem(@NonNull ToDoItem toUpdate) {
        ListIterator<ToDoItem> itemIterator = items.listIterator();
        while (itemIterator.hasNext()) {
            ToDoItem item = itemIterator.next();
            if (item.equals(toUpdate)) {
                log.info(item.toString()+" item to update found");
                itemIterator.set(toUpdate);
                log.info("Item updated");
                break;
            }
        }
    }
}
