package com.concerto.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.concerto.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	@AfterThrowing(pointcut = "execution(* com.concerto.aopdemo.dao.AccountDaoImpl.findAccounts(..))", throwing = "exe")
	public void afterThrowingFindAccountAdvice(JoinPoint joinPoint, Throwable exe) {
		// print which mthod we are advising on
		String method = joinPoint.getSignature().toShortString();
		System.out.println("=========> Executing @AfterThrowing on method: " + method);

		// log the exeception
		System.out.println("The exception: " + exe);

	}

	// Add a new advice for @AftrReturning on a findAccounts Method
	@AfterReturning(pointcut = "execution(* com.concerto.aopdemo.dao.AccountDaoImpl.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountAdvice(JoinPoint joinPoint, List<Account> result) {

		// print out which method we are advicing on

		String method = joinPoint.getSignature().toShortString();
		System.out.println("=========> Executing @AfterReturning on method: " + method);

		// print out the result of the method call

		System.out.println("Result is: " + result);

		// lets post process the data: modify it
		// convert the name to uppercase
		convertAccountNamesToUppercase(result);
		System.out.println("Result is: " + result);
	}

	private void convertAccountNamesToUppercase(List<Account> result) {

		// loop through accounts
		for (Account account : result) {
			// get uppercase version of the name
			String uppercase = account.getName().toUpperCase();

			// update the name on account
			account.setName(uppercase);
		}

	}

	@Before("com.concerto.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinpoint) {
		System.out.println("\n =============> executing @Before advice on method ");

		// display method signature
		MethodSignature methodSignature = (MethodSignature) theJoinpoint.getSignature();

		System.out.println(methodSignature);

		// display method Arguments

		// get args
		Object[] args = theJoinpoint.getArgs();

		// loop through args

		for (Object tempArgs : args) {
			System.out.println(tempArgs);

			if (tempArgs instanceof Account) {
				// downcast and print account specific stuff

				Account theAccount = (Account) tempArgs;
				System.out.println(theAccount.getName());
				System.out.println(theAccount.getLevel());

			}
		}
	}

}
