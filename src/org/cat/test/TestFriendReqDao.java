package org.cat.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.cat.dao.FriendReqDao;
import org.cat.dao.impl.FriendReqDaoImpl;
import org.cat.entities.FriendReq;
import org.junit.Test;

public class TestFriendReqDao {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	FriendReqDao frd = new FriendReqDaoImpl();
	
	@Test
	public void m1() throws SQLException{
		System.out.println("id为2的向id为1的用户发送好友请求");
		if(frd.addAFriendReq(2, 1))
			System.out.println("发送好友请求成功");
	}
	
	@Test
	public void m2() throws SQLException{
		if(frd.deleteFriendReq(1, 2))
			System.out.println("我是1,我忽略掉来自2的好友请求");
	}
	
	@Test
	public void m3() throws SQLException{
		List<FriendReq> list = frd.findSomeByUserId(1);
		System.out.println("id为1的用户的好友请求有这些:");
		for(FriendReq frq:list){
			System.out.println("[INFO]---->"+frq.getReqFrom());
		}
	}
}
