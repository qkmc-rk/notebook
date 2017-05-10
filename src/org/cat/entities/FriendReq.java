package org.cat.entities;

public class FriendReq {
	private int reqId;
	private int userId;
	private int reqFrom;
	//不想加入请求时间是因为不喜欢sql中的时间,万一遇到转换格式的麻烦了呢?(偷懒)
	
	public FriendReq(){}
	
	public FriendReq(int reqId,int userId, int reqFrom) {
		super();
		this.reqId = reqId;
		this.userId = userId;
		this.reqFrom = reqFrom;
	}

	/*setters and getters*/
	public int getUserId() {return userId;}
	public int getReqId() {return reqId;}
	public void setReqId(int reqId) {this.reqId = reqId;}
	public void setUserId(int userId) {this.userId = userId;}
	public int getReqFrom() {return reqFrom;}
	public void setReqFrom(int reqFrom) {this.reqFrom = reqFrom;}
}
