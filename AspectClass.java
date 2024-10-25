package com.example.demo;

import java.time.LocalDateTime;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class AspectClass {
	
	
	@Before("execution(* com.example.demo.UserServices.adduser(..))")
public void add() {
	System.out.println("User Created Successfully at :"+LocalDateTime.now());
}
	
	@After("execution(* com.example.demo.UserServices.showusers(..))")
public void show() {
	System.out.println("Users list  displayed at :"+LocalDateTime.now());
}
	
	@After("execution(* com.example.demo.UserServices.update(..))")
	public void update() {
		System.out.println("User updated at :"+LocalDateTime.now());
	}
	
	@After("execution(* com.example.demo.UserServices.delete(..))")
	public void delete() {
		System.out.println("User deleted at :"+LocalDateTime.now());
	}
}
