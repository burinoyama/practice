package org.vin;

import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.ArrayList;

/**
 * 1.创建命名空间
 * 2.判断表是否存在
 * 3.创建表
 * 4.发布微博
 * 5.关注用户
 * 6.取关用户
 * 7.获取初始化页面
 * 8.查看微博详情
 */
public abstract class WeiBoUtil {

	//1.创建命名空间
	public static void createNS(String ns) throws IOException {

		//获取连接
		Connection connection = ConnectionFactory.createConnection(Constants.CONF);

		//获取Admin对象
		Admin admin = connection.getAdmin();

		//创建命名空间描述器
		NamespaceDescriptor namespaceDescriptor = NamespaceDescriptor.create(ns).build();

		//创建命名空间
		admin.createNamespace(namespaceDescriptor);

		//关闭资源
		admin.close();
		connection.close();
	}

	//判断表是否存在
	public static boolean isTableExist(String tableName) throws IOException {

		//获取连接
		Connection connection = ConnectionFactory.createConnection(Constants.CONF);

		//获取Admin对象
		Admin admin = connection.getAdmin();

		boolean exists = admin.tableExists(TableName.valueOf(tableName));

		//关闭资源
		admin.close();
		connection.close();

		return exists;
	}

	//创建表
	public static void createTable(String tableName, int version, String... cfs) throws IOException {

		//判断列族数据是否合法
		if (cfs.length <= 0) {
			System.out.println("未设置列族信息！！！");
			return;
		}

		//判断表是否存在
		if (isTableExist(tableName)) {
			System.out.println(tableName + "表已存在！！！");
			return;
		}

		//获取连接
		Connection connection = ConnectionFactory.createConnection(Constants.CONF);

		//获取Admin对象
		Admin admin = connection.getAdmin();

		//创建表描述器
		HTableDescriptor hTableDescriptor = new HTableDescriptor(TableName.valueOf(tableName));

		//循环添加列族
		for (String cf : cfs) {

			//创建列族描述器
			HColumnDescriptor hColumnDescriptor = new HColumnDescriptor(cf);

			//设置列族的版本
			hColumnDescriptor.setMaxVersions(version);

			//添加列族
			hTableDescriptor.addFamily(hColumnDescriptor);
		}

		//创建表
		admin.createTable(hTableDescriptor);

		//关闭资源
		admin.close();
		connection.close();

	}

	//发布微博
	public static void publishWeibo(String uid, String content) throws IOException {

		//第一步
		//获取连接
		Connection connection = ConnectionFactory.createConnection(Constants.CONF);

		//获取微博内容表
		Table contTable = connection.getTable(TableName.valueOf(Constants.CONTENT_TABLE));

		//拼接rowKey
		String rowKey = uid + "_" + System.currentTimeMillis();

		//创建Put对象
		Put put = new Put(Bytes.toBytes(rowKey));

		//封装数据
		put.addColumn(Bytes.toBytes(Constants.CONTENT_CF), Bytes.toBytes("content"), Bytes.toBytes(content));

		//数据写入微博内容表
		contTable.put(put);


		//第二步
		//获取用户关系表对象和收件箱表对象
		Table relaTable = connection.getTable(TableName.valueOf(Constants.RELATION_TABLE));


		//创建Get对象
		Get get = new Get(Bytes.toBytes(uid));

		//获取发布微博者的所有用户关系
		Result result = relaTable.get(get);

		//创建一个封装收件箱Put对象的集合
		ArrayList<Put> puts = new ArrayList<>();

		for (Cell cell : result.rawCells()) {
			if (Constants.RELATION_CF2.equals(Bytes.toString(CellUtil.cloneFamily(cell)))) {

				//创建收件箱表的Put对象
				Put inboxPut = new Put(CellUtil.cloneValue(cell));

				//给Put对象赋值
				inboxPut.addColumn(Bytes.toBytes(Constants.INBOX_CF), Bytes.toBytes(uid), Bytes.toBytes(rowKey));

				//将Put对象放入集合
				puts.add(put);
			}
		}

		//执行收件箱表数据插入
		if (puts.size() > 0) {
			Table inboxTable = connection.getTable(TableName.valueOf(Constants.INBOX_TABLE));
			inboxTable.put(puts);
			inboxTable.close();
		}

		//关闭资源
		relaTable.close();
		contTable.close();
		connection.close();
	}

}