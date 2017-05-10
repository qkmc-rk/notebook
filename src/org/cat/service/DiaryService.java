package org.cat.service;

import java.util.List;

import org.cat.entities.Diary;

public interface DiaryService {
	//CRUD 是增删改查的意思
	
	/*
	 * 通过用户id查找所有的日记
	 * */
	List<Diary> getAllDiary(int userId);
	
	/*
	 * 通过好友Id查看好友所有的日记
	 * 这个方法和上面的方法所做的操作是一样的,不过为了区分业务,还是要分开写
	 * */
	List<Diary> getAllFriendDiary(int friendId);
	
	/*
	 * 保存日记
	 * */
	boolean saveDiary(Diary diary);
	
	/*
	 * 删除日记
	 * */
	boolean deleteDiary(int diaryId);
	
	/*
	 * 删除一堆日记
	 * */
	boolean deleteDiarys(List<Integer> diaryIds);
}
