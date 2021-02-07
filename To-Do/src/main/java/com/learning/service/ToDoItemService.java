package com.learning.service;

import com.learning.model.ToDoData;
import com.learning.model.ToDoItem;

public interface ToDoItemService {
    void addItem(ToDoItem item);

    void removeItem(int id);

    ToDoItem getItem(int id);

    void updateItem(ToDoItem item);

    ToDoData getData();
}
