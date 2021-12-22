package org.spring.boot.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectDemo {
	@Before("execution(* org.spring.boot.aop.modal.HelloWorld.*(..))")
	public void printBefore() {
		System.out.println("before statement");
	}

}
