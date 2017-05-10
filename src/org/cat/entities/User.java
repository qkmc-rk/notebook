package org.cat.entities;

public class User {
	private int userId;
	private String userName;
	private String userAccount;
	private String userPassword;
	private int userAge;	//这个字段可以为空,数据库不会
	private String userSex;		//这个字段可以为空,数据库不会报错
	
	
	public User(String userName, String userAccount, 
				String userPassword, int age, String sex,int userId) {
		super();
		this.userName = userName;
		this.userAccount = userAccount;
		this.userPassword = userPassword;
		this.userAge = age;
		this.userSex = sex;
		this.userId = userId;
	}
	
	public User() {}
	
	/*setters and getters*/
	public String getUserName() {return userName;}
	public void setUserName(String userName) {this.userName = userName;}
	public String getUserAccount() {return userAccount;}
	public void setUserAccount(String userAccount) {this.userAccount = userAccount;}
	public String getUserPassword() {return userPassword;}
	public void setUserPassword(String userPassword) {this.userPassword = userPassword;}
	public int getAge() {return userAge;}
	public void setAge(int age) {this.userAge = age;}
	public String getSex() {return userSex;}
	public void setSex(String sex) {this.userSex = sex;}
	public void setUserId(int userId){this.userId = userId;}
	public int getUserId(){ return userId;}
}
