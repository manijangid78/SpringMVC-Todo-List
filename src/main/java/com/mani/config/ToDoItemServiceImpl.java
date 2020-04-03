package com.mani.config;

import com.mani.model.ToDoData;
import com.mani.model.ToDoItem;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class ToDoItemServiceImpl implements ToDoItemService {

    @Getter
    public final ToDoData data = new ToDoData();

    @Override
    public void addItem(ToDoItem toAdd) {
        data.addItem(toAdd);
    }

    @Override
    public void remove(int id) {
        data.remove(id);
    }

    @Override
    public ToDoItem getItem(int id) {
        return data.getItem(id);
    }

    @Override
    public void updateItem(ToDoItem toUpdate) {
        data.updateItem(toUpdate);
    }
}
