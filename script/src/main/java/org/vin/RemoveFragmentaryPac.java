package org.vin;

import java.io.File;
import java.util.Objects;


/**
 * first arg is the path of where the MAVEN is
 * second arg is the flag wether scan all the file system to remove all incompleted package
 * my maven repository is /Users/admin/Maven/repository
 */
public class RemoveFragmentaryPac {

	private static final String SUFFIX = ".lastUpdated";
	private static int pathCounter = 0;
	private static int fileCounter = 0;
	private static int deleteFiles = 0;
	private static int deleteDirs = 0;

	public static void main(String[] args) {
		if (args.length < 1) {
			System.err.println("lack the parameter");
			System.exit(-1);
		}
		final String path = args[0];
		final File mavenPath = new File(path);
		if (!mavenPath.isDirectory()) {
			System.err.println("the path of maven home is wrong!");
			System.exit(-1);
		}
		print("********************* START *************************\n");
		print("maven library is : " + mavenPath);
		cleanFragmentaryPck(mavenPath);
		print("\n********************* STATISTIC *********************\n");
		print("total file is : " + fileCounter);
		print("total directory is : " + pathCounter);
		print("delete files : " + deleteFiles);
		print("delete deleteDirs : " + deleteDirs);
		print("\n********************* FINISHED **********************\n");


	}

	private static void cleanFragmentaryPck(final File mvnPath) {
		final File[] files = mvnPath.listFiles();
		for (File subFile : files) {
			if (Objects.isNull(subFile)) {
				continue;
			}
			if (subFile.isFile()) {
				fileCounter++;
				if (subFile.getName().endsWith(SUFFIX)) {
					print("delete fragmentary file ---> " + subFile.getName());
					subFile.delete();
					deleteFiles++;
				}
			} else if (subFile.isDirectory()) {
				pathCounter++;
				if (subFile.listFiles().length == 0) {
					print("delete empty folder ---> " + subFile.getName());
					subFile.delete();
					deleteDirs++;
				} else {
					cleanFragmentaryPck(subFile);
				}
			}
		}
	}

	private static void print(final String msg) {
		System.err.println(msg);
	}
}
