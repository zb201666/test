package com.testKeySave;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Java����ϵͳĬ�ϳ���򿪱����ļ� �����ṩ�����ִ򿪷�ʽ
 * 
 * @author Administrator
 * 
 */
public class OpenLocalFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		useProcessBuilder();
		useAWTDesktop();
		useRuntimeExec();
	}

	/**
	 * ����java.lang.ProcessBuilder��
	 */
	private static void useProcessBuilder() throws IOException {
		// new ProcessBuilder("notepad.exe",
		// "C:/Users/Jadyer/Desktop/test file/readme.txt").start();
		List<String> commands = new ArrayList<String>();
		commands.add("D:/Program Files/WPS/9.1.0.4047/office6/wps.exe");
		commands.add("C:/Users/Jadyer/Desktop/test file/myResume.doc");
		new ProcessBuilder(commands).start();
	}

	/**
	 * ����java.awt.Desktop��
	 * 
	 * @see �򿪵�Ŀ¼���ļ�������������ո�
	 */
	private static void useAWTDesktop() throws IOException {
		Desktop.getDesktop().open(new File("D:/my local/��������.xls"));
	}

	/**
	 * ����java.lang.Runtime��
	 * 
	 * @see WPS����--------Runtime.getRuntime().exec("cmd /c start wps")
	 * @see WPS���--------Runtime.getRuntime().exec("cmd /c start et")
	 * @see WPS��ʾ--------Runtime.getRuntime().exec("cmd /c start wpp")
	 * @see Office Word---Runtime.getRuntime().exec("cmd /c start winword")
	 * @see Office Excel--Runtime.getRuntime().exec("cmd /c start excel")
	 */
	private static void useRuntimeExec() throws IOException {
		// ���򿪵�Ŀ¼���ļ����в������ո�,��������ķ�ʽ
		Runtime.getRuntime().exec("cmd /c start D:/mylocal/��������.xls");
		// ����'����'��'Win+R'��Ȼ������'cmd /?'�鿴������Ϣ
		Runtime.getRuntime().exec(
				new String[] { "cmd.exe", "/c", "D:/my local/��������.xls" });
		// �������ذ�װ�����
		// ���򿪵�Ŀ¼���ļ����а����ո���������Ϊ����..�������س���İ�װĿ¼�����ո�
		String etCommand = "D:/Program Files/WPS/8.1.0.3526/office6/et.exe";
		String filePath = "D:/mylocal/��������.xls";
		Runtime.getRuntime().exec(etCommand + " " + filePath);

		// ͨ��rundll32����
		Runtime.getRuntime().exec(
				"rundll32 url.dll FileProtocolHandler" + " " + filePath);
	}

}
