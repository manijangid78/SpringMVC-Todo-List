package com.mani.model;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class ToDoData {

    //===fields====
    public final List<ToDoItem>  itemList = new ArrayList<>();
    public static int inValue = 1;

    public ToDoData() {

        // add some static items in the list
        addItem(new ToDoItem("First","First Details", LocalDate.now()));
        addItem(new ToDoItem("Secound","Secound Details", LocalDate.now()));
        addItem(new ToDoItem("Third","Third Details", LocalDate.now()));
        addItem(new ToDoItem("Forth","Forth Details", LocalDate.now()));

    }

    // get the whole list of items
    public List<ToDoItem> getItems(){
        return Collections.unmodifiableList(itemList);
    }

    // add a new item
    public void addItem(@NonNull ToDoItem item){
        item.setId(inValue);
        itemList.add(item);
        inValue++;
    }

    //remove a item
    public void remove(@NonNull int id){
        ListIterator<ToDoItem> items = itemList.listIterator();
        while(items.hasNext()){
            ToDoItem item = items.next();
            if(item.getId()==id){
                items.remove();
            }
        }
    }

    // return a single item
    public ToDoItem getItem(int id){
        for(ToDoItem item : itemList){
            if(item.getId()==id){
                return item;
            }
        }
        return null;
    }

    // update the item
    public void updateItem(@NonNull ToDoItem updateItem){
        ListIterator<ToDoItem> items = itemList.listIterator();
        while (items.hasNext()){
            ToDoItem item = items.next();
            if(item.equals(updateItem)){
                items.set(updateItem);
                break;
            }
        }
    }
}
