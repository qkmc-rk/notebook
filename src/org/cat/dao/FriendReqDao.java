package org.cat.dao;

import java.sql.SQLException;
import java.util.List;

import org.cat.entities.FriendReq;

public interface FriendReqDao {
	/*
	 * �����û�����
	 * @from ˭���͵ļ��û�����  ��Ӧreq_from
	 * @to  ���͵����ݿ��Ӧ���û����������ж�Ӧuserid
	 * */
	boolean addAFriendReq(int from,int to) throws SQLException;
	
	/*
	 * ɾ���û�����
	 * */
	boolean deleteFriendReq(int userId, int from) throws SQLException;
	
	/*
	 * �����û�����
	 * */
	List<FriendReq> findSomeByUserId(int userId) throws SQLException;
	//û�и�,û�и�,û�и�.
}
