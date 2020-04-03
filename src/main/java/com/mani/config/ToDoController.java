package com.mani.config;

import com.mani.model.ToDoData;
import com.mani.model.ToDoItem;
import com.mani.util.AttributesName;
import com.mani.util.Mappings;
import com.mani.util.ViewNames;
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
public class ToDoController {

    private final ToDoItemService toDoItemService;

    @Autowired
    public ToDoController(ToDoItemService toDoItemService) {
        this.toDoItemService = toDoItemService;
    }

    //model attribute section
    @ModelAttribute
    public ToDoData toDoData(){
        return toDoItemService.getData();
    }

    // http://localhost:8080/SpringMVC/items
    @GetMapping(Mappings.ITEMS)
    public String items(){
        return ViewNames.ITEMS_LIST;
    }

    // http://localhost:8080/SpringMVC/add_item
    @GetMapping(Mappings.ADD_ITEM)
    public String addEditItem(@RequestParam(required = false,defaultValue = "-1")int id,Model model){

        ToDoItem toDoItem = toDoItemService.getItem(id);
        if(toDoItem==null) {
            toDoItem = new ToDoItem("", "", LocalDate.now());
        }
        model.addAttribute(AttributesName.TODO_ITEM,toDoItem);
        log.info("{}",model);
        return ViewNames.ADD_ITEM;
    }

    @GetMapping(Mappings.DELETE_ITEM)
    public String deleteItem(@RequestParam int id){
        toDoItemService.remove(id);
        return "redirect:/"+Mappings.ITEMS;
    }

    @PostMapping(Mappings.ADD_ITEM)
    public String processMapping(@ModelAttribute(AttributesName.TODO_ITEM) ToDoItem toDoItem){
        log.info("todoitems are  {}", toDoItem);
        if(toDoItem.getId()==0) {
            toDoItemService.addItem(toDoItem);
        }
        else{
            toDoItemService.updateItem(toDoItem);
        }
        return "redirect:/"+ Mappings.ITEMS;
    }

    @GetMapping(Mappings.VIEW_ITEM)
    public String viewItem(@RequestParam int id, Model model){
        ToDoItem toDoItem = toDoItemService.getItem(id);
        model.addAttribute(AttributesName.TODO_ITEM,toDoItem);
        return ViewNames.VIEW_ITEM;
    }
}