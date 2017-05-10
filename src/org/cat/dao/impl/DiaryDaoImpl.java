package org.cat.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.cat.dao.DiaryDao;
import org.cat.entities.Diary;
import org.cat.utils.DBConnection;

public class DiaryDaoImpl implements DiaryDao {

	@Override
	public List<Diary> getAll() throws SQLException {
		Connection conn = DBConnection.getConnection();
		String sql = "select * from diary";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		List<Diary> list = new LinkedList<>();
		Diary diary = null;
		while(rs.next()){
			diary = new Diary();
			diary.setDiaryId(rs.getInt(1));
			diary.setUserId(rs.getInt(2));
			diary.setYear(rs.getInt(3));
			diary.setMonth(rs.getInt(4));
			diary.setDay(rs.getInt(5));
			diary.setWeek(rs.getInt(6));
			diary.setWeather(rs.getString(7));
			diary.setContent(rs.getString(8));
			diary.setContenType(rs.getString(9));
			list.add(diary);
		}
		//DBConnection.closeConnection();
		if(list.isEmpty()) return null;
		return list;
	}

	@Override
	public List<Diary> getByUserId(int userId) throws SQLException {
		Connection conn = DBConnection.getConnection();
		String sql = "select * from diary where user_id = ?";
		PreparedStatement pstmt =  conn.prepareStatement(sql);
		pstmt.setInt(1, userId);
		ResultSet rs = pstmt.executeQuery();
		
		List<Diary> list = new LinkedList<>();
		Diary diary = null;
		while(rs.next()){
			diary = new Diary();
			diary.setDiaryId(rs.getInt(1));
			diary.setUserId(rs.getInt(2));
			diary.setYear(rs.getInt(3));
			diary.setMonth(rs.getInt(4));
			diary.setDay(rs.getInt(5));
			diary.setWeek(rs.getInt(6));
			diary.setWeather(rs.getString(7));
			diary.setContent(rs.getString(8));
			diary.setContenType(rs.getString(9));
			list.add(diary);
		}
		//DBConnection.closeConnection();
		if(list.isEmpty()) return null;
		return list;
	}

	@Override
	public Diary getById(int diaryId) throws SQLException {
		Connection conn = DBConnection.getConnection();
		String sql = "select * from diary where diary_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, diaryId);
		ResultSet rs = pstmt.executeQuery();
		Diary diary = null;
		if(rs.next()){
			diary = new Diary();
			diary.setDiaryId(rs.getInt(1));
			diary.setUserId(rs.getInt(2));
			diary.setYear(rs.getInt(3));
			diary.setMonth(rs.getInt(4));
			diary.setDay(rs.getInt(5));
			diary.setWeek(rs.getInt(6));
			diary.setWeather(rs.getString(7));
			diary.setContent(rs.getString(8));
			diary.setContenType(rs.getString(9));
		}
		//DBConnection.closeConnection();
		return diary;
	}

	@Override
	public boolean addARecord(Diary diary) throws SQLException {
		Connection conn = DBConnection.getConnection();
		String sql = "insert into diary(user_id,year,month,day,week,weather,content,content_type)values(?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, diary.getUserId());
		pstmt.setInt(2, diary.getYear());
		pstmt.setInt(3, diary.getMonth());
		pstmt.setInt(4, diary.getDay());
		pstmt.setInt(5, diary.getWeek());
		pstmt.setString(6, diary.getWeather());
		pstmt.setString(7, diary.getContent());
		pstmt.setString(8, diary.getContenType());
		int rs = pstmt.executeUpdate();
		//DBConnection.closeConnection();
		if(rs != 0) return true;
		return false;
	}

	@Override
	public boolean deleteByDiaryId(int diaryId) throws SQLException {
		Connection conn = DBConnection.getConnection();
		String sql = "delete from diary where diary_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, diaryId);
		int rs = pstmt.executeUpdate();
		if(rs != 0) return true;
		return false;
	}

	@Override
	public boolean deleteAnyByDiaryIds(List<Integer> diaryIds){
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "delete from diary where diary_id=?";
			PreparedStatement pstmt = null;
			conn.setAutoCommit(false);		//首先关闭自动提交
			for(int diaryId:diaryIds){
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, diaryId);
				pstmt.executeUpdate();
			}
			conn.commit();		//提交事务
			return true;
		} catch (SQLException e) {
			try {
				conn.rollback();	//若是遇到异常,事务回滚
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				conn.setAutoCommit(true);	//打开自动提交
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

}
