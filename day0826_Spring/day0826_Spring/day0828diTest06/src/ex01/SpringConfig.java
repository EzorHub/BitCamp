package ex01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

	@Bean
	public MemberService ms() {
		MemberService m = new MemberService();
		
		m.setInfo(updateInfo());
		
		return m;
	}
	
	@Bean
	public UpdateInfo updateInfo() {
		UpdateInfo info = new UpdateInfo();
		
		info.setId("hoit");
		
		return info;
	}
}
