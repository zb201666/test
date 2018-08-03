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
	public static List<String> readExcelByColumn(File file, int column) {//按列读取Excel表格
		String fileName = file.getName().toLowerCase();
		if (!file.exists()) {
			System.out.println("文件不存在");
		}
		String attr = null;
		List<String> list = new ArrayList<String>();
		try {
			// 1.读取Excel的对象
			// POIFSFileSystem poifsFileSystem = new POIFSFileSystem(
			// new FileInputStream(file));
			InputStream input = new FileInputStream(file);
			if (fileName.endsWith(".xls")) {
				// 2.Excel工作薄对象
				HSSFWorkbook hssfWorkbook = new HSSFWorkbook(input);
				// 3.Excel工作表对象
				HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
				// 总行数
				int rowLength = hssfSheet.getLastRowNum();

				for (int i = 1; i <= rowLength; i++) {
					// 获取Excel工作表的行
					HSSFRow hssfRow1 = hssfSheet.getRow(i);
					// 获取指定单元格
					HSSFCell hssfCell1 = hssfRow1.getCell(column);

					// Excel数据Cell有不同的类型，当我们试图从一个数字类型的Cell读取出一个字符串时就有可能报异常：
					// Cannot get a STRING value from a NUMERIC cell
					// 将所有的需要读的Cell表格设置为String格式
					if (hssfCell1 != null) {
						hssfCell1.setCellType(Cell.CELL_TYPE_STRING);
						// 获取每一列中的值
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
				// 2.Excel工作薄对象
				XSSFWorkbook xssfWorkbook = new XSSFWorkbook(input);
				// 3.Excel工作表对象
				XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
				// 总行数
				int rowLength = xssfSheet.getLastRowNum();

				for (int i = 1; i <= rowLength; i++) {
					// 获取Excel工作表的行
					XSSFRow xssfRow1 = xssfSheet.getRow(i);
					// 获取指定单元格
					XSSFCell xssfCell1 = xssfRow1.getCell(column);

					// Excel数据Cell有不同的类型，当我们试图从一个数字类型的Cell读取出一个字符串时就有可能报异常：
					// Cannot get a STRING value from a NUMERIC cell
					// 将所有的需要读的Cell表格设置为String格式
					if (xssfCell1 != null) {
						xssfCell1.setCellType(Cell.CELL_TYPE_STRING);
						// 获取每一列中的值
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
	public static List<String> readExcelByRow(File file,int row) {//按行读取Excel表格
		String fileName = file.getName().toLowerCase();
		if (!file.exists()) {
			System.out.println("文件不存在");
		}
		String attr = null;
		List<String> list = new ArrayList<String>();
		try {
			// 1.读取Excel的对象
			// POIFSFileSystem poifsFileSystem = new POIFSFileSystem(
			// new FileInputStream(file));
			InputStream input = new FileInputStream(file);
			if (fileName.endsWith(".xls")) {
				// 2.Excel工作薄对象
				HSSFWorkbook hssfWorkbook = new HSSFWorkbook(input);
				// 3.Excel工作表对象
				HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
				// 总行数
				@SuppressWarnings("unused")
				int rowLength = hssfSheet.getLastRowNum();

				// 获取Excel工作表的指定行
				HSSFRow hssfRow1 = hssfSheet.getRow(row);
				// 获取指定行的单元格数量（列数）
				int cellLength = hssfRow1.getLastCellNum();
				for (int i = 1; i < cellLength; i++) {
					HSSFCell hssfCell1 = hssfRow1.getCell(i);

					// Excel数据Cell有不同的类型，当我们试图从一个数字类型的Cell读取出一个字符串时就有可能报异常：
					// Cannot get a STRING value from a NUMERIC cell
					// 将所有的需要读的Cell表格设置为String格式
					if (hssfCell1 != null) {
						hssfCell1.setCellType(Cell.CELL_TYPE_STRING);
						// 获取每一列中的值
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
				// 2.Excel工作薄对象
				XSSFWorkbook xssfWorkbook = new XSSFWorkbook(input);
				// 3.Excel工作表对象
				XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
				// 总行数
				@SuppressWarnings("unused")
				int rowLength = xssfSheet.getLastRowNum();
				// 获取Excel工作表的指定行
				XSSFRow xssfRow1 = xssfSheet.getRow(row);
				// 获取指定行的单元格
				for (int i = 1; i < xssfRow1.getLastCellNum(); i++) {
					XSSFCell xssfCell1 = xssfRow1.getCell(i);

					// Excel数据Cell有不同的类型，当我们试图从一个数字类型的Cell读取出一个字符串时就有可能报异常：
					// Cannot get a STRING value from a NUMERIC cell
					// 将所有的需要读的Cell表格设置为String格式
					if (xssfCell1 != null) {
						xssfCell1.setCellType(Cell.CELL_TYPE_STRING);
						// 获取每一列中的值
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
	public static List<String> readExcelAtFirst(File file) {//读取Excel表头
		String fileName = file.getName().toLowerCase();
		if (!file.exists()) {
			System.out.println("文件不存在");
		}
		String attr = null;
		List<String> list = new ArrayList<String>();
		try {
			// 1.读取Excel的对象
			// POIFSFileSystem poifsFileSystem = new POIFSFileSystem(
			// new FileInputStream(file));
			InputStream input = new FileInputStream(file);
			if (fileName.endsWith(".xls")) {
				// 2.Excel工作薄对象
				HSSFWorkbook hssfWorkbook = new HSSFWorkbook(input);
				// 3.Excel工作表对象
				HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
				// 总行数
				@SuppressWarnings("unused")
				int rowLength = hssfSheet.getLastRowNum();

				// 获取Excel工作表的首行
				HSSFRow hssfRow1 = hssfSheet.getRow(0);
				// 获取首行的单元格数量（列数）
				int cellLength = hssfRow1.getLastCellNum();
				for (int i = 0; i < cellLength; i++) {
					HSSFCell hssfCell1 = hssfRow1.getCell(i);

					// Excel数据Cell有不同的类型，当我们试图从一个数字类型的Cell读取出一个字符串时就有可能报异常：
					// Cannot get a STRING value from a NUMERIC cell
					// 将所有的需要读的Cell表格设置为String格式
					if (hssfCell1 != null) {
						hssfCell1.setCellType(Cell.CELL_TYPE_STRING);
						// 获取每一列中的值
						attr = hssfCell1.getStringCellValue();
						if(attr.contains("\n")){
							attr = attr.replace("\n", "");
						}
						if(attr.contains("(")&&attr.contains(")")){
							attr = attr.replace('(', '（');
							attr = attr.replace(')', '）');
						}
					}else{
						attr = "";
					}
					
					list.add(attr);
				}
			} else {
				// 2.Excel工作薄对象
				XSSFWorkbook xssfWorkbook = new XSSFWorkbook(input);
				// 3.Excel工作表对象
				XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
				// 总行数
				@SuppressWarnings("unused")
				int rowLength = xssfSheet.getLastRowNum();
				// 获取Excel工作表的首行
				XSSFRow xssfRow1 = xssfSheet.getRow(0);
				// 获取首行的单元格
				for (int i = 0; i < xssfRow1.getLastCellNum(); i++) {
					XSSFCell xssfCell1 = xssfRow1.getCell(i);

					// Excel数据Cell有不同的类型，当我们试图从一个数字类型的Cell读取出一个字符串时就有可能报异常：
					// Cannot get a STRING value from a NUMERIC cell
					// 将所有的需要读的Cell表格设置为String格式
					if (xssfCell1 != null) {
						xssfCell1.setCellType(Cell.CELL_TYPE_STRING);
						// 获取每一列中的值
						attr = xssfCell1.getStringCellValue();
						if(attr.contains("\n")){
							attr = attr.replace("\n", "");
						}
						if(attr.contains("(")&&attr.contains(")")){
							attr = attr.replace('(', '（');
							attr = attr.replace(')', '）');
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
