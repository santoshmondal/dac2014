package com.dac;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		Student obj = (Student)context.getBean("ref8");
		System.out.println(obj);
		
		
		System.out.println("Message :: " +  obj.getMessage() );
		System.out.println("Email :: " + obj.getEmail());
		System.out.println("My Name is :: " + obj.getSname());
		System.out.println("ID :: " + obj.getId());
		
		System.out.println("\nCONLLECTIONS");
		System.out.println("LIST :: " + obj.getList());
		System.out.println("SET :: " + obj.getSet());
		System.out.println("MAP :: " + obj.getMap());
		
		
		System.out.println("ADDRESS:: " + obj.getAddress().getCity());
		
		context.close();
	}
	
}
