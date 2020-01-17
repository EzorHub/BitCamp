package com.bit.book;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.BookDao;
import com.bit.vo.BookVo;

/**
 * Servlet implementation class ListBook
 */

public class ListBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		BookDao dao = new BookDao();
		ArrayList<BookVo> list = dao.listAll();
		String str = "";
		str += "<table>";
		str += "<tr>";
		str += "<td>도서번호</td><td>도서명</td><td>출판사</td><td>가격</td>";
		str += "</tr>";

		for (BookVo b : list) {
			str += "<tr>";
			str += "<td>" + b.getBookid() + "</td><td>" + b.getBookname() + "</td><td>" + b.getPublisher() + "</td><td>"
					+ b.getPrice() + "</td>";
			str += "</tr>";

		}

		str += "</table>";

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(str);
		out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
