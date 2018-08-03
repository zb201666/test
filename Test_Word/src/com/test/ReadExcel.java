package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.junit.Test;

public class ReadExcel {
	@Test
	public void readAll() {
		File file = new File("C:\\word\\������Ϣ.xls");
		// List<String> list1 = new ArrayList<String>();
		// List<List<String>> list2 = new ArrayList<List<String>>();
		String ValueObject[][] = null;
		if (!file.exists())
			System.out.println("�ļ�������");
		try {
			// 1.��ȡExcel�Ķ���
			POIFSFileSystem poifsFileSystem = new POIFSFileSystem(
					new FileInputStream(file));
			// 2.Excel����������
			HSSFWorkbook hssfWorkbook = new HSSFWorkbook(poifsFileSystem);
			// 3.Excel���������
			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
			// ������
			int rowLength = hssfSheet.getLastRowNum() + 1;
			// 4.�õ�Excel���������
			HSSFRow hssfRow = hssfSheet.getRow(0);
			// ������
			int colLength = hssfRow.getLastCellNum();
			// �õ�Excelָ����Ԫ���е�����
			HSSFCell hssfCell = hssfRow.getCell(0);
			// �õ���Ԫ����ʽ
			CellStyle cellStyle = hssfCell.getCellStyle();
			String attr = null;
			ValueObject = new String[rowLength][colLength];
			for (int i = 1; i < rowLength; i++) {
				// ��ȡExcel���������
				HSSFRow hssfRow1 = hssfSheet.getRow(i);
				for (int j = 1; j < colLength; j++) {
					// ��ȡָ����Ԫ��
					HSSFCell hssfCell1 = hssfRow1.getCell(j);

					// Excel����Cell�в�ͬ�����ͣ���������ͼ��һ���������͵�Cell��ȡ��һ���ַ���ʱ���п��ܱ��쳣��
					// Cannot get a STRING value from a NUMERIC cell
					// �����е���Ҫ����Cell�������ΪString��ʽ
					if (hssfCell1 != null) {
						hssfCell1.setCellType(CellType.STRING);
					}

					// ��ȡÿһ���е�ֵ
					attr = hssfCell1.getStringCellValue();
					// list1.add(attr);
				}
				// list2.add(list1);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// return ValueObject;
	}
}
