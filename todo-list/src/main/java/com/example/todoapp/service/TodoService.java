package com.example.todoapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.todoapp.model.Todo;
import com.example.todoapp.repository.TodoRepository;

@Service
public class TodoService {
	
	private final TodoRepository todoRepository;
	
	public TodoService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}
	
	public List<Todo> getAllTodos() {
		return todoRepository.findAll();
	}
	
	public void addTodo(Todo todo) {
		todoRepository.save(todo);
	}
	
	public void deleteTodoById(Long id) {
		todoRepository.deleteById(id);
	}
	
	public Todo getTodoById(Long id) {
		return todoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Todo not found with id: " + id));
	}
	
	public void updateTodo(Long id, Todo updatedTodo) {
		Todo existingTodo = getTodoById(id);
		existingTodo.setTitle(updatedTodo.getTitle());
		existingTodo.setCompleted(updatedTodo.isCompleted());
		todoRepository.save(existingTodo);
	}

}
