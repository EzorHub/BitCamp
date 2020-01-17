package ex07;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SystemConfig {

	@Bean(initMethod = "monitor") //config읽어들이는 순간 이닛생성!
	@Scope(value = "prototype")
	public SystemMonitor sm() {
		SystemMonitor sm = new SystemMonitor();
		sm.setPeriodTime(7);
		return sm;
	}

}
