package org.cat.service;

import java.util.List;

import org.cat.entities.FriendReq;
import org.cat.entities.User;
import org.cat.entities.UserFriend;

public interface UserService {
	
	/*
	 *�û���¼,�����Ƿ��½�ɹ� 
	 */
	boolean login(User user);
	
	/*
	 * �û�ע��,�����Ƿ�ע��ɹ�
	 * */
	boolean regist(User user);
	
	/*
	 * ���ͺ�������
	 * */
	boolean addFriend(int userId,int to);
	
	/*
	 * ���ܺ�������
	 * ɾ����������,���ں��ѵĺ��Լ����б�����Ӻ���id.
	 * */
	boolean receiveFriendReq(int idFrom,int myId);
	
	/*
	 * �������к���
	 * */
	List<UserFriend> getAllFriend(int userId);
	
	/*
	 * �������е��û�����
	 * */
	List<FriendReq> getAllFriendReq(int userId);
	
	/*
	 * ��ȡ�û�����Ϣ,����չʾ����������,���߲��Һ��ѵĸ�����Ϣ
	 * */
	User findUserInfo(String userAccount);
	
	/*
	 * ����һ���û�
	 * 
	 * */
	List<User> findSomeUsers(List<Integer> userIds);
}




