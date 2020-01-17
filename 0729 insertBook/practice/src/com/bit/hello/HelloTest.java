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

	// get��Ŀ� ���� ó���� ���� �޼ҵ�
	// �ּ�ǥ���ٿ� �ּҸ� ���� �Է��ϰų� a �±׷� ����Ǵ� �����
	// get����Դϴ�.
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get����� �Ű������� request�� response�� ������
		// request�� ������� ��û������ ��� �־��.
		// respone�� ������ ���� ��ü�Դϴ�.
		// ����ڰ� get������� ��û�ϸ� ��������
		// "get������� ��û�߾��"��� ����ϰ�
		// post������� ��û�ϸ�
		// "post ������� ��û�߾��"��� �������� ��� �� ���ô�.
		// "����Ѵ�"��� ���� html�� ����� ����ϴ� ����
		// ���մϴ�. ����Ϸ��� ������ ���� reponse�� ����
		// ����� ���� stream�� ���� �ؿ�.
		// �� ����ϱ� ���� response�� ���� �������� html��
		// �Ұ��̴ٶ�� �����ؾ� �ؿ�.

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("get������� ��û�߾��!");
		out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// post��Ŀ� ���� ó���� ���� �޼ҵ�
	// <form method="post">�� ���ؼ� ��û�Ҷ��� post����Դϴ�.
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("post������� ��û�߾��!");
		out.close();
	}

}
