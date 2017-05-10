package org.cat.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.cat.dao.FriendReqDao;
import org.cat.entities.FriendReq;
import org.cat.utils.DBConnection;

public class FriendReqDaoImpl implements FriendReqDao {

	@Override
	public boolean addAFriendReq(int from, int to) throws SQLException {
		Connection conn = DBConnection.getConnection();
		String sql = "insert into friend_req(user_id,req_from)values(?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, to);
		pstmt.setInt(2, from);
		int rs = pstmt.executeUpdate();
		if(rs != 0) return true;
		return false;
	}

	@Override
	public boolean deleteFriendReq(int userId, int from) throws SQLException {
		Connection conn = DBConnection.getConnection();
		String sql = "delete from friend_req where user_id = ? and req_from = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, userId);
		pstmt.setInt(2, from);
		int rs = pstmt.executeUpdate();
		if(rs != 0) return true;
		return false;
	}

	@Override
	public List<FriendReq> findSomeByUserId(int userId) throws SQLException {
		Connection conn = DBConnection.getConnection();
		String sql = "select * from friend_req where user_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, userId);
		ResultSet rs = pstmt.executeQuery();
		FriendReq fr = null;
		List<FriendReq> list = new ArrayList<>();
		while(rs.next()){
			fr = new FriendReq();
			fr.setReqId(rs.getInt(1));
			fr.setUserId(rs.getInt(2));
			fr.setReqFrom(rs.getInt(3));
			list.add(fr);
		}
		if(list.isEmpty()) return null;
		return list;
	}

}
