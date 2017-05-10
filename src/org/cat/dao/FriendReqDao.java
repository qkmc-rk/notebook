package org.cat.dao;

import java.sql.SQLException;
import java.util.List;

import org.cat.entities.FriendReq;

public interface FriendReqDao {
	/*
	 * 新增用户请求
	 * @from 谁发送的家用户请求  对应req_from
	 * @to  发送到数据库对应的用户接收请求中对应userid
	 * */
	boolean addAFriendReq(int from,int to) throws SQLException;
	
	/*
	 * 删除用户请求
	 * */
	boolean deleteFriendReq(int userId, int from) throws SQLException;
	
	/*
	 * 查找用户请求
	 * */
	List<FriendReq> findSomeByUserId(int userId) throws SQLException;
	//没有改,没有改,没有改.
}
