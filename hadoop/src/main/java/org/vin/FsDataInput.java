package org.vin;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class FsDataInput {
	public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://hadoop5:9000");

		FileSystem fileSystem = FileSystem.get(new URI("hdfs://hadoop5:9000"), conf, "alice");

		FSDataOutputStream fsDataOutputStream = fileSystem.create(new Path("/user/fromwindowns/alice"));

		fileSystem.close();

	}
}
