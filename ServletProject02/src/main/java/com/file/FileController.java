package com.file;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class FileController
 */
@WebServlet("/file/upload.do")
public class FileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileController() {
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
		String savePath="upload"; // ����� ������ ��ġ (����)
		int uploadFileSizeLimit = 5*1024*1024; // �ִ� 5MB�� ����
		String encType="utf-8";
		
		ServletContext context = getServletContext();
		String uploadFilePath=context.getRealPath(savePath);
		System.out.println("�������� ���� ���丮:" + uploadFilePath);
		MultipartRequest multi = new MultipartRequest(
				request, // request ��ü 
				uploadFilePath, // �������� ���� ���丮
				uploadFileSizeLimit, // �ִ� ���ε� ����ũ��
				encType, // ���ڵ�
				new DefaultFileRenamePolicy()); // ���� �̸� ������ �� �� �̸� �ο�
		// ���ε��� ���� �̸�
		String fileName= multi.getFilesystemName("uploadFile");
		System.out.println(fileName);
		if(fileName == null) {
			System.out.println("���� ���ε� ����");
		} else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("�۾���: "+multi.getParameter("name")+"<br/>");
			out.println("����: " +multi.getParameter("title")+"<br/>");
			out.println("���ϸ�: " +fileName+"<br/>");
		}
		}
	}
