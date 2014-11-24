package com.dac.coupling;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("couplig.xml");
		
		Manager ref = (Manager)context.getBean("manager");
		List<String> list = ref.listUser();
		ref.getUser();
		System.out.println(list);
	}
}
