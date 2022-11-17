package com.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.member.dto.MemberDTO;

public class MemberDAOImpl implements MemberDAO {
	private static MemberDAO instance = new MemberDAOImpl(); // 객체로 생성
	public static MemberDAO getInstance() {
		return instance;
	}
	//디비연결
	private  Connection getConnection() throws Exception {
		Context  initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource  ds = (DataSource)envCtx.lookup("jdbc/jsp");
		return ds.getConnection();
	}

	@Override
	public void memberInsert(MemberDTO member) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			String sql = "insert into MEMBERDB values(?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getName());
			ps.setString(2, member.getUserid());
			ps.setString(3,  member.getPwd());
			ps.setString(4, member.getEmail());
			ps.setString(5, member.getPhone());
			ps.setInt(6, member.getAdmin());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
	    } finally {
	    	closeConnection(con, ps, null, null);
	    }
	}

	@Override
	public ArrayList<MemberDTO> memberList() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<MemberDTO> mdto = new ArrayList<MemberDTO>();

		try {
			con = getConnection();
			String sql = "select * from memberdb";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				MemberDTO member = new MemberDTO();
				member.setAdmin(rs.getInt("admin"));
				member.setEmail(rs.getString("email"));
				member.setName(rs.getString("name"));
				member.setPhone(rs.getString("phone"));
				member.setUserid(rs.getString("pwd"));
				member.setUserid(rs.getString("userid"));
				mdto.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, rs);
		}
		return mdto;
	}
	
	// 아이디 중복확인
	@Override
	public String idCheck(String userid) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String flag = "yes"; // 사용 가능
		
		try {
			con = getConnection();
			String sql = "select * from memberdb where userid = '"+userid+"'";
//			System.out.println(sql);
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				flag = "no"; // 사용 불가
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, rs);
		}
		return flag;
	}
	
	@Override
	public int getCount() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			con = getConnection();
			String sql = "select count(*) from memberdb";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				count = rs.getInt(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, null, st, rs);
			}
		return count;
		}

	@Override
	public void memberUpdate(MemberDTO member) {
		Connection con = null;
		PreparedStatement ps =null;
		
		try {
			con = getConnection();
			String sql="update memberdb set name=?,  pwd=?,"
					+ " admin=?, email=?, phone=? where userid=?";
			ps= con.prepareStatement(sql);
			ps.setString(1, member.getName());
			ps.setString(2, member.getPwd());
			ps.setInt(3, member.getAdmin());
			ps.setString(4, member.getEmail());
			ps.setString(5, member.getPhone());
			ps.setString(6, member.getUserid());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, ps, ps, null);
		}
		
	}

	@Override
	public void memberDelete(String userid) {
		Connection con = null;
		Statement st = null;
		try {
			con =getConnection();
			String sql = "delete from memberdb where userid='"+userid+"'";
			st = con.createStatement();
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, null, st, null);
		}
	}
	
    // 로그인 체크
	@Override
	public int loginCheck(String userid, String pwd) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int flag = -1; // 회원 아님(-1), 회원 성공(0), 비번 오류(2)
		
		try {
			con = getConnection();
			String sql = "select pwd, admin from memberdb where userid='"+userid+"'";
			System.out.println(sql);
//		     + "and pwd='"+pwd+"'"; 로 하면, -1과 2의 구분이 안 됨
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) { // rs가 있다면, 0 또는 2
				if(rs.getString("pwd").equals(pwd)) { // 회원(입력한 비번이 맞는지 검사)
					 flag = rs.getInt("admin");	 // 0 또는 1
				}else { // 회원이지만 비번 오류
					flag = 2;
				}			
			}
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, null);
		}
		return flag;
	}
	
	// 상세보기
	@Override
	public MemberDTO findById(String userid) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		MemberDTO member = new MemberDTO();
		
		try {
			con = getConnection();
			String sql = "select * from memberdb where userid = '"+userid+"'"; 
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				member = new MemberDTO();
				member.setAdmin(rs.getInt("admin"));
				member.setEmail(rs.getString("email"));
				member.setName(rs.getString("name"));
				member.setPhone(rs.getString("phone"));
				member.setPwd(rs.getString("pwd"));		
				member.setUserid(rs.getString("userid"));			
					}
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						closeConnection(con, null, st, null);
					}
		            return member;
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
