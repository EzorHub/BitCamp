package com.bit.advice;
import org.aspectj.lang.JoinPoint;
//xml���
import org.aspectj.lang.ProceedingJoinPoint;

/*around advice�� ������ ������ advice����
 *joinPoint�� ���������� ����
 *�ٽ�Ÿ���� �Ǵ� �޼ҵ��� ������ �ʿ��ϴٸ�
 *joinPoint�� �Ű������� ����
 **�׷��� ������ ���� ����!
 *�׷��� aroundAdvice�� Ÿ���� �Ǵ� �޼ҵ尡 
 *�����ϱ����� ó���� �ϵ� �ְ�
 *Ÿ���� �Ǵ� �޼ҵ尡 ������ �Ŀ� ���ϵ� �ֱ⶧����
 *advice�ȿ��� Ÿ���� �Ǵ� �޼ҵ带 ȣ���������
 *joinPoint�� ���ؼ� Ÿ���� �Ǵ� �޼ҵ带 ȣ��
 *aroundAdvice�� �ݵ�� joinPoint�� �Ű������� ��������
 **/
public class ProfilingAdvice {
	//���ܰ� ���� Ÿ�꿡�� ����Ǵ� �޼ҵ�
	public void afterThrowing() { //���Ĵ� �������� ����~~!
		System.out.println("Ÿ��޼ҵ� ������ ���ܰ� �߻��߽��ϴ�.");
	}
	//------------------------------------------------------
	//public void before() {
	public void before(JoinPoint joinPoint) { //�Ű����� �ǹ��ƴϾ �Ȱ������� - but ���������� ���оȵǴϱ� joinPoint������
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println(methodName+"���� ���Դϴ�.");
	}
	//------------------------------------------------------
	public Object pro(ProceedingJoinPoint joinPoint) {//�ٽɰ��ɻ��׿� ���� ������?�ľǰ���
		Object re = null;
		try {
			//Ÿ���� �Ǵ� �޼ҵ� �����ϱ� ���� ���ϵ�
			long start = System.currentTimeMillis();
			
			String methodName = joinPoint.getSignature().toShortString();
			System.out.println(methodName+"�� �����ϱ� ���Դϴ�.");
			
			re = joinPoint.proceed();
			long end = System.currentTimeMillis();			
			//Ÿ���� �Ǵ� �޼ҵ� ������ �Ŀ� ���ϵ�
			System.out.println(methodName+"�� ������ ���Դϴ�.");
			System.out.println("�ɸ��ð�: "+(end-start)+"��");
		}catch (Throwable e) {
			e.printStackTrace();
		}
		return re;
	}
}
