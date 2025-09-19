package com.Raghav.Project.myFristWebApp.ToDo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

//@Controller
@SessionAttributes("name")
public class ToDoController {
	
	
public ToDoController(ToDoService todoService) {
		super();
		this.todoService=todoService;
	}
private ToDoService todoService;


@RequestMapping("list-todos")
	public String listAllToDos(ModelMap model) {
	String username =getLoggedInUsername(model);
List<ToDo> todos=todoService.findByUsername(username);
	model.addAttribute("todos",todos);
		return "listToDos";
	
}


private String getLoggedInUsername(ModelMap model) {
	Authentication authentication = 
			SecurityContextHolder.getContext().getAuthentication();
			return authentication.getName();
}


@RequestMapping(value="add-todo",method=RequestMethod.GET)
	public String showNewToDoPage(ModelMap model) {
	String username =getLoggedInUsername(model);
	ToDo todo=new ToDo(0,username,"Default Desc",LocalDate.now().plusYears(1),false);
	model.put("todo", todo);
		return "todo";
	
}
@RequestMapping(value="add-todo",method=RequestMethod.POST)
public String addNewToDo(ModelMap model,@Valid @ModelAttribute("todo") ToDo todo,BindingResult result) {
	
	if(result.hasErrors()) {
	return "todo";	
	}
	
	String username =getLoggedInUsername(model);
	todoService.addToDo(username, todo.getDescription(), LocalDate.now().plusYears(1), false);
	return "redirect:list-todos";

}
@RequestMapping("delete-todo")
public String deleteToDo(@RequestParam int id) {
    todoService.deleteById(id);
    return "redirect:list-todos";
}

@RequestMapping(value="update-todo",method=RequestMethod.GET )
public String showUpdateToDoPage(@RequestParam int id,ModelMap model) {
    ToDo todo=todoService.findById(id);
 model.addAttribute("todo", todo);
	return "todo";
}



@RequestMapping(value="update-todo",method=RequestMethod.POST)
public String updateToDo(ModelMap model,@Valid @ModelAttribute("todo") ToDo todo,BindingResult result) {
	
	if(result.hasErrors()) {
	return "todo";	
	}
	
	String username =getLoggedInUsername(model);
	todo.setUsername(username);
	todoService.updateToDo(todo);
	return "redirect:list-todos";

}
}



























