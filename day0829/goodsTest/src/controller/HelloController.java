package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@ResponseBody //이 글자를 반환해주.........는거..야?
	@RequestMapping("/hello.do")
	public String hello() {
		return "BOB of BITCAMP";
	}
}
