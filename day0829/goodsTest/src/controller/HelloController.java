package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@ResponseBody //�� ���ڸ� ��ȯ����.........�°�..��?
	@RequestMapping("/hello.do")
	public String hello() {
		return "BOB of BITCAMP";
	}
}
