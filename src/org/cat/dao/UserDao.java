package org.cat.dao;

import java.sql.SQLException;
import java.util.List;

import org.cat.entities.User;

public interface UserDao {
	/*
	 * 通过用户账号查找到用户
	 * */
	User findUserByAccount(String userAccount) throws SQLException;
	
	/*
	 * 查找所有用户
	 * */
	List<User> findAll() throws SQLException;
	
	/*
	 * 通过用户Id查找用户
	 * */
	User findByUserId(int userId) throws SQLException;
	
	/*
	 * 新增一个用户
	 * */
	boolean addAUser(User user) throws SQLException;
	
	/*
	 * 改一个用户,通过提供的userAccount修改,不能修改Account,id等信息
	 * */
	boolean UpdateUser(User user) throws SQLException;
	
	/*
	 * 查找一批用户,通过id数组
	 * 
	 * */
	List<User> findSomeUsers(List<Integer> userIds);
}
