
package com.iu.salgrade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iu.util.DBConnector;

public class SalgradeDAO {

	//전체등급조회
	public ArrayList<SalgradeDTO> getselectList() {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<SalgradeDTO> ar = new ArrayList<SalgradeDTO>();

		try {
			con = DBConnector.getConnect();
			String sql = "SELECT * FROM salgrade";

			st = con.prepareStatement(sql);

			rs = st.executeQuery();

			while(rs.next()) {

				SalgradeDTO salgradeDTO = new SalgradeDTO();
				salgradeDTO.setGrade(rs.getInt(1));
				salgradeDTO.setLosal(rs.getInt(2));
				salgradeDTO.setHisal(rs.getInt(3));
				ar.add(salgradeDTO);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} return ar;
	}
	//등급하나조회
	public SalgradeDTO salgradeSelectOne(int grade) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		SalgradeDTO salgradeDTO = null;
		try {
			con = DBConnector.getConnect();
			String sql = "SELECT * FROM salgrade "
					+ "WHERE grade = ? ";

			st = con.prepareStatement(sql);

			st.setInt(1, grade);

			rs = st.executeQuery();
			if(rs.next()) {
				salgradeDTO = new SalgradeDTO();
				salgradeDTO.setGrade(rs.getInt("grade"));
				salgradeDTO.setLosal(rs.getInt("losal"));
				salgradeDTO.setHisal(rs.getInt("hisal"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return salgradeDTO;
	}
	//등급추가
	public int SalgradeInsert(SalgradeDTO salgradeDTO) {
		Connection con = null;
		PreparedStatement st = null;

		int result = 0;
		try {
			con = DBConnector.getConnect();
			String sql = "INSERT INTO salgrade (grade, losal, hisal) "
					+ "VALUES(?,?,?)";
			st = con.prepareStatement(sql);
			st.setInt(1, salgradeDTO.getGrade());
			st.setInt(2, salgradeDTO.getLosal());
			st.setInt(3, salgradeDTO.getHisal());
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
	//등급 삭제
	public int salgradeDelete(int grade) {
		Connection con = null;
		PreparedStatement st = null;

		int result = 0;
		try {
			con = DBConnector.getConnect();
			String sql = "DELETE FROM salgrade "
					+ "WHERE grade = ? ";
			st = con.prepareStatement(sql);
			st.setInt(1, grade);
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
	}// salgrade delete

}//class SalgradeDAO