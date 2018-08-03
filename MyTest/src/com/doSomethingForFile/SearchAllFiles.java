package com.doSomethingForFile;

import java.io.File;

public class SearchAllFiles {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		searchAllFiles("C:" + File.separator + "word"+File.separator+"log1.txt");
	}

	public static void searchAllFiles(String filePath) {
		File file = new File(filePath);
		if (file.exists()) {
			File[] files = file.listFiles();
			if (files != null && files.length > 0) {
				for (File f : files) {
					if (f.isDirectory()) {
						searchAllFiles(f.getAbsolutePath());
					}
					if (f.isFile()) {
						System.out.println(f.getAbsolutePath());
						System.out.println(f.getName());
						System.out.println("========================");
					}
				}
			} else {
				System.out.println(file.getAbsolutePath());
				System.out.println(file.getName());
				System.out.println("========================");
			}

		} else {
			System.out.println("文件不存在！");
		}
	}
}
