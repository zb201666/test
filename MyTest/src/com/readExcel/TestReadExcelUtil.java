package com.readExcel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TestReadExcelUtil {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		File file = new File("C:\\word\\��Ϣ.xls");
		try {
			ArrayList<String[]> list = (ArrayList<String[]>) ReadExcelUtil
					.readExcelByColumn(file);
			for (int i = 0; i < list.size(); i++) {
				String[] str = list.get(i);
				for (int j = 0; j < str.length; j++) {
					System.out.print("ֵ" + j + ":" + str[j] + "\t");
				}
				System.out.println();
				System.out.println("-----------------------------------");
			}
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}

}
