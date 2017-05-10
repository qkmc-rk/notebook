package org.cat.test;

import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.cat.dao.UserDao;
import org.cat.dao.impl.UserDaoImpl;
import org.cat.entities.User;
import org.junit.Test;

public class TestUserDao {
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	UserDao userDao = new UserDaoImpl();
	//测试userDao
	@Test
	public void m1(){
		User user = new User();
		user.setAge(71);
		user.setSex("DF");
		user.setUserAccount("234324234");
		user.setUserName("lao女孩");
		user.setUserPassword("3fdd");
		try {
			if(userDao.addAUser(user))
				System.out.println("add sucess!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("add failed!!");
		}
	}
	
	@Test
	public void m2(){
		try {
			List<User> list = userDao.findAll();
			for(User ls:list){
				System.out.println(ls.getUserName());
			}
		} catch (SQLException e) {
			System.out.println("found failed!!");
			e.printStackTrace();
		}
	}
	@Test
	public void m3(){
		try {
			User user = userDao.findByUserId(2);
			System.out.println(user.getUserName());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void m4(){
		try {
			User user = userDao.findUserByAccount("ruankun");
			System.out.println(user.getUserName());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void m5(){
		User user = new User();
		user.setUserId(5);
		user.setAge(18);
		user.setSex("女");
		user.setUserAccount("3344521");
		user.setUserName("小女孩成年了");
		user.setUserPassword("1314520");
		try {
			userDao.UpdateUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void m6(){
		List<Integer> list = new LinkedList<>();
		List<User> userls = new LinkedList<>();
		list.add(1);
		list.add(3);
		list.add(5);
		userls = userDao.findSomeUsers(list);
		for(User u:userls){
			System.out.println(u.getUserName());
		}
	}
}
