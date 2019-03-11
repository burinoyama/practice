package org.vin.clean;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.Objects;

public class CleanMapper extends Mapper<LongWritable, Text, Text, NullWritable> {

	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

		// 获得一行
		String line = value.toString();
		// 清洗数据
		String result = ETLUtil.oriString2ETLString(line);
		if (Objects.isNull(result)) {
			return;
		}
		//写数据
		Text text = new Text();
		text.set(result);
		context.write(text, NullWritable.get());
	}
}
