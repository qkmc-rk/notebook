package org.cat.dao;

import java.sql.SQLException;
import java.util.List;

import org.cat.entities.UserFriend;

public interface UserFriendDao{
	//增删改查
	
	/*
	 * 通过好友请求的的id增加一个好友
	 * */
	boolean addAFriendByFriendId(int userId,int friendId);
	/*
	 * 删除一个好友通过好友id
	 * */
	boolean deleteAFriendByFriendId(int userId,int friendId);
	
	/*
	 * 查询所有的好友
	 * */
	List<UserFriend> findAll(int userId) throws SQLException;
}
