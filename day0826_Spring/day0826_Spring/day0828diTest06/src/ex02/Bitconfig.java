package ex02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//ȯ�漳��ȯ�漳�� - ��ü�� �������ִ� xml���Ҹ� �һ�
@Configuration
public class Bitconfig {

	@Bean
	public SmsSender sender() {
		SmsSender sms = new SmsSender();
		sms.setFrom("���̾�");
		sms.setTo("Ʃ��");		
		return sms;
	}
	@Bean
	public SystemMonitor sm() {
		SystemMonitor sm = new SystemMonitor();
		
		sm.setPeriodTime(3);		
		sm.setSender(sender());//***********��ü�� ȣ��������� ����°� �ƴ϶�**********ref����?
		return sm;
	}
}
