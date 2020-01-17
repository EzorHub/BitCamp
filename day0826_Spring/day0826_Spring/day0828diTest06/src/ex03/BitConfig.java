package ex03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BitConfig {

	@Bean
	public MemberDao dao() {
		MemberDao member = new MemberDao();
		member.setUrl("bit/member/");
		member.setUser("hoit");
		member.setPwd("1234");
		return member;
	}
	
	@Bean 
	public MemberService ms() {
		
		MemberService m = new MemberService("¶ÇÄ¡", 18, dao());		
		
		return m;
	}
}
