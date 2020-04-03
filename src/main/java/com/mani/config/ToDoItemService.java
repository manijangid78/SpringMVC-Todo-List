package com.mani.config;

import com.mani.model.ToDoData;
import com.mani.model.ToDoItem;

public interface ToDoItemService {

    void addItem(ToDoItem toAdd);
    void remove(int id);
    ToDoItem getItem(int id);
    void updateItem(ToDoItem toUpdate);
    ToDoData getData();

}
