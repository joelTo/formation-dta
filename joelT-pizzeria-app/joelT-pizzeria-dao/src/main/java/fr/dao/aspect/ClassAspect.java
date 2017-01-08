package fr.dao.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import fr.model.Pizza;

@Component
@Aspect
public class ClassAspect {

	@Before("execution(* fr.dao.*.save(..))")
	public void BeforeSavePizza(JoinPoint joinPoint) {
		System.out.println("logAfter() is running!");
		System.out.println("hijacked arguments : " + Arrays.toString(joinPoint.getArgs()));
		System.out.println("hijacked arguments : " + joinPoint.getArgs()[0].toString());
		Pizza pizza = (Pizza) joinPoint.getArgs()[0];
		pizza.setCode(pizza.getNom().substring(0, 3).toUpperCase());
	}
}
