package ex;

public class SumAveError {

	public static void main(String[] args) {
		// 2개의 변수 x와 y의 합과 평균 출력
		int x; 
		int y;
		
		x = 63.4;
		y = 18.3;
		
		System.out.println("x값은 "+x+"입니다.");
		System.out.println("y값은 "+y+"입니다.");
		System.out.println("둘의 합계는  "+(x+y)+" 입니다.");
		System.out.println("둘의 평균은  "+(x+y)/2+" 입니다.");
		
		/*
		 * 값이 double인데 int가 어또케되니!
		 * 	Type mismatch: cannot convert from double to int
			Type mismatch: cannot convert from double to int
			
			*/

	}

}
