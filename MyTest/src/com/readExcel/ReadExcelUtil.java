package com.readExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelUtil {
	private static Logger logger = Logger.getLogger(ReadExcelUtil.class);
	private final static String xls = "xls";
	private final static String xlsx = "xlsx";

	/**
	 * ���ж���excel�ļ��������󷵻�
	 * 
	 * @param file
	 * @throws IOException
	 */
	public static List<String[]> readExcelByRow(File file) throws IOException {
		// ����ļ�
		checkFile(file);
		// ���Workbook����������
		Workbook workbook = getWorkBook(file);
		// �������ض��󣬰�ÿ���е�ֵ��Ϊһ�����飬��������Ϊһ�����Ϸ���
		List<String[]> list = new ArrayList<String[]>();
		if (workbook != null) {
			for (int sheetNum = 0; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
				// ��õ�ǰsheet������
				Sheet sheet = workbook.getSheetAt(sheetNum);
				if (sheet == null) {
					continue;
				}
				// ��õ�ǰsheet�Ŀ�ʼ��
				int firstRowNum = sheet.getFirstRowNum();
				// ��õ�ǰsheet�Ľ�����
				int lastRowNum = sheet.getLastRowNum();
				// ѭ�����˵�һ�е������У���һ�������Ǳ�ͷ��
				for (int rowNum = firstRowNum + 1; rowNum <= lastRowNum; rowNum++) {
					// ��õ�ǰ��
					Row row = sheet.getRow(rowNum);
					if (row == null) {
						continue;
					}
					// ��õ�ǰ�еĿ�ʼ��
					int firstCellNum = row.getFirstCellNum();
					// ��õ�ǰ�е�����
					int lastCellNum = row.getPhysicalNumberOfCells();
					String[] cells = new String[row.getPhysicalNumberOfCells() - 1];
					// ѭ�����˵�һ�е������У���һ����������ţ�
					for (int cellNum = firstCellNum + 1; cellNum < lastCellNum; cellNum++) {
						Cell cell = row.getCell(cellNum);
						cells[cellNum - 1] = getCellValue(cell);
					}
					list.add(cells);
				}
			}
			workbook.close();
		}
		return list;
	}

	/**
	 * ���ж���excel�ļ��������󷵻�
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static List<String[]> readExcelByColumn(File file)
			throws IOException {
		// ����ļ�
		checkFile(file);
		// ���Workbook����������
		Workbook workbook = getWorkBook(file);
		// �������ض��󣬰�ÿ���е�ֵ��Ϊһ�����飬��������Ϊһ�����Ϸ���
		List<String[]> list = new ArrayList<String[]>();
		if (workbook != null) {
			for (int sheetNum = 0; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
				// ��õ�ǰsheet������
				Sheet sheet = workbook.getSheetAt(sheetNum);
				if (sheet == null) {
					continue;
				}
				// ��õ�ǰsheet�Ŀ�ʼ��
				int firstRowNum = sheet.getFirstRowNum();
				// ��õ�ǰsheet�Ľ�����
				int lastRowNum = sheet.getLastRowNum();
				// ȡ�õ�ǰsheet������
				Row row = sheet.getRow(0);
				// ȡ�õ�ǰsheet�Ŀ�ʼ��
				int firstCellNum = row.getFirstCellNum();
				// ȡ�õ�ǰsheet�Ľ�����
				int lastCellNum = row.getLastCellNum();
				// ѭ�����˵�һ�е������У���һ����������ţ�
				for (int cellNum = firstCellNum + 1; cellNum < lastCellNum; cellNum++) {
					String[] cells = new String[sheet.getPhysicalNumberOfRows() - 1];
					// ѭ�����˵�һ�е������У���һ�������Ǳ�ͷ��
					for (int rowNum = firstRowNum + 1; rowNum <= lastRowNum; rowNum++) {
						row = sheet.getRow(rowNum);
						Cell cell = row.getCell(cellNum);
						cells[rowNum - 1] = getCellValue(cell);
					}
					list.add(cells);
				}
			}
			workbook.close();
		}
		return list;
	}

	/**
	 * ����ļ��Ƿ����
	 * 
	 * @param file
	 * @throws IOException
	 */
	public static void checkFile(File file) throws IOException {
		// �ж��ļ��Ƿ����
		if (file == null) {
			logger.error("�ļ������ڣ�");
			throw new FileNotFoundException("�ļ������ڣ�");
		}
		// ����ļ��� ��������ת��ΪСд
		String fileName = file.getName().toLowerCase();
		// �ж��ļ��Ƿ���excel�ļ�
		if (!fileName.endsWith(xls) && !fileName.endsWith(xlsx)) {
			logger.error(fileName + "����excel�ļ�");
			throw new IOException(fileName + "����excel�ļ�");
		}
	}

	/**
	 * �����ļ���׺����ͬ(xls��xlsx)��ò�ͬ��Workbookʵ�������
	 * 
	 * @param file
	 * @return
	 */
	public static Workbook getWorkBook(File file) {
		// ����ļ��� ��������ת��ΪСд
		String fileName = file.getName().toLowerCase();
		// ����Workbook���������󣬱�ʾ����excel
		Workbook workbook = null;
		try {
			// ��ȡexcel�ļ���io��
			InputStream is = new FileInputStream(file);
			// �����ļ���׺����ͬ(xls��xlsx)��ò�ͬ��Workbookʵ�������
			if (fileName.endsWith(xls)) {
				// 2003
				workbook = new HSSFWorkbook(is);
			} else if (fileName.endsWith(xlsx)) {
				// 2007
				workbook = new XSSFWorkbook(is);
			}
		} catch (IOException e) {
			logger.info(e.getMessage());
		}
		return workbook;
	}

	/**
	 * ȡ�õ�Ԫ���ֵ
	 * 
	 * @param cell
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static String getCellValue(Cell cell) {
		String cellValue = "";
		if (cell == null) {
			return cellValue;
		}
		// �����ֵ���String�������������1����1.0�����
		if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			cell.setCellType(Cell.CELL_TYPE_STRING);
		}
		// �ж����ݵ�����
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_NUMERIC: // ����
			cellValue = String.valueOf(cell.getNumericCellValue());
			break;
		case Cell.CELL_TYPE_STRING: // �ַ���
			cellValue = String.valueOf(cell.getStringCellValue());
			break;
		case Cell.CELL_TYPE_BOOLEAN: // Boolean
			cellValue = String.valueOf(cell.getBooleanCellValue());
			break;
		case Cell.CELL_TYPE_FORMULA: // ��ʽ
			cellValue = String.valueOf(cell.getCellFormula());
			break;
		case Cell.CELL_TYPE_BLANK: // ��ֵ
			cellValue = "";
			break;
		case Cell.CELL_TYPE_ERROR: // ����
			cellValue = "�Ƿ��ַ�";
			break;
		default:
			cellValue = "δ֪����";
			break;
		}
		return cellValue;
	}
}
