package com.product.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.product.model.Product;
import com.product.model.ProductDAO;
import com.product.model.ProductDAOImpl;

/**
 * Servlet implementation class ProductInsetController
 */
@WebServlet("/product/pInsert")
public class ProductInsetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductInsetController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("addProduct.jsp").forward(request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String savePath="upload";
		int uploadFileSizeLimit = 5*1024*1024;
		String encType="utf-8";
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		System.out.println("�������� ���� ���丮 :" + uploadFilePath);
		
		MultipartRequest multi = new MultipartRequest( // ��ü ����
				request, // request��ü
				uploadFilePath, // �������� ���� ���丮
				uploadFileSizeLimit, // �ִ� ���ε� ���� ũ��
				encType, // ���ڵ�
				new DefaultFileRenamePolicy()); // ���� �̸� ������ �� �� �̸� �ο�
		// ���ε�� ���� �̸�
		String fileName = multi.getFilesystemName("productImage");
		System.out.println("���ϸ� : " +fileName);
		
		if(fileName == null) fileName="";
		
		ProductDAO dao = ProductDAOImpl.getInstance();
		Product product = new Product();
		product.setCategory(multi.getParameter("category"));
		product.setCondition(multi.getParameter("condition"));
		product.setDescription(multi.getParameter("description"));
		product.setManufacturer(multi.getParameter("manufacturer"));
		product.setPname(multi.getParameter("name"));
		product.setUnitPrice(Integer.parseInt(multi.getParameter("unitPrice")));
		product.setUnitsInStock(Integer.parseInt(multi.getParameter("unitsInStock")));
		product.setFilename(fileName);
		
		dao.productInsert(product);
		response.sendRedirect("plist");
	}

}
