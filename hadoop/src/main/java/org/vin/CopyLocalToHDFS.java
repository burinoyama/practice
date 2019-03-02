package org.vin;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;
import sun.nio.ch.IOUtil;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;

public class CopyLocalToHDFS {

	public static void main(String[] args) throws IOException {

		String local = "C:\\Users\\vincent\\Desktop\\CentOS-6.8-x86_64-bin-DVD1.iso";

		String dst = "hdfs://hadoop5:9000/user/centos-6.8.iso";

		Configuration conf = new Configuration();

		File localFile = new File(local);

		long length = localFile.length();

		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(localFile));



		FileSystem fileSystem = FileSystem.get(URI.create(dst), conf);

		FSDataOutputStream out = fileSystem.create(new Path(dst), new Progressable() {
			@Override
			public void progress() {
				long actualSize = getHdfsFileSize(fileSystem, dst);

				System.err.println(actualSize / length);
			}
		});
		IOUtils.copyBytes(bis, out, 4096, true);

	}

	/**
	 * 查看此时hdfs中对应文件的大小，并返回大小
	 * @param fs
	 * @param fileHdfsPath
	 */
	public static long getHdfsFileSize(FileSystem fs, String fileHdfsPath) {

		return 1L;
	}
}
