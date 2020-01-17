package com.bit.advice;
import org.aspectj.lang.JoinPoint;
//xml기반
import org.aspectj.lang.ProceedingJoinPoint;

/*around advice를 제외한 나머지 advice들은
 *joinPoint를 선택적으로 받음
 *핵심타깃이 되는 메소드의 정보가 필요하다면
 *joinPoint를 매개변수로 가짐
 **그렇지 않으면 생략 가능!
 *그러나 aroundAdvice는 타깃이 되는 메소드가 
 *동작하기전에 처리할 일도 있고
 *타깃이 되는 메소드가 동작한 후에 할일도 있기때문에
 *advice안에서 타깃이 되는 메소드를 호출해줘야함
 *joinPoint를 통해서 타깃이 되는 메소드를 호출
 *aroundAdvice는 반드시 joinPoint를 매개변수로 가져야함
 **/
public class ProfilingAdvice {
	//예외가 나는 타깃에만 적용되는 메소드
	public void afterThrowing() { //이후는 동작하지 않음~~!
		System.out.println("타깃메소드 수행중 예외가 발생했습니다.");
	}
	//------------------------------------------------------
	//public void before() {
	public void before(JoinPoint joinPoint) { //매개변수 의무아니어서 안가져도됨 - but 누가누군지 구분안되니까 joinPoint를가짐
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println(methodName+"동작 전입니다.");
	}
	//------------------------------------------------------
	public Object pro(ProceedingJoinPoint joinPoint) {//핵심관심사항에 대한 정보들?파악가능
		Object re = null;
		try {
			//타깃이 되는 메소드 동작하기 전에 할일들
			long start = System.currentTimeMillis();
			
			String methodName = joinPoint.getSignature().toShortString();
			System.out.println(methodName+"이 동작하기 전입니다.");
			
			re = joinPoint.proceed();
			long end = System.currentTimeMillis();			
			//타깃이 되는 메소드 동작한 후에 할일들
			System.out.println(methodName+"이 동작한 후입니다.");
			System.out.println("걸린시간: "+(end-start)+"초");
		}catch (Throwable e) {
			e.printStackTrace();
		}
		return re;
	}
}
