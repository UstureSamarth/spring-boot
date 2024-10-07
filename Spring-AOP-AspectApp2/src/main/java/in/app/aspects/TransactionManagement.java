package in.app.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionManagement {

	@Pointcut("@annotation(in.app.annotation.MyTransaction)")
	public void p1() {
	}

	@Before("p1()")
	public void beginTransaction() {
		System.out.println("Transaction started");
	}
	
	@After("p1()")
	public void emailSetup() {
		System.out.println("Transaction Finished");
	}

	
}
