package org.cat.entities;

public class UserFriend {
	private int user_friend_id;
	private int user_id;		//谁的女朋友是硅胶的?_?
	private int friend_id;		//硅胶女朋友对应的编号= =!
	private String friend_type;
	
	public UserFriend(){}
	
	public UserFriend(int user_friend_id,int user_id, int friend_id, String friend_type) {
		super();
		this.user_friend_id = user_friend_id;
		this.user_id = user_id;
		this.friend_id = friend_id;
		this.friend_type = friend_type;
	}

	/*setters and getters*/
	public int getUser_friend_id() {return user_friend_id;}
	public void setUser_friend_id(int user_friend_id) {this.user_friend_id = user_friend_id;}
	public int getUser_id() {return user_id;}
	public void setUser_id(int user_id) {this.user_id = user_id;}
	public int getFriend_id() {return friend_id;}
	public void setFriend_id(int friend_id) {this.friend_id = friend_id;}
	public String getFriend_type() {return friend_type;}
	public void setFriend_type(String friend_type) {this.friend_type = friend_type;}
	
	
}
