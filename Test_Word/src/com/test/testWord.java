package com.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.junit.Test;

public class testWord {

	/**
	 * @param args
	 * @throws Exception 
	 */
	@Test
	public void testWrite() throws Exception {  
	      String templatePath = "c:\\word\\test1.doc";  
	      InputStream is = new FileInputStream(templatePath);  
	      HWPFDocument doc = new HWPFDocument(is);  
	      Range range = doc.getRange();  
	      //把range范围内的${reportDate}替换为当前的日期  
	      range.replaceText("${date}", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));  
	      range.replaceText("${name}", "张三");  
	      range.replaceText("${sex}", "男");  
	      range.replaceText("${phone}", "13536598965");  
	      OutputStream os = new FileOutputStream("c:\\word\\test2.doc");  
	      //把doc输出到输出流中  
	      doc.write(os);  
	      this.closeStream(os);  
	      this.closeStream(is);  
	   }  
	    
	   /** 
	    * 关闭输入流 
	    * @param is 
	    */  
	   private void closeStream(InputStream is) {  
	      if (is != null) {  
	         try {  
	            is.close();  
	         } catch (IOException e) {  
	            e.printStackTrace();  
	         }  
	      }  
	   }  
	   
	   /** 
	    * 关闭输出流 
	    * @param os 
	    */  
	   private void closeStream(OutputStream os) {  
	      if (os != null) {  
	         try {  
	            os.close();  
	         } catch (IOException e) {  
	            e.printStackTrace();  
	         }  
	      }  
	   }  
	    
	   
	}  
