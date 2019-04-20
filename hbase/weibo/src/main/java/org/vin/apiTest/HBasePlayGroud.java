package org.vin.apiTest;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class HBasePlayGroud {

	public static APITest api;

	@Before
	public void setup() {
		api = new APITest();
	}


	@Test
	public void exists() throws IOException {
		System.out.println(api.isExists("student"));
		System.out.println(api.isExists("stratum"));
	}

	@Test
	public void create() throws IOException {
		api.createTable("stratum", "class", "wealth");
	}

	@Test
	public void insert() throws IOException {
//		api.insert("stratum", "class_power_1", "class", "first", "power first generation");
//		api.insert("stratum", "class_wealth_1", "wealth", "first", "rich first generation");
//		api.insert("stratum", "class_power_2", "class", "first", "power second generation");
		api.insert("stratum", "class_power_2", "wealth", "first", "generation");
	}

	@Test
	public void getAll() throws IOException {
		List<RowBean> allRows = api.getAllRows("stratum", "class_power_2");
		for (RowBean allRow : allRows) {
			System.out.println(allRow.toString());
		}
	}

	@Test
	public void getRow() throws IOException {
		List<RowBean> row = api.getRow("stratum", "class_power_2");
		for (RowBean rowBean : row) {
			System.out.println(rowBean.toString());
		}
	}

	@Test
	public void getRowQulifier() throws IOException {
		List<RowBean> rowQualifier = api.getRowQualifier("stratum", "class_power_2", "class", "first");
		for (RowBean rowBean : rowQualifier) {
			System.out.println(rowBean.toString());
		}
	}
}
