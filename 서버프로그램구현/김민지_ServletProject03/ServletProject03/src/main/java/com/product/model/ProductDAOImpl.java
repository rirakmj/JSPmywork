package com.product.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.util.DBConnection;

public class ProductDAOImpl implements ProductDAO {
	private static ProductDAO instance = new ProductDAOImpl();
	public static ProductDAO getInstance() {
		return instance;
	}

	@Override
	public void productInsert(Product product) {
		Connection con = null;
		PreparedStatement ps = null;	
		
		try {
			con = DBConnection.getConnection();
			String sql = "insert into product values(product_seq.nextval,?,?,?,?,?,?,?,?)";
//			StringBuilder sb = new StringBuilder();
//			sb.append("insert into product");
//			sb.append("(p_productId,p_pname,p_unitprice,p_description,p_category,p_manufacturer ");
//			sb.append(" p_unitsInStock, p_condition, p_fileName)");
//			sb.append(" values(product_seq.nextval,?,?,?,?,?,?,?,?)");
			ps=con.prepareStatement(sql);
			ps.setString(1, product.getPname());
			ps.setInt(2, product.getUnitPrice());
			ps.setString(3, product.getDescription());
			ps.setString(4, product.getCategory());
			ps.setString(5, product.getManufacturer());
			ps.setLong(6, product.getUnitsInStock());
			ps.setString(7, product.getCondition());
			ps.setString(8, product.getFilename());
			ps.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, ps, ps, null);
		}
		
	}

	@Override
	public ArrayList<Product> productAllfind() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Product> arr = new ArrayList<>();
		
		try {
			con=DBConnection.getConnection();
		String sql="select * from product";
		st = con.createStatement();
		rs = st.executeQuery(sql);
		while(rs.next()) {
			Product pd = new Product();
			pd.setProductId(rs.getLong("p_productid"));
			pd.setPname(rs.getString("p_pname"));
			pd.setUnitPrice(rs.getInt("p_unitprice"));
			pd.setDescription(rs.getString("p_description"));
			pd.setManufacturer(rs.getString("p_manufacturer"));
			pd.setCategory(rs.getString("p_category"));
			pd.setUnitsInStock(rs.getLong("p_unitsinstock"));
			pd.setCondition(rs.getString("p_condition"));
			pd.setFilename(rs.getString("p_filename"));
			arr.add(pd);
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		closeConnection(con, null, st, rs);
	}
		return arr;
}

	@Override
	public Product findById(Long productId) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		Product product = null;
		
		try {
			con=DBConnection.getConnection();
			st = con.createStatement();
			rs = st.executeQuery("select * from product where p_productid="+productId);
			if(rs.next()) {
				product = new Product();
				product.setCategory(rs.getString("p_category"));
				product.setCondition(rs.getString("p_condition"));
				product.setDescription(rs.getString("p_description"));
				product.setManufacturer(rs.getString("p_manufacturer"));
				product.setPname(rs.getString("p_pname"));
				product.setProductId(rs.getLong("p_productid"));
				product.setUnitPrice(rs.getInt("p_unitprice"));
				product.setUnitsInStock(rs.getLong("p_unitsinstock"));
				product.setFilename(rs.getString("p_filename"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, rs);
		}
		return product;
	}

	private void closeConnection(Connection con, PreparedStatement ps, Statement st, ResultSet rs) {
		try {
			if(con !=null) con.close();
			if(ps !=null) ps.close();
			if(st !=null) st.close();
			if(rs !=null) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	  }
	}
