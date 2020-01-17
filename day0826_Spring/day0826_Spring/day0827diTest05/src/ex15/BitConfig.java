package ex15;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //환경설정파일이에요 - .xml 대신입니다
public class BitConfig {

	@Bean
	public MemberService member1() {
		
		return new MemberService(); 
	}
	
}
