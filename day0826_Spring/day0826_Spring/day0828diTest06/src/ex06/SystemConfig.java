package ex06;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SystemConfig {

	@Bean(autowire = Autowire.BY_TYPE)
	public SystemMonitor sm() {
		SystemMonitor sm = new SystemMonitor();
		sm.setPeriodTime(7);
		return sm;
	}
}
