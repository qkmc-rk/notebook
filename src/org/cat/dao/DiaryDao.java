package org.cat.dao;

import java.sql.SQLException;
import java.util.List;

import org.cat.entities.Diary;

public interface DiaryDao {
	/*
	 * 获得所有的Diary记录
	 * */
	List<Diary> getAll() throws SQLException;
	/*
	 * 通过userId获取Diary
	 */
	List<Diary> getByUserId(int userId) throws SQLException;
	/*
	 * 获得某一条记录
	 * */
	Diary getById(int diaryId) throws SQLException;
	/*
	 * 增加一条日记
	 * */
	boolean addARecord(Diary diary) throws SQLException;
	
	/*
	 * 通过diary id 删除一条日记
	 * */
	boolean deleteByDiaryId(int diaryId) throws SQLException;
	/*
	 * 删除一组 日记 通过diary id的数据
	 * */
	boolean deleteAnyByDiaryIds(List<Integer> diaryIds) throws SQLException;
	
	//注意,没有修改,没有修改,没有修改,重要的事情说3遍.
}
