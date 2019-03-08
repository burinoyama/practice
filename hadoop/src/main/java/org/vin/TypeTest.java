package org.vin;

import org.apache.hadoop.io.VIntWritable;
import org.apache.hadoop.io.VLongWritable;
import org.junit.Test;

public class TypeTest {
	@Test
	public void run() {
		// 最好的用这种可变长的类型
		VIntWritable vIntWritable = new VIntWritable(1);
		VLongWritable vLongWritable = new VLongWritable(1);


	}
}
