package org.cat.service;

import java.util.List;

import org.cat.entities.Diary;

public interface DiaryService {
	//CRUD ����ɾ�Ĳ����˼
	
	/*
	 * ͨ���û�id�������е��ռ�
	 * */
	List<Diary> getAllDiary(int userId);
	
	/*
	 * ͨ������Id�鿴�������е��ռ�
	 * �������������ķ��������Ĳ�����һ����,����Ϊ������ҵ��,����Ҫ�ֿ�д
	 * */
	List<Diary> getAllFriendDiary(int friendId);
	
	/*
	 * �����ռ�
	 * */
	boolean saveDiary(Diary diary);
	
	/*
	 * ɾ���ռ�
	 * */
	boolean deleteDiary(int diaryId);
	
	/*
	 * ɾ��һ���ռ�
	 * */
	boolean deleteDiarys(List<Integer> diaryIds);
}
