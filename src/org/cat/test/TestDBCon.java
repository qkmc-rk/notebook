package org.cat.test;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.cat.entities.User;
import org.cat.utils.DBConnection;
import org.junit.Test;

public class TestDBCon {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void m1() throws SQLException{
		Connection conn = DBConnection.getConnection();
		QueryRunner runner = new QueryRunner();
		List<User> list = new ArrayList<User>();
		list = runner.query(conn, "select * from user", new ResultSetHandler<List<User>>(){
			//��,͵������ʴ����,����queryRunner��򻯲�ѯ,���beanHandler����Ϊnull,ֻ����дhandle����,��û�м򻯲���,������������.
			@Override
			public List<User> handle(ResultSet rs) throws SQLException {
				List<User> list = new ArrayList<>();
				User user = new User();
				while(rs.next()){
					user.setAge(rs.getInt(6));
					user.setSex(rs.getString(5));
					user.setUserAccount(rs.getString(3));
					user.setUserId(rs.getInt(1));
					user.setUserName(rs.getString(2));
					user.setUserPassword(rs.getString(4));
					list.add(user);
				}
				return list;
			}
			
		});
		System.out.println(list.get(0).getUserAccount());
		conn.close();
	}
}
