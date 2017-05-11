package org.cat.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.cat.dao.FriendReqDao;
import org.cat.dao.UserDao;
import org.cat.dao.UserFriendDao;
import org.cat.dao.impl.FriendReqDaoImpl;
import org.cat.dao.impl.UserDaoImpl;
import org.cat.dao.impl.UserFriendDaoImpl;
import org.cat.entities.FriendReq;
import org.cat.entities.User;
import org.cat.entities.UserFriend;
import org.cat.service.UserService;

public class UserServiceImpl implements UserService {
	
	//ÊÖ¶¯×¢Èë
	UserDao userDao = new UserDaoImpl();
	UserFriendDao userFriendDao = new UserFriendDaoImpl();
	FriendReqDao friendReqDao = new FriendReqDaoImpl();
	
	@Override
	public boolean login(User user) {
		try {
			User gotUser = userDao.findUserByAccount(user.getUserAccount());
			if(gotUser != null && gotUser.getUserPassword().equals(user.getUserPassword()))
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean regist(User user) {
		try {
			if(userDao.addAUser(user))
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean addFriend(int userId,int to) {
		try {
			if(friendReqDao.addAFriendReq(userId, to))
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean receiveFriendReq(int idFrom, int myId) {
		if(userFriendDao.addAFriendByFriendId(myId, idFrom))
			return true;
		return false;
	}

	@Override
	public List<UserFriend> getAllFriend(int userId) {
		try {
			List<UserFriend> list = userFriendDao.findAll(userId);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<FriendReq> getAllFriendReq(int userId) {
		try {
			List<FriendReq> list = friendReqDao.findSomeByUserId(userId);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User findUserInfo(String userAccount) {
		try {
			User user = userDao.findUserByAccount(userAccount);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> findSomeUsers(List<Integer> userIds) {
		List<User> users = userDao.findSomeUsers(userIds);
		return users;
	}

	@Override
	public String getUserName(int userId) {
		try {
			User user = userDao.findByUserId(userId);
			String userName = user.getUserName();
			return userName;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
