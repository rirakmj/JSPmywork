package com.addr.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.addr.model.AddrDTO;
import com.addr.model.SAddrDAO;
import com.addr.model.SAddrDAOImpl;

/**
 * Servlet implementation class InsertController
 */
@WebServlet("/addr/insert.addr")
public class InsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("addrInsert.jsp");
		rd.forward(request, response); // 이것만 놔두면 새로고침해도 추가가 된다, 주소가 바뀌지 않는다 (관계가 유지되므로)
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		AddrDTO addr = new AddrDTO();
		addr.setName(request.getParameter("name"));
		addr.setAddr(request.getParameter("addr"));
		addr.setZipcode(request.getParameter("zipcode"));
		addr.setTel(request.getParameter("tel"));
		
		SAddrDAO dao = SAddrDAOImpl.getInstance();
		dao.addrInsert(addr);
		
		response.sendRedirect("list.addr"); // 주소 변경됨
	}

}
