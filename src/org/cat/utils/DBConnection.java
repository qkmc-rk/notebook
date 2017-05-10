package org.cat.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


/*���������,����ʹ�õ���ģʽ��Ƶ���,��ǿ�����ݿ���ʵ�Ч��,����ֻ�ṩ��ȡ���Ӻ͹ر����ӵķ���,�����ݿ��������Ȼ��c3p0-config.xml����ɵ�!*/
/**
 * ����Java�е������ģʽ��ɶ����ݿ����ӳصķ�װ
 * Ŀ�ģ�
 * 1. ��֤DBConnection��Ϊ�ⲿ�����ṩΨһһ��ʵ������
 * 2. ��֤��DataSource����Դ�ܹ�����¶���ⲿ��ʹ��
 * 3. ��֤�ṩͳһ��Connection�Ự����
 * 4. ��֤�ṩͳһ��Connection�������Դ�رյĲ���
 * @author Administrator
 *
 */
public class DBConnection {
	private static DBConnection db = null;
	private static DataSource ds = null;
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	
	/**
	 * ��ʼ��DataSource�Ķ�����Ϊû��DataSource������Ͳ����ܲ���Connection����
	 */
	private DBConnection() {
		ds = new ComboPooledDataSource();
	}
	
	private final static DBConnection getInstance() {
		if (db == null) {
			synchronized (DBConnection.class) { //�߳���ͬ���������ڶ��߳������ȥ����DBConnection�Ķ��󣬱�֤��Դ����ͻ
				db = new DBConnection();
			}
		}
		return db;
	}
	
	/**
	 * ��ȡ���ݿ�ĻỰ
	 * @return
	 * @throws SQLException 
	 */
	private final Connection connection() throws SQLException {
		Connection conn = tl.get(); //ͨ���߳�����ȡ��ǰ�߳��е����ݿ�Ự����
		if (conn == null) {
			conn = ds.getConnection();
			tl.set(conn); //���µ�Connection������뵽�߳�����
		}
		return conn;
	}
	
	/**
	 * �����ݿ�ĻỰ������Դ�Ĺر�
	 * @throws SQLException
	 */
	private final void close() throws SQLException {
		Connection conn = tl.get();
		if (conn != null && !conn.isClosed()) {
			conn.close();
			tl.remove();
		}
	}
	
	/**
	 * ���ⲿ����Connection����ķ���
	 * @return
	 * @throws SQLException
	 */
	public synchronized final static Connection getConnection() throws SQLException {
		return getInstance().connection();
	}
	
	/**
	 * ���ⲿ�رջỰ����ķ���
	 * @throws SQLException
	 */
	public synchronized final static void closeConnection() throws SQLException {
		getInstance().close();
	}
}