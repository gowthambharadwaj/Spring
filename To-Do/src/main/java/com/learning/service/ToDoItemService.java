package com.learning.service;

import com.learning.model.TodoData;
import com.learning.model.TodoItem;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ToDoItemService implements Serviceable {

    // properties
    @Getter
    private final TodoData data = new TodoData();

    // functions
    @Override
    public void addItem(TodoItem toAdd) {
        data.addItem(toAdd);
    }

    @Override
    public void removeItem(Integer id) {
        data.removeItem(id);
    }

    @Override
    public TodoItem getItem(Integer id) {
        return data.getItem(id);
    }

    @Override
    public void updateItem(TodoItem toUpdate) {
        data.updateItem(toUpdate);
    }

}
