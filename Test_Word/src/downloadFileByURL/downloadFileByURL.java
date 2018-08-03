package downloadFileByURL;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class downloadFileByURL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		try {
			Scanner in = new Scanner(System.in);
			System.out.println("������URL���ӣ�");
			String url = in.next();
			System.out.println("�����뱣����ļ�����");
			String filename = in.next();
			System.out.println("�����뱣��ĵط���");
			String filelocation = in.next();
			download(url, filename, filelocation);
			in.close();
			String file = filelocation+ "\"" + filename;
			if(file!=null&&!file.equals("")){
				Runtime.getRuntime().exec("cmd /c \""+file);
			}
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}

	public static void download(String urlString, String fileName,
			String savePath) throws IOException {
		URL url = new URL(urlString);

		URLConnection conn = url.openConnection();
		InputStream is = conn.getInputStream();

		// ʹ��һ��ָ��������������ָ��
		// InputStream is = url.openStream();
		byte[] buff = new byte[1024];
		int len = 0;
		// ������
		File file = new File(savePath);
		if (!file.exists()) {
			file.mkdirs();

		}
		// д����
		OutputStream os = new FileOutputStream(file.getAbsolutePath() + "\\"
				+ fileName);
		// һ�߶�һ��д
		while ((len = is.read(buff)) != -1) {
			os.write(buff, 0, len);// �Ѷ���д��ָ������������
			
		}
		// �ͷ���Դ
		if(os!=null){
			os.close();
		}
		if(is!=null){
			is.close();
		}
		
	}
}
