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
import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	@SuppressWarnings({ "deprecation", "resource" })
	public static List<String> readExcelByColumn(File file, int column) {//���ж�ȡExcel���
		String fileName = file.getName().toLowerCase();
		if (!file.exists()) {
			System.out.println("�ļ�������");
		}
		String attr = null;
		List<String> list = new ArrayList<String>();
		try {
			// 1.��ȡExcel�Ķ���
			// POIFSFileSystem poifsFileSystem = new POIFSFileSystem(
			// new FileInputStream(file));
			InputStream input = new FileInputStream(file);
			if (fileName.endsWith(".xls")) {
				// 2.Excel����������
				HSSFWorkbook hssfWorkbook = new HSSFWorkbook(input);
				// 3.Excel���������
				HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
				// ������
				int rowLength = hssfSheet.getLastRowNum();

				for (int i = 1; i <= rowLength; i++) {
					// ��ȡExcel���������
					HSSFRow hssfRow1 = hssfSheet.getRow(i);
					// ��ȡָ����Ԫ��
					HSSFCell hssfCell1 = hssfRow1.getCell(column);

					// Excel����Cell�в�ͬ�����ͣ���������ͼ��һ���������͵�Cell��ȡ��һ���ַ���ʱ���п��ܱ��쳣��
					// Cannot get a STRING value from a NUMERIC cell
					// �����е���Ҫ����Cell�������ΪString��ʽ
					if (hssfCell1 != null) {
						hssfCell1.setCellType(Cell.CELL_TYPE_STRING);
						// ��ȡÿһ���е�ֵ
						attr = hssfCell1.getStringCellValue();
						if(attr.contains("\n")){
							attr = attr.replace("\n", "");
						}
					}else{
						attr = "";
					}

					list.add(attr);
				}
			} else {
				// 2.Excel����������
				XSSFWorkbook xssfWorkbook = new XSSFWorkbook(input);
				// 3.Excel���������
				XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
				// ������
				int rowLength = xssfSheet.getLastRowNum();

				for (int i = 1; i <= rowLength; i++) {
					// ��ȡExcel���������
					XSSFRow xssfRow1 = xssfSheet.getRow(i);
					// ��ȡָ����Ԫ��
					XSSFCell xssfCell1 = xssfRow1.getCell(column);

					// Excel����Cell�в�ͬ�����ͣ���������ͼ��һ���������͵�Cell��ȡ��һ���ַ���ʱ���п��ܱ��쳣��
					// Cannot get a STRING value from a NUMERIC cell
					// �����е���Ҫ����Cell�������ΪString��ʽ
					if (xssfCell1 != null) {
						xssfCell1.setCellType(Cell.CELL_TYPE_STRING);
						// ��ȡÿһ���е�ֵ
						attr = xssfCell1.getStringCellValue();
						if(attr.contains("\n")){
							attr = attr.replace("\n", "");
						}
					}else{
						attr = "";
					}

					list.add(attr);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	
	
	@SuppressWarnings({ "resource", "deprecation" })
	public static List<String> readExcelByRow(File file,int row) {//���ж�ȡExcel���
		String fileName = file.getName().toLowerCase();
		if (!file.exists()) {
			System.out.println("�ļ�������");
		}
		String attr = null;
		List<String> list = new ArrayList<String>();
		try {
			// 1.��ȡExcel�Ķ���
			// POIFSFileSystem poifsFileSystem = new POIFSFileSystem(
			// new FileInputStream(file));
			InputStream input = new FileInputStream(file);
			if (fileName.endsWith(".xls")) {
				// 2.Excel����������
				HSSFWorkbook hssfWorkbook = new HSSFWorkbook(input);
				// 3.Excel���������
				HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
				// ������
				@SuppressWarnings("unused")
				int rowLength = hssfSheet.getLastRowNum();

				// ��ȡExcel�������ָ����
				HSSFRow hssfRow1 = hssfSheet.getRow(row);
				// ��ȡָ���еĵ�Ԫ��������������
				int cellLength = hssfRow1.getLastCellNum();
				for (int i = 1; i < cellLength; i++) {
					HSSFCell hssfCell1 = hssfRow1.getCell(i);

					// Excel����Cell�в�ͬ�����ͣ���������ͼ��һ���������͵�Cell��ȡ��һ���ַ���ʱ���п��ܱ��쳣��
					// Cannot get a STRING value from a NUMERIC cell
					// �����е���Ҫ����Cell�������ΪString��ʽ
					if (hssfCell1 != null) {
						hssfCell1.setCellType(Cell.CELL_TYPE_STRING);
						// ��ȡÿһ���е�ֵ
						attr = hssfCell1.getStringCellValue();
						if(attr.contains("\n")){
							attr = attr.replace("\n", "");
						}
					}else{
						attr = "";
					}
					
					list.add(attr);
				}
			} else {
				// 2.Excel����������
				XSSFWorkbook xssfWorkbook = new XSSFWorkbook(input);
				// 3.Excel���������
				XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
				// ������
				@SuppressWarnings("unused")
				int rowLength = xssfSheet.getLastRowNum();
				// ��ȡExcel�������ָ����
				XSSFRow xssfRow1 = xssfSheet.getRow(row);
				// ��ȡָ���еĵ�Ԫ��
				for (int i = 1; i < xssfRow1.getLastCellNum(); i++) {
					XSSFCell xssfCell1 = xssfRow1.getCell(i);

					// Excel����Cell�в�ͬ�����ͣ���������ͼ��һ���������͵�Cell��ȡ��һ���ַ���ʱ���п��ܱ��쳣��
					// Cannot get a STRING value from a NUMERIC cell
					// �����е���Ҫ����Cell�������ΪString��ʽ
					if (xssfCell1 != null) {
						xssfCell1.setCellType(Cell.CELL_TYPE_STRING);
						// ��ȡÿһ���е�ֵ
						attr = xssfCell1.getStringCellValue();
						if(attr.contains("\n")){
							attr = attr.replace("\n", "");
						}
					}else{
						attr = "";
					}

					list.add(attr);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	
	@SuppressWarnings({ "resource", "deprecation" })
	public static List<String> readExcelAtFirst(File file) {//��ȡExcel��ͷ
		String fileName = file.getName().toLowerCase();
		if (!file.exists()) {
			System.out.println("�ļ�������");
		}
		String attr = null;
		List<String> list = new ArrayList<String>();
		try {
			// 1.��ȡExcel�Ķ���
			// POIFSFileSystem poifsFileSystem = new POIFSFileSystem(
			// new FileInputStream(file));
			InputStream input = new FileInputStream(file);
			if (fileName.endsWith(".xls")) {
				// 2.Excel����������
				HSSFWorkbook hssfWorkbook = new HSSFWorkbook(input);
				// 3.Excel���������
				HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
				// ������
				@SuppressWarnings("unused")
				int rowLength = hssfSheet.getLastRowNum();

				// ��ȡExcel�����������
				HSSFRow hssfRow1 = hssfSheet.getRow(0);
				// ��ȡ���еĵ�Ԫ��������������
				int cellLength = hssfRow1.getLastCellNum();
				for (int i = 0; i < cellLength; i++) {
					HSSFCell hssfCell1 = hssfRow1.getCell(i);

					// Excel����Cell�в�ͬ�����ͣ���������ͼ��һ���������͵�Cell��ȡ��һ���ַ���ʱ���п��ܱ��쳣��
					// Cannot get a STRING value from a NUMERIC cell
					// �����е���Ҫ����Cell�������ΪString��ʽ
					if (hssfCell1 != null) {
						hssfCell1.setCellType(Cell.CELL_TYPE_STRING);
						// ��ȡÿһ���е�ֵ
						attr = hssfCell1.getStringCellValue();
						if(attr.contains("\n")){
							attr = attr.replace("\n", "");
						}
						if(attr.contains("(")&&attr.contains(")")){
							attr = attr.replace('(', '��');
							attr = attr.replace(')', '��');
						}
					}else{
						attr = "";
					}
					
					list.add(attr);
				}
			} else {
				// 2.Excel����������
				XSSFWorkbook xssfWorkbook = new XSSFWorkbook(input);
				// 3.Excel���������
				XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
				// ������
				@SuppressWarnings("unused")
				int rowLength = xssfSheet.getLastRowNum();
				// ��ȡExcel�����������
				XSSFRow xssfRow1 = xssfSheet.getRow(0);
				// ��ȡ���еĵ�Ԫ��
				for (int i = 0; i < xssfRow1.getLastCellNum(); i++) {
					XSSFCell xssfCell1 = xssfRow1.getCell(i);

					// Excel����Cell�в�ͬ�����ͣ���������ͼ��һ���������͵�Cell��ȡ��һ���ַ���ʱ���п��ܱ��쳣��
					// Cannot get a STRING value from a NUMERIC cell
					// �����е���Ҫ����Cell�������ΪString��ʽ
					if (xssfCell1 != null) {
						xssfCell1.setCellType(Cell.CELL_TYPE_STRING);
						// ��ȡÿһ���е�ֵ
						attr = xssfCell1.getStringCellValue();
						if(attr.contains("\n")){
							attr = attr.replace("\n", "");
						}
						if(attr.contains("(")&&attr.contains(")")){
							attr = attr.replace('(', '��');
							attr = attr.replace(')', '��');
						}
					}else{
						attr = "";
					}

					list.add(attr);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

}
