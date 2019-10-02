package com.iu.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iu.util.DBConnector;

public class EmpDAO {
	
	public int delete(int empno) {
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;
		
		try {
			con=DBConnector.getConnect();
			String sql = "delete emp where empno=?";
			st=con.prepareStatement(sql);
			
			st.setInt(1, empno);
			
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
	
	public int empInsert(EmpDTO empDTO) {
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;
		try {
			con = DBConnector.getConnect();
			String sql = "INSERT INTO emp (empno, ename, job, mgr, "
					+ "hiredate, sal, comm, deptno) "
					+ "VALUES(?, ?, ? ,? ,sysdate ,?, ?, ?)";

			st = con.prepareStatement(sql);

			st.setInt(1, empDTO.getEmpno());
			st.setString(2, empDTO.getEname());
			st.setString(3, empDTO.getJob());
			st.setInt(4, empDTO.getMgr());
//			st.setDate(5, empDTO.getHiredate());
			st.setInt(5, empDTO.getSal());
			st.setInt(6, empDTO.getComm());
			st.setInt(7, empDTO.getDeptno());

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

	//getSelectOne, 매개변수 사원번호
	public EmpDTO getSelectOne(int empno) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		EmpDTO empDTO = null;

		try {
			con = DBConnector.getConnect();

			String sql = "SELECT empno, ename, job, mgr, "
					+ "hiredate, sal, NVL(comm, 0) comm, deptno FROM emp "
					+ "WHERE empno = ?";

			st = con.prepareStatement(sql);
			st.setInt(1, empno);

			rs = st.executeQuery();

			if (rs.next()) {
				empDTO = new EmpDTO();
				empDTO.setEmpno(rs.getInt("empno"));
				empDTO.setEname(rs.getString("ename"));
				empDTO.setJob(rs.getString("job"));
				empDTO.setMgr(rs.getInt("mgr"));
				empDTO.setHiredate(rs.getDate("hiredate"));
				empDTO.setSal(rs.getInt("sal"));
				empDTO.setComm(rs.getInt("comm"));
				empDTO.setDeptno(rs.getInt("deptno"));
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
		return empDTO;
	}//getSelectOne

	public ArrayList<EmpDTO> getSelectList() {
		//전체 사원 정보 - 최신 입사일 순 정렬
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		EmpDTO empDTO = null;
		ArrayList<EmpDTO> ar = new ArrayList<EmpDTO>();
		try {
			con = DBConnector.getConnect();
			String sql = "SELECT empno, ename, job, mgr, "
					+ "hiredate, sal, NVL(comm, 0) comm, deptno FROM emp "
					+ "ORDER BY empno ASC";

			st = con.prepareStatement(sql);

			rs = st.executeQuery();

			while (rs.next()) {
				empDTO = new EmpDTO();
				empDTO.setEmpno(rs.getInt("empno"));
				empDTO.setEname(rs.getString("ename"));
				empDTO.setJob(rs.getString("job"));
				empDTO.setMgr(rs.getInt("mgr"));
				empDTO.setHiredate(rs.getDate("hiredate"));
				empDTO.setSal(rs.getInt("sal"));
				empDTO.setComm(rs.getInt("comm"));
				empDTO.setDeptno(rs.getInt("deptno"));

				ar.add(empDTO);

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
	
	public ArrayList<EmpDTO> enameSelect(String ename) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		EmpDTO empDTO = null;
		ArrayList<EmpDTO> ar = new ArrayList<EmpDTO>();
		try {
			con = DBConnector.getConnect();
			
			String sql = "SELECT * FROM emp "
					+ "WHERE ename LIKE ?";
//			'%?%'
			st = con.prepareStatement(sql);
			st.setString(1, "%"+ename+"%");
			
			rs = st.executeQuery();
			
			while (rs.next()) {
				empDTO = new EmpDTO();
				empDTO.setEmpno(rs.getInt("empno"));
				empDTO.setEname(rs.getString("ename"));
				empDTO.setJob(rs.getString("job"));
				empDTO.setMgr(rs.getInt("mgr"));
				empDTO.setHiredate(rs.getDate("hiredate"));
				empDTO.setSal(rs.getInt("sal"));
				empDTO.setComm(rs.getInt("comm"));
				empDTO.setDeptno(rs.getInt("deptno"));
				
				ar.add(empDTO);
				
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
}
