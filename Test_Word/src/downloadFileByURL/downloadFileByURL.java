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
		// TODO 自动生成的方法存根
		try {
			Scanner in = new Scanner(System.in);
			System.out.println("请输入URL链接：");
			String url = in.next();
			System.out.println("请输入保存的文件名：");
			String filename = in.next();
			System.out.println("请输入保存的地方：");
			String filelocation = in.next();
			download(url, filename, filelocation);
			in.close();
			String file = filelocation+ "\"" + filename;
			if(file!=null&&!file.equals("")){
				Runtime.getRuntime().exec("cmd /c \""+file);
			}
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	public static void download(String urlString, String fileName,
			String savePath) throws IOException {
		URL url = new URL(urlString);

		URLConnection conn = url.openConnection();
		InputStream is = conn.getInputStream();

		// 使用一条指令代替上面的两条指令
		// InputStream is = url.openStream();
		byte[] buff = new byte[1024];
		int len = 0;
		// 读操作
		File file = new File(savePath);
		if (!file.exists()) {
			file.mkdirs();

		}
		// 写操作
		OutputStream os = new FileOutputStream(file.getAbsolutePath() + "\\"
				+ fileName);
		// 一边读一边写
		while ((len = is.read(buff)) != -1) {
			os.write(buff, 0, len);// 把读到写到指定的数组里面
			
		}
		// 释放资源
		if(os!=null){
			os.close();
		}
		if(is!=null){
			is.close();
		}
		
	}
}
