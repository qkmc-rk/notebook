package org.cat.service;

import java.util.List;

import org.cat.entities.FriendReq;
import org.cat.entities.User;
import org.cat.entities.UserFriend;

public interface UserService {
	
	/*
	 *用户登录,返回是否登陆成功 
	 */
	boolean login(User user);
	
	/*
	 * 用户注册,返回是否注册成功
	 * */
	boolean regist(User user);
	
	/*
	 * 发送好友请求
	 * */
	boolean addFriend(int userId,int to);
	
	/*
	 * 接受好友请求
	 * 删除好友请求,并在好友的和自己的列表中添加好友id.
	 * */
	boolean receiveFriendReq(int idFrom,int myId);
	
	/*
	 * 查找所有好友
	 * */
	List<UserFriend> getAllFriend(int userId);
	
	/*
	 * 查找所有的用户请求
	 * */
	List<FriendReq> getAllFriendReq(int userId);
	
	/*
	 * 获取用户的信息,用于展示到个人中心,或者查找好友的个人信息
	 * */
	User findUserInfo(String userAccount);
	
	/*
	 * 查找一批用户
	 * 
	 * */
	List<User> findSomeUsers(List<Integer> userIds);
}




