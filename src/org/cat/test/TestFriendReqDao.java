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
		System.out.println("idΪ2����idΪ1���û����ͺ�������");
		if(frd.addAFriendReq(2, 1))
			System.out.println("���ͺ�������ɹ�");
	}
	
	@Test
	public void m2() throws SQLException{
		if(frd.deleteFriendReq(1, 2))
			System.out.println("����1,�Һ��Ե�����2�ĺ�������");
	}
	
	@Test
	public void m3() throws SQLException{
		List<FriendReq> list = frd.findSomeByUserId(1);
		System.out.println("idΪ1���û��ĺ�����������Щ:");
		for(FriendReq frq:list){
			System.out.println("[INFO]---->"+frq.getReqFrom());
		}
	}
}
