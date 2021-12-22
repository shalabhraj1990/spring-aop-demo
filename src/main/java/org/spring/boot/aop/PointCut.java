package org.spring.boot.aop;

import org.aspectj.lang.annotation.Pointcut;

public class PointCut {
	@Pointcut(value = "execution(* org.spring.boot.aop.modal.HelloWorld.*(..))")
	public static void allMethodsInHellowWorld() {
	}

}
