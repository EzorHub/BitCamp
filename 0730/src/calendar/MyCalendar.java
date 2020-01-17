package calendar;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyCalendar
 */
@WebServlet("/calendar.do")
public class MyCalendar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyCalendar() {
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
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String str = "";

		int[] lastDay = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		Date today = new Date();
		int year = today.getYear();
		int month = today.getMonth();

		if (request.getParameter("year") != null) {
			year = Integer.parseInt(request.getParameter("year"));
		}

		if (request.getParameter("month") != null) {
			month = Integer.parseInt(request.getParameter("month"));
		}

		if (month == 12) {
			month = 0;
			year++;
		}

		Date startDay = new Date(year, month, 1);
		int blank = startDay.getDay();

		int last = lastDay[month];

		str += "<h2>" + (year + 1900) + "년 " + (month + 1) + "월</h2>";
		str += "<table border=1>";
		str += "<tr>";
		str += "<td>일</td>";
		str += "<td>월</td>";
		str += "<td>화</td>";
		str += "<td>수</td>";
		str += "<td>목</td>";
		str += "<td>금</td>";
		str += "<td>토</td>";
		str += "</tr>";

		str += "<tr>";
		for (int j = 1; j <= blank; j++) {
			str += "<td></td>";
		}

		for (int i = 1; i <= last; i++) {
			str += "<td>" + i + "</td>";
			if ((i + blank) % 7 == 0) {
				str += "</tr>";
				str += "<tr>";
			}
		}
		str += "</tr>";

		str += "</table>";
		str += "<br>";

		str += "<a href='calendar.do?year=" + year + "&month=" + (month + 1) + "'>다음달</a>";

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
