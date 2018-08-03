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
			System.out.println("文件不存在");
		}
		String attr = null;
		List<String> list = new ArrayList<String>();
		try {
			// 1.读取Excel的对象
			// POIFSFileSystem poifsFileSystem = new POIFSFileSystem(
			// new FileInputStream(file));
			InputStream input = new FileInputStream(file2);
			if (fileName.endsWith(".xls")) {
				// 2.Excel工作薄对象
				HSSFWorkbook hssfWorkbook = new HSSFWorkbook(input);
				// 3.Excel工作表对象
				HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
				// 总行数
				int rowLength = hssfSheet.getLastRowNum() + 1;

				for (int j = 1; j < rowLength; j++) {
					// 获取Excel工作表的行
					HSSFRow hssfRow1 = hssfSheet.getRow(j);
					// 获取指定单元格
					HSSFCell hssfCell1 = hssfRow1.getCell(i);

					// Excel数据Cell有不同的类型，当我们试图从一个数字类型的Cell读取出一个字符串时就有可能报异常：
					// Cannot get a STRING value from a NUMERIC cell
					// 将所有的需要读的Cell表格设置为String格式
					if (hssfCell1 != null) {
						hssfCell1.setCellType(CellType.STRING);
					}

					// 获取每一列中的值
					attr = hssfCell1.getStringCellValue();
					list.add(attr);
				}
			} else {
				// 2.Excel工作薄对象
				XSSFWorkbook xssfWorkbook = new XSSFWorkbook(input);
				// 3.Excel工作表对象
				XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
				// 总行数
				int rowLength = xssfSheet.getLastRowNum() + 1;

				for (int j = 1; j < rowLength; j++) {
					// 获取Excel工作表的行
					XSSFRow xssfRow1 = xssfSheet.getRow(j);
					// 获取指定单元格
					XSSFCell xssfCell1 = xssfRow1.getCell(i);

					// Excel数据Cell有不同的类型，当我们试图从一个数字类型的Cell读取出一个字符串时就有可能报异常：
					// Cannot get a STRING value from a NUMERIC cell
					// 将所有的需要读的Cell表格设置为String格式
					if (xssfCell1 != null) {
						xssfCell1.setCellType(CellType.STRING);
					}

					// 获取每一列中的值
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
		File file = new File("C:\\word\\物料信息.xlsx");
		list = (ArrayList<String>) readExcelCellAt(file,1);
		for(int i= 0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
}
