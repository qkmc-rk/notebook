package org.cat.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.cat.dao.UserDao;
import org.cat.entities.User;
import org.cat.utils.DBConnection;

public class UserDaoImpl implements UserDao {

	@Override
	public User findUserByAccount(String userAccount) throws SQLException {
		Connection conn = getConn();		//使用一个简单的方法封装去掉try catch 让它看起来简单优美 created by ruank.
		String sql = "select * from t_user where user_account = '"+userAccount+"'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		User user = null;
		if(rs.next()){
			user = new User();
			user.setAge(rs.getInt(6));
			user.setSex(rs.getString(5));
			user.setUserAccount(rs.getString(3));
			user.setUserId(rs.getInt(1));
			user.setUserName(rs.getString(2));
			user.setUserPassword(rs.getString(4));
		}
		//conn.close();
		return user;
	}

	@Override
	public List<User> findAll() throws SQLException {
		Connection conn = getConn();
		//TO DO ..... waiting for me.....2017-05-06
		//ok go on2017-05-07-9:17
		String sql = "select * from t_user";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		//创建一个user,一个list,用于遍历结果集
		User user;
		List<User> list = new ArrayList<>();
		while(rs.next()){
			user = new User();
			user.setAge(rs.getInt(6));
			user.setSex(rs.getString(5));
			user.setUserAccount(rs.getString(3));
			user.setUserId(rs.getInt(1));
			user.setUserName(rs.getString(2));
			user.setUserPassword(rs.getString(4));
			list.add(user);
			//清空一下user
			user = null;
		}
		//如果在数据库中没有找到用户,就返回null,而不是被初始化的list
		//conn.close();
		if(list.isEmpty()) return null;
		return list;
	}
	@Override
	public User findByUserId(int userId) throws SQLException {
		Connection conn = getConn();		//使用一个简单的方法封装去掉try catch 让它看起来简单优美 created by ruank.
		String sql = "select * from t_user where user_id = "+userId;
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		User user = null;
		while(rs.next()){
			user = new User();
			user.setAge(rs.getInt(6));
			user.setSex(rs.getString(5));
			user.setUserAccount(rs.getString(3));
			user.setUserId(rs.getInt(1));
			user.setUserName(rs.getString(2));
			user.setUserPassword(rs.getString(4));
		}
		//conn.close();
		return user;
	}

	@Override
	public boolean addAUser(User user) throws SQLException {
		Connection conn = getConn();
		String sql = "insert into t_user(user_name,user_account,user_password,user_sex,user_age)values(?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		//设置参数
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getUserAccount());
		pstmt.setString(3, user.getUserPassword());
		pstmt.setString(4, user.getSex());
		pstmt.setInt(5, user.getAge());
		int rs = pstmt.executeUpdate();
		//conn.close();
		//执行成功返回true
		if(rs != 0)return true;
		return false;
	}

	@Override
	public boolean UpdateUser(User user) throws SQLException {
		Connection conn = getConn();
		int userId = user.getUserId();
		//如果没有userId,说明操作是有误的!
		if(userId <= 0) return false;
		
		String sql = "update t_user set user_name = ? ,user_password = ? ,user_sex = ? ,user_age = ? where user_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		//参数设置
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getUserPassword());
		pstmt.setString(3, user.getSex());
		pstmt.setInt(4, user.getAge());
		pstmt.setInt(5, userId);
		//执行结果
		int rs = pstmt.executeUpdate();
		//conn.close();
		if(rs == 0) return false;
		return true;
	}
	
	
	@Override
	public List<User> findSomeUsers(List<Integer> userIds) {
		Connection conn = null;
		String sql = "select * from t_user where user_id = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = null;
		List<User> list = new LinkedList<>();
		try {
			conn = DBConnection.getConnection();
			for(int userId:userIds){
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, userId);
				rs = pstmt.executeQuery();
				while(rs.next()){
					user = new User();
					user.setAge(rs.getInt(6));
					user.setSex(rs.getString(5));
					user.setUserAccount(rs.getString(3));
					user.setUserId(rs.getInt(1));
					user.setUserName(rs.getString(2));
					user.setUserPassword(rs.getString(4));
					list.add(user);
				}
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	/*
	 * 用于封装数据库访问
	 * 封装异常
	 * */
	private Connection getConn(){
		try {
			return DBConnection.getConnection();
		} catch (SQLException e) {
			System.out.println("log:[error]: getConnection Error");
			e.printStackTrace();
		}
		return null;
	}


}
