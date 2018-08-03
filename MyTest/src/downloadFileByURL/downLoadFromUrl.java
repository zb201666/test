package downloadFileByURL;

import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

public class downLoadFromUrl {

	/**
	 * ������Url�������ļ�
	 * 
	 * @param urlStr
	 * @param fileName
	 * @param savePath
	 * @throws IOException
	 */
	public static void downLoadFromUrl(String urlStr, String fileName,
			String savePath) {
		URL url = null;
		// �õ�������
		InputStream inputStream = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			String begin = "^([A-Za-z]:){1}$";
			if(urlStr.substring(0, 2).matches(begin)){
				url = new URL("file:///"+urlStr);
				URLConnection conn = url.openConnection();
				inputStream = conn.getInputStream();
			}else if(urlStr.toLowerCase().startsWith("http:")){
				url = new URL(urlStr);
				HttpURLConnection conn = (HttpURLConnection)url.openConnection();
				// ���ó�ʱ��Ϊ120��
				conn.setConnectTimeout(120 * 1000);
				// ��ֹ���γ���ץȡ������403����
				conn.setRequestProperty("User-Agent",
						"Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
				inputStream = conn.getInputStream();
				if(Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)){
					Desktop.getDesktop().browse(new URI(urlStr));
				}else{
					String str = "cmd /c start iexplore"+" "+urlStr;   
			        Runtime.getRuntime().exec(str);  
				}
			}else if(urlStr.toLowerCase().startsWith("https:")){
				url = new URL(urlStr);
				HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
				conn.setConnectTimeout(120 * 1000);
				conn.setRequestProperty("User-Agent",
						"Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
				inputStream = conn.getInputStream();
			}
			
			// ��ȡ�Լ�����
			// byte[] getData = readInputStream(inputStream);
			bis = new BufferedInputStream(inputStream);
			
			// �ļ�����λ��
			File saveDir = new File(savePath);
			if (!saveDir.exists()) {
				saveDir.mkdir();
			}
			File file = new File(saveDir + File.separator + fileName);
			if (file.exists()) {
				file.delete();
			}
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			int b = 0;
			byte[] byArr = new byte[1024 * 4];
			while ((b = bis.read(byArr)) != -1) {
				bos.write(byArr, 0, b);
			}
			// fos.write(getData);
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} finally {
			close(bis, inputStream, bos, fos);
		}

		System.out.println("info: ����" + url + "��Ӧ���ļ����سɹ�������");

	}

	public static void close(InputStream inputStream1,
			InputStream inputStream2, OutputStream outputStream1,
			OutputStream outputStream2) {
		try {
			if (inputStream1 != null) {
				inputStream1.close();
			}
			if (inputStream2 != null) {
				inputStream2.close();
			}
			if (outputStream1 != null) {
				outputStream1.close();
			}
			if (outputStream2 != null) {
				outputStream2.close();
			}
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}

	/**
	 * ���������л�ȡ�ֽ�����
	 * 
	 * @param inputStream
	 * @return
	 * @throws IOException
	 */
	public static byte[] readInputStream(InputStream inputStream)
			throws IOException {
		byte[] buffer = new byte[1024];
		int len = 0;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		while ((len = inputStream.read(buffer)) != -1) {
			bos.write(buffer, 0, len);
		}
		bos.close();
		return bos.toByteArray();
	}

	public static void main(String[] args) {
		try {
			// downLoadFromUrl("http://101.95.48.97:8005/res/upload/interface/apptutorials/manualstypeico/6f83ce8f-0da5-49b3-bac8-fd5fc67d2725.png",
			// "�ٶ�.jpg","d:/resource/images/diaodiao/country/");
			 downLoadFromUrl("http://10.3.135.58:9000/mosu.document/file/tip/%D3%C3%BB%A7%B2%D9%D7%F7%CE%C4%B5%B5/%C4%A3%CB%DC%B9%AB%CB%BE%CA%FD%D7%D6%BB%AF%B9%A4%D2%D5%CF%B5%CD%B3%D3%C3%BB%A7%B2%D9%D7%F7%CA%D6%B2%E1.docx","�����ֲ�.docx","c:/word");
//			downLoadFromUrl(
//					"Z:\\files\\project\\Config_Files\\����ϵͳ�����嵥.docx",
//					"����ϵͳ�����嵥.docx", "c:\\word");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
