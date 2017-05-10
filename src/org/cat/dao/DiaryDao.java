package org.cat.dao;

import java.sql.SQLException;
import java.util.List;

import org.cat.entities.Diary;

public interface DiaryDao {
	/*
	 * ������е�Diary��¼
	 * */
	List<Diary> getAll() throws SQLException;
	/*
	 * ͨ��userId��ȡDiary
	 */
	List<Diary> getByUserId(int userId) throws SQLException;
	/*
	 * ���ĳһ����¼
	 * */
	Diary getById(int diaryId) throws SQLException;
	/*
	 * ����һ���ռ�
	 * */
	boolean addARecord(Diary diary) throws SQLException;
	
	/*
	 * ͨ��diary id ɾ��һ���ռ�
	 * */
	boolean deleteByDiaryId(int diaryId) throws SQLException;
	/*
	 * ɾ��һ�� �ռ� ͨ��diary id������
	 * */
	boolean deleteAnyByDiaryIds(List<Integer> diaryIds) throws SQLException;
	
	//ע��,û���޸�,û���޸�,û���޸�,��Ҫ������˵3��.
}
