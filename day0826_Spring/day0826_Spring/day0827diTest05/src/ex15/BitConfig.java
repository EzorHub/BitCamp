package ex15;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //ȯ�漳�������̿��� - .xml ����Դϴ�
public class BitConfig {

	@Bean
	public MemberService member1() {
		
		return new MemberService(); 
	}
	
}
