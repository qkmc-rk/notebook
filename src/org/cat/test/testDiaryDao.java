package org.cat.test;

import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.cat.dao.DiaryDao;
import org.cat.dao.impl.DiaryDaoImpl;
import org.cat.entities.Diary;
import org.junit.Test;

public class testDiaryDao {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	DiaryDao dd;
	@Test
	public void m1() throws SQLException{
		dd = new DiaryDaoImpl();
		List<Diary> list = dd.getAll();
		for(Diary d:list){
			System.out.println(d.getContent());
		}
	}
	
	@Test
	public void m2() throws SQLException{
		Diary diary = new Diary(1,1,1,1,1,1,"q","asdasdasd","dfsf");
		dd = new DiaryDaoImpl();
		if(dd.addARecord(diary)){
			System.out.println("[INFO] success--->add a diary");
		}
	}
	@Test
	public void m3() throws SQLException{
		dd = new DiaryDaoImpl();
		List<Diary> list = dd.getByUserId(1);
		for(Diary d:list){
			System.out.println("[INFO] ---->"+d.getContent());
		}
	}
	
	@Test
	public void m4() throws SQLException{
		dd = new DiaryDaoImpl();
		dd.deleteByDiaryId(4);
	}
	@Test
	public void m5() throws SQLException{
		dd = new DiaryDaoImpl();
		Diary d = dd.getById(7);
		System.out.println(d.getContent());
	}
	@Test
	public void m6() throws SQLException{
		dd = new DiaryDaoImpl();
		dd.deleteByDiaryId(7);
	}
	//删除一整片,哈哈哈哈哈哈,居然一次成功
	@Test
	public void m7() throws SQLException{
		dd = new DiaryDaoImpl();
		List<Integer> list = new ArrayList<>();
		list.add(5);
		list.add(6);
		dd.deleteAnyByDiaryIds(list);
	}
}
