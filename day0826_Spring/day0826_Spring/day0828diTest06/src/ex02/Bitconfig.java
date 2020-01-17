package ex02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//환경설정환경설정 - 객체를 제공해주는 xml역할만 할뿐
@Configuration
public class Bitconfig {

	@Bean
	public SmsSender sender() {
		SmsSender sms = new SmsSender();
		sms.setFrom("라이언");
		sms.setTo("튜브");		
		return sms;
	}
	@Bean
	public SystemMonitor sm() {
		SystemMonitor sm = new SystemMonitor();
		
		sm.setPeriodTime(3);		
		sm.setSender(sender());//***********객체를 호출해줘야함 만드는게 아니라**********ref느낌?
		return sm;
	}
}
