package com.learning.service;

import com.learning.model.ToDoData;
import com.learning.model.ToDoItem;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ToDoItemServiceActivity implements ToDoItemService {
    @Getter
    private final ToDoData data = new ToDoData();

    @Override
    public void addItem(ToDoItem toAdd) {
        log.info("add toAdd method");
        data.addItem(toAdd);
        log.info(toAdd + " added");
    }

    @Override
    public void removeItem(int id) {
        log.info("remove item method");
        data.removeItem(id);
        log.info("item with " + id + " deleted");
    }

    @Override
    public ToDoItem getItem(int id) {
        log.info("get item method");
        log.info("item with " + id + " returned");
        return data.getItem(id);

    }

    @Override
    public void updateItem(ToDoItem toUpdate) {
        log.info("update toUpdate method");
        data.updateItem(toUpdate);
        log.info(toUpdate + " updated");
    }

}
