package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class TestMerge {

	@Test
	public void test() {
		File file = new File("C:\\word\\模具\\模具导入-小件事业部汇总表2.xls");
		InputStream inputStream = null;
		Workbook wb = createWorkbook(file, inputStream);
		Sheet sheet = wb.getSheetAt(0);

		for (int i = 2; i <= sheet.getLastRowNum(); i++) {
			boolean flag = isMergedRegion(sheet, i, 1);
			
			if (flag == true) {
				CellRangeAddress oldRange = sheet.getMergedRegion(i);
				System.out.println(oldRange.getFirstRow());
				System.out.println(oldRange.getLastRow());
			}
//			try {
//				System.out.println(getMergedRegionValue(sheet,i,1));
//			} catch (Exception e) {
//				// TODO 自动生成的 catch 块
//				e.printStackTrace();
//			}
		}

	}

	public static String getMergedRegionValue(Sheet sheet, int row, int column)
			throws Exception {
		int sheetMergeCount = sheet.getNumMergedRegions();
		String value = null;
		for (int i = 0; i < sheetMergeCount; i++) {
			CellRangeAddress ca = sheet.getMergedRegion(i);
			int firstColumn = ca.getFirstColumn();
			int lastColumn = ca.getLastColumn();
			int firstRow = ca.getFirstRow();
			int lastRow = ca.getLastRow();

			if (row >= firstRow && row <= lastRow) {

				if (column >= firstColumn && column <= lastColumn) {
					Row fRow = sheet.getRow(firstRow);
					Cell fCell = fRow.getCell(firstColumn);
					value = delate(getCellValue(fCell));
				}
			}
		}

		return value;
	}
	
	
	/**
	 * 判断合并了行
	 * 
	 * @param sheet
	 * @param row
	 * @param column
	 * @return
	 */
	private static boolean isMergedRow(Sheet sheet, int row, int column) {
		int sheetMergeCount = sheet.getNumMergedRegions();
		for (int i = 0; i < sheetMergeCount; i++) {
			CellRangeAddress range = sheet.getMergedRegion(i);
			int firstColumn = range.getFirstColumn();
			int lastColumn = range.getLastColumn();
			int firstRow = range.getFirstRow();
			int lastRow = range.getLastRow();
			if (row == firstRow && row == lastRow) {
				if (column >= firstColumn && column <= lastColumn) {
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * 获取单元格的值
	 * 
	 * @param cell
	 * @return
	 * @throws Exception
	 */
	public static String getCellValue(Cell cell) throws Exception {
		String cellValue = "";
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_NUMERIC: // 数字
			DecimalFormat df = new DecimalFormat("0.##########");
			cellValue = df.format(cell.getNumericCellValue());
			break;

		case Cell.CELL_TYPE_STRING: // 字符串
			cellValue = cell.getStringCellValue();
			break;

		case Cell.CELL_TYPE_BOOLEAN: // Boolean
			cellValue = cell.getBooleanCellValue() + "";
			break;

		case Cell.CELL_TYPE_FORMULA: // 公式
			cellValue = cell.getCellFormula() + "";
			break;

		case Cell.CELL_TYPE_BLANK: // 空值
			cellValue = "";
			break;

		case Cell.CELL_TYPE_ERROR: // 故障
			cellValue = "";
			throw new Exception("非法字符");
		default:
			cellValue = "";
			throw new Exception("未知类型");
		}

		return cellValue;

	}

	public static String delate(String cellValue) {
		if (cellValue.contains("\n")) {
			cellValue = cellValue.replace("\n", "");
		}
		if (cellValue.contains("\r\n")) {
			cellValue = cellValue.replace("\r\n", "");
		}
		if (cellValue.contains("\r")) {
			cellValue = cellValue.replace("\r", "");
		}
		if (cellValue.contains("(") && cellValue.contains(")")) {
			cellValue = cellValue.replace('(', '（');
			cellValue = cellValue.replace(')', '）');
		}
		return cellValue.trim();
	}
	
	
	/**
	 * 判断指定的单元格是否是合并单元格
	 * 
	 * @param sheet
	 * @param row
	 *            行下标
	 * @param column
	 *            列下标
	 * @return
	 */
	private static boolean isMergedRegion(Sheet sheet, int row, int column) {
		int sheetMergeCount = sheet.getNumMergedRegions();
		for (int i = 0; i < sheetMergeCount; i++) {
			CellRangeAddress range = sheet.getMergedRegion(i);
			int firstColumn = range.getFirstColumn();
			int lastColumn = range.getLastColumn();
			int firstRow = range.getFirstRow();
			int lastRow = range.getLastRow();
			if (row >= firstRow && row <= lastRow) {
				if (column >= firstColumn && column <= lastColumn) {
					return true;
				}
			}
		}
		return false;
	}

	public static Workbook createWorkbook(File file, InputStream inputStream) {
		Workbook wb = null;
		try {
			String path = file.getAbsolutePath();
			inputStream = new FileInputStream(path);
			if (path.endsWith(".xls")) {
				wb = new HSSFWorkbook(inputStream);
			}
			if (path.endsWith(".xlsx")) {
				wb = new XSSFWorkbook(inputStream);
			}
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return wb;
	}

}
