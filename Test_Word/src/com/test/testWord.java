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
	      //��range��Χ�ڵ�${reportDate}�滻Ϊ��ǰ������  
	      range.replaceText("${date}", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));  
	      range.replaceText("${name}", "����");  
	      range.replaceText("${sex}", "��");  
	      range.replaceText("${phone}", "13536598965");  
	      OutputStream os = new FileOutputStream("c:\\word\\test2.doc");  
	      //��doc������������  
	      doc.write(os);  
	      this.closeStream(os);  
	      this.closeStream(is);  
	   }  
	    
	   /** 
	    * �ر������� 
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
	    * �ر������ 
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
