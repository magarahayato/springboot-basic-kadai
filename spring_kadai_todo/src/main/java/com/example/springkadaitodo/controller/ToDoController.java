package com.example.springkadaitodo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.springkadaitodo.entity.ToDo;
import com.example.springkadaitodo.service.ToDoService;

@Controller
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @GetMapping("/")
    public String todoPage(Model model) {

        List<ToDo> todoList = toDoService.findAll();

        model.addAttribute("todoList", todoList);

        return "todoView";
    }
}