package org.vin;

import org.apache.hadoop.hive.ql.exec.UDF;

public class MyUDF extends UDF {

	public Integer evaluate(int a, int b) {
		return a + b;
	}

}
