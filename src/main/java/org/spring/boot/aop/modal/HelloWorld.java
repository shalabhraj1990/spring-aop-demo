package org.spring.boot.aop.modal;

import org.springframework.stereotype.Component;

@Component
public class HelloWorld {
	public String sayHello() {
		System.out.println("sayHello called");
		return "hello world";
	}

	public String sayHello1() {
		System.out.println("sayHello1 called");
		return "hello world";
	}

	public String sayHello(String msg) {
		sayHelloPrivate();
		System.out.println("sayHello with parameter called");
		return msg;
	}

	private String sayHelloPrivate() {
		System.out.println("sayHello private method called");
		return "hello world";
	}
}
