package org.spring.boot.aop;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectDemo {
	//@Before("PointCut.allMethodsInHellowWorld()")
	public void printBefore() {
		System.out.println("before statement");
	}

	//@AfterThrowing(value = "PointCut.allMethodsInHellowWorld()", throwing = "ex")
	public void logExceptionIntoDbAsync(Throwable ex) {
		new Thread(() -> {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			ex.printStackTrace(pw);
			String exception = sw.toString();
		}).start();
	}

	//@AfterReturning(value = "PointCut.allMethodsInHellowWorld()", returning = "response")
	public Object logResponseAsync(Object response) {
		new Thread(() -> {
			System.err.println(response);
		}).start();
		return response;
	}

	//@After(value = "PointCut.allMethodsInHellowWorld()")
	public void finallyBlock() {
		System.err.println("this statement will print everytime");
	}

	@Around(value = "PointCut.allMethodsInHellowWorld()")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		// BeforeAdvice
		System.out.println("Before statement from Around Advice");
		long startTime = System.currentTimeMillis();

		Object value = null;

		try {
			value = joinPoint.proceed();
		} catch (Throwable e) {
			// After Throwing advice
			System.out.println("Got exception in Around Advice");
			e.printStackTrace();
			throw e;
		}
		// After Returing Advice
		System.out.println("Got response from target ::" + value.getClass().getName());
		System.out.println("Total execution time of method is ::" + (System.currentTimeMillis() - startTime));
		return value;

	}
}
