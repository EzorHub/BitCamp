package com.bit.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.bit.advice.ProfilingAspect;
import com.bit.dao.BoardDao;
import com.bit.dao.MemberDao;
import com.bit.util.HelloUtil;

@Configuration
@EnableAspectJAutoProxy
public class MainConfig {

		//메소드이름이 id
	@Bean
	public ProfilingAspect aspect() {
		return new ProfilingAspect();
	}
	
	@Bean
	public BoardDao boardDao() {
		return new BoardDao();		
	}
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	@Bean
	public HelloUtil helloUtil() {
		return new HelloUtil();
	}
}
