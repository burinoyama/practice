package org.vin;

import java.sql.*;

public class visualization {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String KYLIN_DRIVER = "org.apache.kylin.jdbc.Driver";

		String KYLIN_URL = "jdbc:kylin://hadoop5:7070/kylin";

		//Kylin的用户名
		String KYLIN_USER = "ADMIN";

		//Kylin的密码
		String KYLIN_PASSWD = "KYLIN";

		//添加驱动信息
		Class.forName(KYLIN_DRIVER);

		//获取连接
		Connection connection = DriverManager.getConnection(KYLIN_URL, KYLIN_USER, KYLIN_PASSWD);

		//预编译SQL
		PreparedStatement ps = connection.prepareStatement("SELECT sum(sal) FROM emp group by deptno");

		//执行查询
		ResultSet resultSet = ps.executeQuery();

		//遍历打印
		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1));
		}

	}

}
