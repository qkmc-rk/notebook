package org.cat.entities;

public class FriendReq {
	private int reqId;
	private int userId;
	private int reqFrom;
	//�����������ʱ������Ϊ��ϲ��sql�е�ʱ��,��һ����ת����ʽ���鷳����?(͵��)
	
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
