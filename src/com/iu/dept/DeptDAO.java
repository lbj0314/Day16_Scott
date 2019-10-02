package com.iu.dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iu.util.DBConnector;

public class DeptDAO {
	
	//부서 정보 삭제
	public int delete(int deptno) {
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;
		
		try {
			con=DBConnector.getConnect();
			String sql = "DELETE dept WHERE deptno = ?";
			st=con.prepareStatement(sql);
			
			st.setInt(1, deptno);
			
			result = st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	//정보 삽입
	public int deptInsert(DeptDTO deptDTO) {
		
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;
		try {
			con = DBConnector.getConnect();
			String sql = "INSERT INTO dept (deptno, dname, loc) "
					+ "VALUES (?, ?, ?)";
			
			st = con.prepareStatement(sql);
			
			st.setInt(1, deptDTO.getDeptno());
			st.setString(2, deptDTO.getDname());
			st.setString(3, deptDTO.getLoc());
			
			result = st.executeUpdate();
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	public DeptDTO deptSelectOne(int deptno) {
		DeptDTO deptDTO = null;
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			con = DBConnector.getConnect();
			
			String sql = "SELECT * from dept "
					+ "WHERE deptno = ?";
			
			st = con.prepareStatement(sql);
			st.setInt(1, deptno);
			
			rs = st.executeQuery();
			
			if (rs.next()) {
				deptDTO = new DeptDTO();
				deptDTO.setDeptno(rs.getInt("deptno"));
				deptDTO.setDname(rs.getString("dname"));
				deptDTO.setLoc(rs.getString("loc"));
				
			}//if
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return deptDTO;
	}//deptSelectOne
	
	//selectList
	public List<DeptDTO> deptSelectList(){
		ArrayList<DeptDTO> ar = new ArrayList<DeptDTO>();
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			con = DBConnector.getConnect();
			String sql = "SELECT * FROM dept "
					+ "ORDER BY deptno ASC";
			st = con.prepareStatement(sql);
			
			rs = st.executeQuery();
			
			while (rs.next()) {
				DeptDTO deptDTO = new DeptDTO();
				deptDTO.setDeptno(rs.getInt("deptno"));
				deptDTO.setDname(rs.getString("dname"));
				deptDTO.setLoc(rs.getString("loc"));
				
				ar.add(deptDTO);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ar;

	}
	
}//class DeptDAO
