package com.bit.advice;
//annotation��ݽ���
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ProfilingAspect {
	
	//com.bit.dao - �׷���� �Ϲ�ȭ - pointCut
	@Pointcut("execution(public * com.bit.dao..*(..))")
	public void profileTarget() {} //�޼ҵ��̸��� xml�� id
	
	
	@Around("profileTarget()")
	public Object pro(ProceedingJoinPoint joinPoint) {
		Object ret = null;
		try {
			String methodName = joinPoint.getSignature().toShortString();
			System.out.println(methodName+"�� �����ϱ� ���Դϴ�.");
			long start = System.currentTimeMillis();
			ret = joinPoint.proceed();
			long end = System.currentTimeMillis();
			System.out.println(methodName+"�� ������ �Ϸ�Ǿ����ϴ�.");
			System.out.println("�ɸ��ð�: "+(end-start)+"��");
			
		}catch (Throwable e) {
			e.printStackTrace();
		}
		return ret;
	}

}
