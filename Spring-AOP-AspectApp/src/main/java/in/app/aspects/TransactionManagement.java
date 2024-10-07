package in.app.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionManagement {

	@Pointcut("execution(public * in.app.dao.EmployeeDao.*())")
	public void p1() {
	}

	@Before("p1()")
	public void beginTransaction() {
		System.out.println("Transaction started");
	}
	
	@After("p1()")
	public void emailSetup() {
		System.out.println("Email setup is done");
	}

	@AfterReturning(value ="p1()",returning = "obj")
	public void commitTransaction(Object obj) {
		System.out.println("Transaction commited"+obj);
	}

	@AfterThrowing(value ="p1()",throwing = "obj")
	public void rollback(Throwable obj) {
		System.out.println("Transaction rollbacked "+obj.getMessage());
	}
	
	@Around("p1()")
	public void aroundAdvice(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("Before Transaction");
		Object obj=jp.proceed();
		System.out.println("Method returned "+obj);
		System.out.println("After Transaction");
	}
}
