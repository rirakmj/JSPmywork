package com.member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.util.DBConnection;

public class SMemberDAOImpl implements SMemberDAO {
	private static SMemberDAO instance = new SMemberDAOImpl();
	public static SMemberDAO getInstance() {
		return instance;
	}

@Override
public SMemberDTO memberLoginCheck(String userid, String pwd) {
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	SMemberDTO member = new SMemberDTO();
	// ��ȸ�� (-1)
	member.setAdmin(-1);
	// �Ϲ�ȸ��, ������(1)
	// ȸ�������� ��� ����(2)
	
	try {
		con = DBConnection.getConnection();
		String sql = "select * from memberdb where userid = '"+userid+"'";
		st = con.createStatement();
		rs = st.executeQuery(sql);
		if(rs.next()) { // id���� (ȸ���� ����)
			if(rs.getString("pwd").equals(pwd)) { // ��� ����
				member.setAdmin(rs.getInt("admin"));
				member.setEmail(rs.getString("email"));
				member.setName(rs.getString("name"));
				member.setPhone(rs.getString("phone"));
				member.setPwd(rs.getString("pwd"));
				member.setUserid(rs.getString("userid"));
			} else { // ��� Ʋ��
				member.setAdmin(2); } 
		}} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, rs);
		}
}
	@Override
	public void memberJoin(SMemberDTO member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<SMemberDTO> getMember() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int memberDelete(String userid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int memberUpdate(SMemberDTO member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SMemberDTO findById(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int memberCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String memberIdCheck(String userid) {
		// TODO Auto-generated method stub
		return null;
	}
	private void closeConnection(Connection con, PreparedStatement ps, Statement st, ResultSet rs) {
		try {
			if(con !=null) 			con.close();
			if(ps !=null) 				ps.close();
			if(st !=null) 				st.close();
			if(rs !=null) 				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	  
	}
}
