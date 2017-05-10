package org.cat.entities;

public class Diary {
	private int diaryId;
	private int userId;
	private int year;		//ʹ��int����sql.Date,����Ϊ����,������Ϊ������
	private int month;		//����Ϊ�����ṹ������������
	private int day;
	private int week;
	private String weather;
	private String content;		//���ݿ���Ϊtext����,С����Ҫע�Ⱑ
	private String contenType;	//���Ͳ���Ӧ��int��?ΪʲôҪ��String��?��Ϊ����
	public int getUserId() {
		return userId;
	}
	
	
	public Diary(int diaryId,int userId, int year, int month, int day, int week, 
			String weather, String content,String contenType) {
		super();
		this.diaryId = diaryId;
		this.userId = userId;
		this.year = year;
		this.month = month;
		this.day = day;
		this.week = week;
		this.weather = weather;
		this.content = content;
		this.contenType = contenType;
	}
	public Diary() {}

	/*setters and getters*/
	public int getDiaryId() {return diaryId;}
	public void setDiaryId(int diaryId) {this.diaryId = diaryId;}
	public void setUserId(int userId) {this.userId = userId;}
	public int getYear() {return year;}
	public void setYear(int year) {this.year = year;}
	public int getMonth() {return month;}
	public void setMonth(int month) {this.month = month;}
	public int getDay() {return day;}
	public void setDay(int day) {this.day = day;}
	public int getWeek() {return week;}
	public void setWeek(int week) {this.week = week;}
	public String getWeather() {return weather;}
	public void setWeather(String weather) {this.weather = weather;}
	public String getContent() {return content;}
	public void setContent(String content) {this.content = content;}
	public String getContenType() {return contenType;}
	public void setContenType(String contenType) {this.contenType = contenType;}
}
