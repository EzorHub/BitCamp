package ex16;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BitConfig {
	@Bean
	public Person p1() {
		
		Person p = new Person();
		p.setName("����");
		p.setAge(27);
		
		return p;
	}
}
