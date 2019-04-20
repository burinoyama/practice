package org.vin.apiTest;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class APITest {

	public static Configuration conf;
	public static HBaseAdmin admin;

	static {
		conf = HBaseConfiguration.create();
		conf.set("hbase.zookeeper.quorum", "192.168.159.105");
		conf.set("hbase.zookeeper.property.client.Port", "2181");
		try {
			admin = new HBaseAdmin(conf);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public boolean isExists(String tableName) throws IOException {
//		Connection connection = ConnectionFactory.createConnection(conf);
//		HBaseAdmin admin = (HBaseAdmin) connection.getAdmin();
		return admin.tableExists(tableName);
	}


	public void createTable(String tableName, String... columnFamily) throws IOException {
//		HBaseAdmin admin = new HBaseAdmin(conf);
		if (admin.tableExists(tableName)) {
			System.err.println("table : " + tableName + "is exists");
			System.exit(-1);
		}

		HTableDescriptor descriptor = new HTableDescriptor(TableName.valueOf(tableName));

		for (String column : columnFamily) {
			descriptor.addFamily(new HColumnDescriptor(column));
		}
		admin.createTable(descriptor);
		System.err.println("Table: " + tableName + " create successful!");
	}

	public void deleteTable(String tableName) throws IOException {
//		HBaseAdmin admin = new HBaseAdmin(conf);
		if (!isExists(tableName)) {
			System.err.println("Table : " + tableName + "is not exists");
			System.exit(-1);
		}
		admin.deleteTable(tableName);
		System.err.println("Table : " + tableName + "delete successful");
	}


	public void insert(String tableName, String rowKey, String columnFamily, String column, String value) throws IOException {
		HTable hTable = new HTable(conf, tableName);
		Put put = new Put(Bytes.toBytes(rowKey));
		put.add(Bytes.toBytes(columnFamily), Bytes.toBytes(column), Bytes.toBytes(value));
		hTable.put(put);
		hTable.close();
		System.err.println("Table : " + tableName + " insert data successful");
	}

	public void deleteMulRow(String tableName, String... rows) throws IOException {
		HTable hTable = new HTable(conf, tableName);
		if (rows.length < 1) {
			System.err.println("Delete multi rows not allowed empty rows");
		}
		ArrayList<Delete> deletes = new ArrayList();
		for (String row : rows) {
			deletes.add(new Delete(Bytes.toBytes(row)));
		}
		hTable.delete(deletes);
		hTable.close();
	}


	public List<RowBean> getAllRows(String tableName, String... rows) throws IOException {
		HTable hTable = new HTable(conf, tableName);
		ArrayList<Get> gets = new ArrayList<>();
		for (String row : rows) {
			gets.add(new Get(Bytes.toBytes(row)));
		}
		Result[] results = hTable.get(gets);
		if (results.length < 1) {
			System.err.println("Table : " + tableName + "get nothing");
		}
		ArrayList<RowBean> rowBeans = new ArrayList<>();
		for (Result result : results) {
			rowBeans.addAll(getRowBean(result.rawCells()));
		}
		return rowBeans;
	}

	private List<RowBean> getRowBean(Cell[] cells) {
		ArrayList<RowBean> rowBeans = new ArrayList<>();
		for (Cell cell : cells) {
			String rowKey = Bytes.toString(CellUtil.cloneRow(cell));
			String columnFamily = Bytes.toString(CellUtil.cloneFamily(cell));
			String column = Bytes.toString(CellUtil.cloneQualifier(cell));
			String value = Bytes.toString(CellUtil.cloneValue(cell));
			rowBeans.add(new RowBean(rowKey, columnFamily, column, value));
		}
		return rowBeans;
	}


	public List<RowBean> getRow(String tableName, String row) throws IOException {
		HTable hTable = new HTable(conf, tableName);
		Get get = new Get(Bytes.toBytes(row));
		Result result = hTable.get(get);
		Cell[] cells = result.rawCells();
		return getRowBean(cells);
	}

	public List<RowBean> getRowQualifier(String tableName, String row, String columnFamily, String column) throws IOException {
		HTable hTable = new HTable(conf, tableName);
		Get get = new Get(Bytes.toBytes(row));
		get.addColumn(Bytes.toBytes(columnFamily), Bytes.toBytes(column));
		Result result = hTable.get(get);
		return getRowBean(result.rawCells());
	}


}
