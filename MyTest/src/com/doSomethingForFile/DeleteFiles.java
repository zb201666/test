package com.doSomethingForFile;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class DeleteFiles {

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		// TODO �Զ����ɵķ������
		Timer t = new Timer();
		String startDate = "2018-8-3 14:00:00";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = format.parse(startDate);
		t.schedule(new Delete(), d);
	}
}

class Delete extends TimerTask {

	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		File file = new File("C:" + File.separator + "word" + File.separator
				+ "test.txt");
		deleteFiles(file);
	}

	public void deleteFiles(File file) {
		if (file.exists()) {
			File[] files = file.listFiles();
			if (files != null) {
				for (File f : files) {
					if (f.isDirectory()) {
						deleteFiles(f);
					}
					if (f.isFile()) {
						f.delete();
					}
				}
			} else {
				file.delete();
			}
			System.out.println("�ļ�ɾ���ɹ�");
		} else {
			System.out.println("�ļ�������");
		}

	}
}