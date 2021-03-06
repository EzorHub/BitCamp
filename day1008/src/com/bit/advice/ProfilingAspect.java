package com.bit.advice;
//annotation기반실험
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ProfilingAspect {
	
	//com.bit.dao - 그룹지어서 일반화 - pointCut
	@Pointcut("execution(public * com.bit.dao..*(..))")
	public void profileTarget() {} //메소드이름이 xml의 id
	
	
	@Around("profileTarget()")
	public Object pro(ProceedingJoinPoint joinPoint) {
		Object ret = null;
		try {
			String methodName = joinPoint.getSignature().toShortString();
			System.out.println(methodName+"이 동작하기 전입니다.");
			long start = System.currentTimeMillis();
			ret = joinPoint.proceed();
			long end = System.currentTimeMillis();
			System.out.println(methodName+"이 동작이 완료되었습니다.");
			System.out.println("걸린시간: "+(end-start)+"초");
			
		}catch (Throwable e) {
			e.printStackTrace();
		}
		return ret;
	}

}
