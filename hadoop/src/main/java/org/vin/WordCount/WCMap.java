package org.vin.WordCount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class WCMap extends Mapper<LongWritable, Text, Text, Text> {

	private Text v = new Text();
	private IntWritable k = new IntWritable(1);



	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String[] attr = value.toString().split("\n");
		key.set();

	}
}
