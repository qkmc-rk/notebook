package org.cat.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.cat.dao.UserFriendDao;
import org.cat.entities.UserFriend;
import org.cat.utils.DBConnection;

public class UserFriendDaoImpl implements UserFriendDao{

	/*
	 * @return 是否添加好友成功
	 * @description  添加好友是一个双向过程,a添加b为好友,那么b的好友属性中也应该有a,所以需要添加两次,userid和friendid互换
	 * 
	 * */
	@Override
	public boolean addAFriendByFriendId(int userId, int friendId){
		Connection conn = null;
		String sql = "insert into user_friend(user_id,friend_id)values(?,?)";
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);		//设置手动提交事务
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			pstmt.setInt(2, friendId);
			pstmt.executeUpdate();
			//好友的情况是相互添加,这里需要添加两次,id互换
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, friendId);
			pstmt.setInt(2, userId);
			pstmt.executeUpdate();
			conn.commit();
			return true;
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				DBConnection.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}

	@Override
	public boolean deleteAFriendByFriendId(int userId, int friendId) {
		Connection conn = null;
		String sql = "delete from user_friend where user_id = ? and friend_id = ?";
		PreparedStatement pstmt = null;
		try {
			 conn = DBConnection.getConnection();
			 conn.setAutoCommit(false);     //设置手动提交事务
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setInt(1, userId);
			 pstmt.setInt(2, friendId);
			 pstmt.executeUpdate();
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setInt(1, friendId);
			 pstmt.setInt(2, userId);
			 pstmt.executeUpdate();
			 conn.commit();
			 
			 return true;
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				DBConnection.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public List<UserFriend> findAll(int userId) throws SQLException {
		Connection conn = DBConnection.getConnection();
		String sql = "select * from user_friend where user_id = ?";
		List<UserFriend> list = new LinkedList<>();
		UserFriend uf = null;
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, userId);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			uf = new UserFriend();
			uf.setUser_friend_id(rs.getInt(1));
			uf.setUser_id(rs.getInt(2));
			uf.setFriend_id(rs.getInt(3));
			list.add(uf);
		}
		if(list.isEmpty()) return null;
		return list;
	}
}



