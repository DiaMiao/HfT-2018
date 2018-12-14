package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class DemoApplication {

	@Autowired
	TodoRepository todoRepository;

	@GetMapping("/todos")
	ArrayList<String> getTodos(){

		ArrayList<String> todos = new ArrayList<String>();
		todoRepository.findAll().forEach(todo -> todos.add(todo.getTodo()));
		return todos;
	}

	@PostMapping("/todos/{todo}")
	String addTodo(@PathVariable String todo){

		todoRepository.save(new Todo(todo));
		return "added "+todo;

	}

	@DeleteMapping("/todos/{todo}")
	String deleteTodo(@PathVariable String todo){

		todoRepository.deleteById(todo);
		return "delete "+todo;

	}

	@GetMapping("/")
	String sayHello(){

		return "Hallo Hft!";
	}

	@GetMapping("/other")
	String sayHelloAgain(){

		return "Hallo Hft from another endpoint!";
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}

@Entity
class Todo{

	@Id
	String todo;

	public Todo(){}

	public Todo(String todo){
		this.todo = todo;
	}

	public String getTodo(){
		return todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}

}

interface TodoRepository extends CrudRepository<Todo,String>{}
