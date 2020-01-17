package ex05;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoConfig {

	@Bean
	public MemberDao member() {
		MemberDao member = new MemberDao();			
		return member;
	}
	@Bean
	public BoardDao board() {
		BoardDao board = new BoardDao();			
		return board;
	}
	
}
