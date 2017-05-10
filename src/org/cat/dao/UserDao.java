package org.cat.dao;

import java.sql.SQLException;
import java.util.List;

import org.cat.entities.User;

public interface UserDao {
	/*
	 * ͨ���û��˺Ų��ҵ��û�
	 * */
	User findUserByAccount(String userAccount) throws SQLException;
	
	/*
	 * ���������û�
	 * */
	List<User> findAll() throws SQLException;
	
	/*
	 * ͨ���û�Id�����û�
	 * */
	User findByUserId(int userId) throws SQLException;
	
	/*
	 * ����һ���û�
	 * */
	boolean addAUser(User user) throws SQLException;
	
	/*
	 * ��һ���û�,ͨ���ṩ��userAccount�޸�,�����޸�Account,id����Ϣ
	 * */
	boolean UpdateUser(User user) throws SQLException;
	
	/*
	 * ����һ���û�,ͨ��id����
	 * 
	 * */
	List<User> findSomeUsers(List<Integer> userIds);
}
