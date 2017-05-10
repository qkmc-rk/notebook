package org.cat.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.cat.dao.UserDao;
import org.cat.dao.UserFriendDao;
import org.cat.dao.impl.UserDaoImpl;
import org.cat.dao.impl.UserFriendDaoImpl;
import org.cat.entities.User;
import org.cat.entities.UserFriend;
import org.junit.Test;

public class testUserFriendDao {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	UserFriendDao ufd = null;
	@Test
	public void m1(){
		ufd = new UserFriendDaoImpl();
		if(ufd.deleteAFriendByFriendId(1, 2)){
			System.out.println("[INFO]--->删除好友成功");
		}
	}
	@Test
	public void m2(){
		ufd = new UserFriendDaoImpl();
		if(ufd.addAFriendByFriendId(1, 2)){
			System.out.println("[INFO]--->添加好友成功");
		}
	}
	
	@Test
	public void m3() throws SQLException{
		ufd = new UserFriendDaoImpl();
		UserDao ud = new UserDaoImpl();
		List<UserFriend> list = ufd.findAll(1);  //获取1的所有好友id
		List<Integer> friendIds = new LinkedList<>();
		List<User> users = null;
		for(UserFriend i:list){
			friendIds.add(i.getFriend_id());
		}
		users = ud.findSomeUsers(friendIds);
		System.out.println("[INFO]--->你的好友如下:");
		for(User u:users){
			System.out.println(u.getUserName());
		}
	}
	
}




