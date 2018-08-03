package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class testExcel {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO 自动生成的方法存根

		Workbook workbook = test(5);
		File file = new File("C:\\word\\模具\\模具导入信息格式.xlsx");
		String path = file.getAbsolutePath();
		String newpath = null;
		if (path.endsWith(".xls")) {
			newpath = path.replace(".xls", "-新.xls");
		} else {
			newpath = path.replace(".xlsx", "-新.xlsx");
		}
		File newfile = new File(newpath);
		if (newfile.exists()) {
			newfile.delete();
			newfile.createNewFile();
		} else {
			newfile.createNewFile();
		}
		FileOutputStream out = new FileOutputStream(newfile);
		workbook.write(out);
		out.close();
	}

	@SuppressWarnings("deprecation")
	public static Workbook test(int i) throws FileNotFoundException,
			IOException {
		File file = new File("C:\\word\\模具\\模具导入信息格式.xlsx");
		String moudldSp = "aaa";
		FileInputStream in = new FileInputStream(file);
		String path = file.getAbsolutePath();

		Workbook workbook = null;
		Sheet sheet = null;
		Row row = null;
		Cell cell = null;
		if (path.endsWith(".xls")) {
			workbook = new HSSFWorkbook(in);
			sheet = (HSSFSheet) workbook.getSheetAt(0);

		} else {
			workbook = new XSSFWorkbook(in);
			sheet = (XSSFSheet) workbook.getSheetAt(0);
		}
		for (int j = 1; j < i; j++) {
			row = sheet.getRow(j);
			cell = row.getCell(2);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			cell.setCellValue(moudldSp);
			System.out.println(cell.getStringCellValue());
		}
		return workbook;
	}

}
