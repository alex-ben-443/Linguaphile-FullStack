package com.example.demo.Controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.LPModel;
import com.example.demo.Model.VerifyModel;
import com.example.demo.Service.LPService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000")
public class LPControl {
	@Autowired
	private LPService service;
	@Tag(name = "Signin", description = "Login Endpoint")
	@PostMapping("/Signin")
	private String Login(@RequestBody Map<String, String> xLogin) {
	    String username = xLogin.get("username");
	    String password = xLogin.get("password");
	    String result = service.Login(username, password);
	    return result;
	}

	@Tag(name = "Signup", description = "Signup Endpoint")
    @PostMapping("/Signup")
    public String Signup(@RequestBody VerifyModel user) {
        return service.Signup(user);
    }
	
	@Tag(name = "List Courses", description = "List All Courses")
	@GetMapping("/list")
	private List<LPModel> Cars(){
		return service.getData();
	}
	
	@Tag(name = "Sort Course by ID", description = "View Course Data")
	@GetMapping("/data/{id}")
	private Optional<LPModel> viewCar(@PathVariable Long id) {
		return service.findbyID(id);
	}
	
	
	@Tag(name = "Add Course", description = "Add New Course")
	@PostMapping("/add")
	private LPModel addCar(@RequestBody LPModel data) {
		return service.addData(data);
	}
	
	@Tag(name = "Edit Course", description = "Edit Existing Course")
	@PutMapping("/edit/{id}")
	private LPModel editCar(@PathVariable Long id, @RequestBody LPModel data) {
		return service.editData(data, id);
	}
	
	@Tag(name = "Delete Data", description = "Delete The Existing Course")
	@DeleteMapping("/delete/{id}")
	private String deleteCar(@PathVariable Long id) {
		return service.deleteData(id);
	}
}
