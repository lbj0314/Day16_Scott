package com.iu.input;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.iu.emp.EmpDTO;
import com.iu.util.DBConnector;

public class EmpInput {
	private Scanner sc;
	public EmpInput(){
		sc = new Scanner(System.in);
	}
	//empnoInput
	//사원 번호 입력 return empno;
	public EmpDTO empnoInput(int empno) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		EmpDTO empDTO = null;
		
		try {
			con = DBConnector.getConnect();
			
			System.out.println("찾을 사원의 번호를 입력하세요.");
			empno = sc.nextInt();
			
			String sql = "SELECT empno, ename, job, mgr, "
					+ "hiredate, sal, NVL(comm, 0) comm, deptno FROM emp "
					+ "WHERE empno = ?";
			
			st = con.prepareStatement(sql);
			st.setInt(1, empno);
			
			rs = st.executeQuery();
			
			if(rs.next()) {
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
	}//empnoInput
	
}
