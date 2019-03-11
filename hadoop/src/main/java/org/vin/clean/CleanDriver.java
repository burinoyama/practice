package org.vin.clean;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.io.File;
import java.io.IOException;

public class CleanDriver implements Tool {

	private Configuration conf = null;

	@Override
	public int run(String[] args) throws Exception {
		this.conf.set("input", args[0]);

		this.conf.set("output", args[1]);

		// 获取 job对象

		Job job = Job.getInstance();

		// 设置jar包

		job.setJarByClass(CleanDriver.class);

		// 关联mapper&reduce
		job.setMapperClass(CleanMapper.class);

		//设置输出格式
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(NullWritable.class);

		//判断路径是否存在,

		initInputPath(job);

		//初始化输出,
		initOutput(job);

		boolean b = job.waitForCompletion(true);

		return b ? 0 : -1;
	}

	private void initOutput(Job job) throws IOException {
		String output = this.conf.get("output");
		System.err.println(output);
		Path path = new Path(output);
		FileSystem fileSystem = FileSystem.get(this.conf);
		boolean exists = fileSystem.exists(path);
		if (exists) {
			fileSystem.delete(path, true);
		}
		FileOutputFormat.setOutputPath(job, path);


	}

	private void initInputPath(Job job) throws IOException {
		String input = this.conf.get("input");
		System.err.println(input);
		Path inputPath = new Path(input);

		FileSystem fileSystem = FileSystem.get(this.conf);
		boolean exists = fileSystem.exists(inputPath);
		if (exists) {
			FileInputFormat.setInputPaths(job, inputPath);

		} else {
			System.err.println("input path is fucking not exists");
			System.err.println("going to throw Exception");
			File file = new File(input);
			if (file.exists()) {
				System.err.println(">>>>>>>>>>>>>but use IO.File the input path did is exists");
			}
			throw new IOException();
		}
	}

	@Override
	public void setConf(Configuration conf) {
		this.conf = conf;
	}

	@Override
	public Configuration getConf() {
		Configuration conf = new Configuration();
		return conf;
	}

	public static void main(String[] args) throws Exception {
		int run = ToolRunner.run(new CleanDriver(), args);
		System.exit(run);
	}
}
