package com.learning.service;

import com.learning.model.TodoData;
import com.learning.model.TodoItem;

public interface Serviceable {
    void addItem(TodoItem item);

    void removeItem(int id);

    TodoItem getItem(int id);

    void updateItem(TodoItem item);

    TodoData getData();
}
