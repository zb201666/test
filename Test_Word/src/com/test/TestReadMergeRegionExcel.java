package com.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;
import org.junit.Test;

/**
 * 
 * @author wcyong
 * 
 * @date 2013-6-21
 */
public class TestReadMergeRegionExcel {

	@Test
	public void testReadExcel() {
		File file = new File("C:\\word\\模具\\模具导入信息格式2(1).xlsx");
		Sheet sheet = getSheet(createWorkbook(file), 0);
		ArrayList<String> values = new ArrayList<String>();
		// String value = getMergedRegionValue(sheet,5,4);
		// System.out.println(value);
		 String value = readExcelByCell(sheet,5,6);
		 System.out.println(value);
		// values = readExcelByColumnFrom(sheet,5,1);
		// values = readExcelByRowFrom(sheet, 0, 4);
//		 values = readExcel2(sheet, 0, 8);
		// values = readExcel2(sheet,5,8);
//		int num = getMergedNum(sheet);
//		System.out.println(num);
//		values = getMergedRegionValues(sheet,0,8);
//		for (int i = 0; i < values.size(); i++) {
//			System.out.println(values.get(i));
//		}
	}

	public static Workbook createWorkbook(File file) {
		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return wb;
	}

	private static Sheet getSheet(Workbook wb, int sheetIndex) {
		Sheet sheet = wb.getSheetAt(sheetIndex);
		return sheet;
	}

	/**
	 * 读取excel文件中指定行数范围的内容
	 * 
	 * @param startReadLine
	 *            开始读取的行
	 * @param tailLine
	 *            最后读取的行
	 */
	private static ArrayList<String> readExcel(Sheet sheet, int startReadLine,
			int tailLine) {
		Row row = null;
		String rs = null;
		ArrayList<String> value = new ArrayList<String>();

		for (int i = startReadLine; i <= tailLine; i++) {
			row = sheet.getRow(i);
			for (Cell c : row) {
				boolean isMerge = isMergedRegion(sheet, i, c.getColumnIndex());
				// 判断是否具有合并单元格
				if (isMerge) {
					rs = getMergedRegionValue(sheet, row.getRowNum(),
							c.getColumnIndex());
					value.add(rs);
				} else {
					rs = getCellValue(c);
					value.add(rs);
				}
			}

		}
		return value;

	}

	/**
	 * 读取excel文件中指定行数范围的合并单元格内容
	 * 
	 * @param startReadLine
	 *            开始读取的行
	 * @param tailLine
	 *            最后读取的行
	 */
	private static ArrayList<String> readExcel2(Sheet sheet, int startReadLine,
			int tailLine) {
		Row row = null;
		String rs = null;
		ArrayList<String> value = new ArrayList<String>();

		for (int i = startReadLine; i <= tailLine; i++) {
			row = sheet.getRow(i);
			for (Cell c : row) {
				boolean isMerge = isMergedRegion(sheet, i, c.getColumnIndex());
				// 判断是否具有合并单元格
				if (isMerge) {
					rs = getMergedRegionValue(sheet, row.getRowNum(),
							c.getColumnIndex());
					value.add(rs);
				}
			}

		}
		return value;

	}

	/**
	 * 获取合并单元格的值
	 * 
	 * @param sheet
	 * @param row
	 * @param column
	 * @return
	 */
	public static String getMergedRegionValue(Sheet sheet, int row, int column) {
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
					value = getCellValue(fCell);
				}
			}
		}

		return value;
	}

	/**
	 * 获取指定个数范围的合并单元格的值
	 * 
	 * @param sheet
	 * @param firstNum
	 *            开始
	 * @param lastNum
	 *            结束
	 * @return
	 */
	public static ArrayList<String> getMergedRegionValues (Sheet sheet, int row, int column) {
		int sheetMergeCount = sheet.getNumMergedRegions();
		String value = null;
		ArrayList<String> values = new ArrayList<String>();
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
					value = getCellValue(fCell);
					values.add(value);
				}
			}
		}
		return values;
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
	 * 判断合并了列
	 * 
	 * @param sheet
	 * @param row
	 * @param column
	 * @return
	 */
	private static boolean isMergedColumn(Sheet sheet, int row, int column) {
		int sheetMergeCount = sheet.getNumMergedRegions();
		for (int i = 0; i < sheetMergeCount; i++) {
			CellRangeAddress range = sheet.getMergedRegion(i);
			int firstColumn = range.getFirstColumn();
			int lastColumn = range.getLastColumn();
			int firstRow = range.getFirstRow();
			int lastRow = range.getLastRow();
			if (row >= firstRow && row <= lastRow) {
				if (column == firstColumn && column == lastColumn) {
					return true;
				}
			}
		}
		return false;
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

	/**
	 * 判断sheet页中是否含有合并单元格
	 * 
	 * @param sheet
	 * @return
	 */
	private static boolean hasMerged(Sheet sheet) {
		return sheet.getNumMergedRegions() > 0 ? true : false;
	}

	private static int getMergedNum(Sheet sheet) {
		return sheet.getNumMergedRegions();
	}

	/**
	 * 合并单元格
	 * 
	 * @param sheet
	 * @param firstRow
	 *            开始行
	 * @param lastRow
	 *            结束行
	 * @param firstCol
	 *            开始列
	 * @param lastCol
	 *            结束列
	 */
	private void mergeRegion(Sheet sheet, int firstRow, int lastRow,
			int firstCol, int lastCol) {
		sheet.addMergedRegion(new CellRangeAddress(firstRow, lastRow, firstCol,
				lastCol));
	}

	/**
	 * 从开始行读取指定列的数据
	 * 
	 * @param startRow
	 *            ：开始行
	 * 
	 * @param column
	 *            ：指定列
	 * @param sheet
	 * @return
	 * 
	 */
	public ArrayList<String> readExcelByColumnFrom(Sheet sheet, int startRow,
			int column) {
		int LastRowNum = sheet.getLastRowNum();
		ArrayList<String> cellValues = new ArrayList<String>();
		for (int i = startRow; i <= LastRowNum; i++) {
			Row row = sheet.getRow(i);
			Cell cell = row.getCell(column);
			String cellValue = getCellValue(cell);
			cellValues.add(cellValue);
		}
		return cellValues;
	}

	/**
	 * 从开始列读取指定行的数据
	 * 
	 * @param startColumn
	 *            ：开始列
	 * 
	 * @param Row
	 *            ：指定行
	 * @param sheet
	 * @return
	 * 
	 */
	public ArrayList<String> readExcelByRowFrom(Sheet sheet, int startColumn,
			int Row) {
		Row row = sheet.getRow(Row);
		int LastCellNum = row.getLastCellNum();
		ArrayList<String> cellValues = new ArrayList<String>();
		for (int i = startColumn; i < LastCellNum; i++) {
			Cell cell = row.getCell(i);
			String cellValue = getCellValue(cell);
			cellValues.add(cellValue);
		}
		return cellValues;
	}

	/**
	 * 读取指定单元格的数据
	 * 
	 * @param row
	 *            ：指定行
	 * 
	 * @param column
	 *            ：指定列
	 * @param sheet
	 * @return
	 * 
	 */
	public String readExcelByCell(Sheet sheet, int row, int column) {
		String cellValue = null;
		Row row1 = sheet.getRow(row);
		Cell cell = row1.getCell(column);
		cellValue = getCellValue(cell);
		return cellValue;
	}

	/**
	 * 设置指定单元格的数据
	 * 
	 * @param row
	 *            ：指定行
	 * 
	 * @param column
	 *            ：指定列
	 * @param sheet
	 * 
	 */
	public void setExcelByCell(Sheet sheet, int row, int column,
			String cellValue) {
		Row row1 = sheet.getRow(row);
		Cell cell = row1.getCell(column);
		cell.setCellType(Cell.CELL_TYPE_STRING);
		cell.setCellValue(cellValue);
	}

	/**
	 * 获取单元格的值
	 * 
	 * @param cell
	 * @return
	 */
	public static String getCellValue(Cell cell) {
		String cellValue = null;
		if (cell == null) {
			cellValue = "";
		} else {
			cell.setCellType(Cell.CELL_TYPE_STRING);
			cellValue = cell.getStringCellValue();
			if (cellValue.contains("\n")) {
				cellValue = cellValue.replace("\n", "");
			}
			if (cellValue.contains("(") && cellValue.contains(")")) {
				cellValue = cellValue.replace('(', '（');
				cellValue = cellValue.replace(')', '）');
			}
		}
		return cellValue;
		// if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
		//
		// return cell.getStringCellValue();
		//
		// } else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
		//
		// return String.valueOf(cell.getBooleanCellValue());
		//
		// } else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
		//
		// return cell.getCellFormula();
		//
		// } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
		//
		// return String.valueOf(cell.getNumericCellValue());
		//
		// }
	}
}
