package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class UserController {
    
    @Autowired
    private UserServices serv;  
    
    @GetMapping("/")
    public String home() {
        return "Hey user, please register first";
    }

    @PostMapping("/adduser")
    public UserResponseDto add(@Valid @RequestBody UserRequestDto requestDto ) {
    	System.out.println("User created Successfully");
       return serv.adduser(requestDto);   
       
    }
    
    @GetMapping("/showusers")
    public List< UserResponseDto> show() {
    	return serv.showusers();
    }
    
    @GetMapping("/showusers/{id}")
    public   UserResponseDto showbyid(@PathVariable int id) {
    	return serv.showusersbyid(id);

}
    @PutMapping("/updateuser/{id}")
    public UserResponseDto update(@PathVariable int id,@RequestBody UserResponseDto rt) {
    	return serv.update(id, rt);
    }
    
    @DeleteMapping("/deleteuser/{id}")
    public String delete(@PathVariable int id) {
    	return serv.delete(id);
    }
    

}
