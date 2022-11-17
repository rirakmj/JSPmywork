package com.file;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class FileController2
 */
// �迭�ε� ����
@WebServlet("/file2/upload2")
public class FileController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileController2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String savePath = "upload"; // ����� ������ ��ġ (����)
		int uploadFileSizeLimit = 5*1024*1024; // �ִ� 5MB�� ����
		String encType = "utf-8";
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath); // ���� ���
		System.out.println("�������� ���� ���丮 : " + uploadFilePath);
		
		MultipartRequest multi = new MultipartRequest( // ��ü ����
			request, // request��ü
			uploadFilePath, // �������� ���� ���丮
			uploadFileSizeLimit, // �ִ� ���ε� ���� ũ��
			encType, // ���ڵ�
			new DefaultFileRenamePolicy()); // ���� �̸� ������ �� �� �̸� �ο�
			
		// ���ε��� ���� �̸�
			String fileName = multi.getFilesystemName("uploadFile");
			if(fileName == null) fileName="";
			String name = multi.getParameter("name");
			String title = multi.getParameter("title");
			String image = fileName;
			FileDTO file = new FileDTO(name, title, image);
			FileDAO dao = FileDAO.getInstance();
			dao.fileInsert(file);
			response.sendRedirect("imageList"); // imageList�� ��Ʈ�ѷ��� �̸�
		
	}

}
