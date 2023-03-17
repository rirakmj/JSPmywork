package com.board.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardDTO;
import com.board.model.PagingDTO;
import com.board.model.SBoardDAO;
import com.board.model.SBoardDAOImpl;

/**
 * Servlet implementation class ListController
 */
@WebServlet("/board/list")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String pageNum = request.getParameter("pageNum");
		if(pageNum==null) {
			pageNum = "1";
		}
		String field="";
		String word="";
		if(request.getParameter("word")!=null) {
			field = request.getParameter("field");
			word = request.getParameter("word");
		}
		int currentPage = Integer.parseInt(pageNum); // 현재페이지
		int pageSize = 5; // 한 화면에 보여지는 게시물 수
		int startRow = (currentPage-1) * pageSize +1; // 시작은 1
		int endRow = currentPage * pageSize;
		SBoardDAO sdao = SBoardDAOImpl.getInstance();
		ArrayList<BoardDTO>  arr =  sdao.boardList(startRow, endRow, field, word);
		int count = sdao.boardCount(field, word);
		
		
		if(count > 0) {
			int pageCount = count / pageSize + (count%pageSize ==0 ? 0 : 1);
			int blockPage = 3;
			int startPage = (int)((currentPage-1)/blockPage) * blockPage +1; // (7-1)/3 -> 2*3+1 ->
			int endPage = startPage+blockPage-1; // 7+3-1 = 9
			if(endPage > pageCount){
				endPage = pageCount;
			}
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("blockPage", blockPage);
			request.setAttribute("startPage", startPage);
		    request.setAttribute("endPage", endPage);
		}
		    request.setAttribute("boards", arr);
			request.setAttribute("count", count);
			request.setAttribute("field", field);
			request.setAttribute("word", word);
			request.setAttribute("currentPage", currentPage);
			request.getRequestDispatcher("/board/boardList.jsp").forward(request, response);
		}
		
		
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
