package com.example.todoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.todoapp.model.Todo;
import com.example.todoapp.service.TodoService;

@Controller
@RequestMapping("/")
public class TodoController {
	
	private final TodoService todoService;
	
	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}
	
	@GetMapping
	public String listTodos(Model model) {
		model.addAttribute("todos", todoService.getAllTodos());
		model.addAttribute("newTodo", new Todo());
		return "index";
	}
	
	@PostMapping("/add")
	public String addTodo(@ModelAttribute Todo newTodo) {
		todoService.addTodo(newTodo);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteTodoById(@PathVariable Long id) {
		todoService.deleteTodoById(id);
		return "redirect:/";
	}

}
