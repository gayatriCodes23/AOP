package com.concerto.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

	@Pointcut("execution (* com.concerto.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {
	}
	
	//create a pointcut for getter
	@Pointcut("execution (* com.concerto.aopdemo.dao.*.get*(..))")
	public void getter() {}

	//create a pointcut for setter
	@Pointcut("execution (* com.concerto.aopdemo.dao.*.set*(..))")
	public void setter() {}

	//create a pointcut: Include package.. exclude  getter/setter
	@Pointcut("forDaoPackage() && !(getter() ||  setter())")
	public void forDaoPackageNoGetterSetter() {}
	

}
