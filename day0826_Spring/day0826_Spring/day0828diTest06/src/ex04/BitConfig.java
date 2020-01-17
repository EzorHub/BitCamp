package ex04;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BitConfig {

	@Bean
	public SmsSender sms() {
		SmsSender s = new SmsSender();
		s.setFrom("�Ҹ���");
		s.setTo("�Ӹ��");
		return s;
	}
	
	@Bean(autowire = Autowire.BY_TYPE)
	public SystemMonitor sm() {
		SystemMonitor sm = new SystemMonitor();
		sm.setPeriodTime(7);
		sms(); //sms(); ȣ�����ֱ�**
		return sm;
	} 
}
