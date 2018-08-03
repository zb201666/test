package com.readExcel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TestReadExcelUtil {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		File file = new File("C:\\word\\信息.xls");
		try {
			ArrayList<String[]> list = (ArrayList<String[]>) ReadExcelUtil
					.readExcelByColumn(file);
			for (int i = 0; i < list.size(); i++) {
				String[] str = list.get(i);
				for (int j = 0; j < str.length; j++) {
					System.out.print("值" + j + ":" + str[j] + "\t");
				}
				System.out.println();
				System.out.println("-----------------------------------");
			}
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
