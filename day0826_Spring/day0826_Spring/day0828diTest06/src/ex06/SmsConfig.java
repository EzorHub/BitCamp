package ex06;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SmsConfig {

	@Bean
	public SmsSender sms() {
		SmsSender sms = new SmsSender();
		sms.setFrom("죠르디");
		sms.setTo("앙몬드");
		return sms;
	}
}
