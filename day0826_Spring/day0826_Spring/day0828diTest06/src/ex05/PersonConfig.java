package ex05;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonConfig {

	@Bean
	public Person person() {
		Person p = new Person();
		p.setName("ÁÒ¸£µð");
		p.setAge(5);
		
		return p;
	}
}
