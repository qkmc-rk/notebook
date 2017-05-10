package org.cat.dao;

import java.sql.SQLException;
import java.util.List;

import org.cat.entities.UserFriend;

public interface UserFriendDao{
	//��ɾ�Ĳ�
	
	/*
	 * ͨ����������ĵ�id����һ������
	 * */
	boolean addAFriendByFriendId(int userId,int friendId);
	/*
	 * ɾ��һ������ͨ������id
	 * */
	boolean deleteAFriendByFriendId(int userId,int friendId);
	
	/*
	 * ��ѯ���еĺ���
	 * */
	List<UserFriend> findAll(int userId) throws SQLException;
}
