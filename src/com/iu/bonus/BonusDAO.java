package com.iu.bonus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iu.util.DBConnector;

public class BonusDAO {
	//하나의 보너스 정보 선택
	public BonusDTO bonusSelectOne(String ename) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		BonusDTO bonusDTO = null;

		try {
			con = DBConnector.getConnect();

			String sql = "SELECT * FROM bonus "
					+ "WHERE ename = ?";

			st = con.prepareStatement(sql);
			st.setString(1, ename);

			rs = st.executeQuery();

			if (rs.next()) {
				bonusDTO = new BonusDTO();
				bonusDTO.setEname(rs.getString("ename"));
				bonusDTO.setJob(rs.getString("job"));
				bonusDTO.setSal(rs.getInt("sal"));
				bonusDTO.setComm(rs.getInt("comm"));

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

		return bonusDTO;

	}

	//전체 bonus 정보
	public List<BonusDTO> bonusSelectList(){
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		BonusDTO bonusDTO = null;
		ArrayList<BonusDTO> ar = new ArrayList<BonusDTO>();

		try {
			con = DBConnector.getConnect();

			String sql = "SELECT * FROM bonus";

			st = con.prepareStatement(sql);
			rs = st.executeQuery();

			while (rs.next()) {
				bonusDTO = new BonusDTO();
				bonusDTO.setEname(rs.getString("ename"));
				bonusDTO.setJob(rs.getString("job"));
				bonusDTO.setSal(rs.getInt("sal"));
				bonusDTO.setComm(rs.getInt("comm"));

				ar.add(bonusDTO);
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
	}//bonusSelectList

	//bonus 값 추가
	public int bonusInsert() {
		Connection con = null;
		PreparedStatement st = null;
		
		BonusDTO bonusDTO = new BonusDTO();
		int result = 0;
		try {
			con = DBConnector.getConnect();

			String sql = "INSERT INTO bonus (ename, job, sal, comm) "
					+ "VALUES(?, ?, ?, ?)";

			st = con.prepareStatement(sql);

			st.setString(1, bonusDTO.getEname());
			st.setString(2, bonusDTO.getJob());
			st.setInt(3, bonusDTO.getSal());
			st.setInt(4, bonusDTO.getComm());

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
		}//try catch
		return result;
	}//bonusInsert

	//bonus 정보 삭제
	public int bonusDelete(String ename) {
		Connection con = null;
		PreparedStatement st = null;

		int result = 0;


		try {
			con = DBConnector.getConnect();

			String sql = "DELETE FROM bonus "
					+ "WHERE dname = ?";

			st = con.prepareStatement(sql);
			st.setString(1, ename);

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
		}//
		return result;
	}//bonus delete


}//class BonusDAO
