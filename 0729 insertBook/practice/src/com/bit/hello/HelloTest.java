package com.bit.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloTest
 */
@WebServlet("/hello.do")
public class HelloTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HelloTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	// get방식에 대한 처리를 위한 메소드
	// 주소표시줄에 주소를 직접 입력하거나 a 태그로 연결되는 방식이
	// get방식입니다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get방식의 매개변수로 request와 response를 가져요
		// request는 사용자의 요청정보를 담고 있어요.
		// respone은 응답을 위한 객체입니다.
		// 사용자가 get방식으로 요청하면 브라우저에
		// "get방식으로 요청했어요"라고 출력하고
		// post방식으로 요청하면
		// "post 방식으로 요청했어요"라고 브라우저에 출력 해 봅시다.
		// "출력한다"라는 말은 html를 만들어 출력하는 것을
		// 말합니다. 출력하려면 응답을 위한 reponse를 통해
		// 출력을 위한 stream을 얻어야 해요.
		// 또 출력하기 전에 response를 통해 응답방식을 html로
		// 할것이다라고 설정해야 해요.

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("get방식으로 요청했어요!");
		out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// post방식에 대한 처리를 위한 메소드
	// <form method="post">에 의해서 요청할때만 post방식입니다.
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("post방식으로 요청했어요!");
		out.close();
	}

}
