package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelAt {
	
	public static List<String> readExcelCellAt(File file1, int i) {
		File file2 = file1;
		String fileName = file2.getName().toLowerCase();
		if (!file2.exists()) {
			System.out.println("�ļ�������");
		}
		String attr = null;
		List<String> list = new ArrayList<String>();
		try {
			// 1.��ȡExcel�Ķ���
			// POIFSFileSystem poifsFileSystem = new POIFSFileSystem(
			// new FileInputStream(file));
			InputStream input = new FileInputStream(file2);
			if (fileName.endsWith(".xls")) {
				// 2.Excel����������
				HSSFWorkbook hssfWorkbook = new HSSFWorkbook(input);
				// 3.Excel���������
				HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
				// ������
				int rowLength = hssfSheet.getLastRowNum() + 1;

				for (int j = 1; j < rowLength; j++) {
					// ��ȡExcel���������
					HSSFRow hssfRow1 = hssfSheet.getRow(j);
					// ��ȡָ����Ԫ��
					HSSFCell hssfCell1 = hssfRow1.getCell(i);

					// Excel����Cell�в�ͬ�����ͣ���������ͼ��һ���������͵�Cell��ȡ��һ���ַ���ʱ���п��ܱ��쳣��
					// Cannot get a STRING value from a NUMERIC cell
					// �����е���Ҫ����Cell�������ΪString��ʽ
					if (hssfCell1 != null) {
						hssfCell1.setCellType(CellType.STRING);
					}

					// ��ȡÿһ���е�ֵ
					attr = hssfCell1.getStringCellValue();
					list.add(attr);
				}
			} else {
				// 2.Excel����������
				XSSFWorkbook xssfWorkbook = new XSSFWorkbook(input);
				// 3.Excel���������
				XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
				// ������
				int rowLength = xssfSheet.getLastRowNum() + 1;

				for (int j = 1; j < rowLength; j++) {
					// ��ȡExcel���������
					XSSFRow xssfRow1 = xssfSheet.getRow(j);
					// ��ȡָ����Ԫ��
					XSSFCell xssfCell1 = xssfRow1.getCell(i);

					// Excel����Cell�в�ͬ�����ͣ���������ͼ��һ���������͵�Cell��ȡ��һ���ַ���ʱ���п��ܱ��쳣��
					// Cannot get a STRING value from a NUMERIC cell
					// �����е���Ҫ����Cell�������ΪString��ʽ
					if (xssfCell1 != null) {
						xssfCell1.setCellType(CellType.STRING);
					}

					// ��ȡÿһ���е�ֵ
					attr = xssfCell1.getStringCellValue();
					list.add(attr);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public static void main(String[] args){
		ArrayList<String> list = new ArrayList<String>();
		File file = new File("C:\\word\\������Ϣ.xlsx");
		list = (ArrayList<String>) readExcelCellAt(file,1);
		for(int i= 0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
}
