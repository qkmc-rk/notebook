package org.cat.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.cat.dao.DiaryDao;
import org.cat.dao.impl.DiaryDaoImpl;
import org.cat.entities.Diary;
import org.cat.service.DiaryService;

public class DiaryServiceImpl implements DiaryService {

	
	DiaryDao diaryDao = new DiaryDaoImpl();
	@Override
	public List<Diary> getAllDiary(int userId) {
		try {
			List<Diary> list = diaryDao.getByUserId(userId);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Diary> getAllFriendDiary(int friendId) {
		try {
			List<Diary> list = diaryDao.getByUserId(friendId);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean saveDiary(Diary diary) {
		try {
			if(diaryDao.addARecord(diary)){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteDiary(int diaryId) {
		try {
			if(diaryDao.deleteByDiaryId(diaryId))
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteDiarys(List<Integer> diaryIds) {
		try {
			if(diaryDao.deleteAnyByDiaryIds(diaryIds)){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
