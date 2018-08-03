package com.test;

import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class testWord4 {
	public static void searchAndReplace(String srcPath, String destPath,
            Map<String, Object> map) {
        try {
            XWPFDocument document = new XWPFDocument(
                    POIXMLDocument.openPackage(srcPath));
            // �滻�����е�ָ������
            Iterator<XWPFParagraph> itPara = document.getParagraphsIterator();
            while (itPara.hasNext()) {
                XWPFParagraph paragraph = (XWPFParagraph) itPara.next();       
                Set<String> set = map.keySet();
                Iterator<String> iterator = set.iterator();
                while (iterator.hasNext()) {
                    String key = iterator.next();
                    List<XWPFRun> run=paragraph.getRuns();
                     for(int i=0;i<run.size();i++)
                     {
                      if(run.get(i).getText(run.get(i).getTextPosition())!=null && run.get(i).getText(run.get(i).getTextPosition()).equals(key))
                      {    
                        /**����0��ʾ���ɵ�������Ҫ����һ���ط���ʼ����,�������ִ�λ��0��ʼ
                         * �Ϳ��԰�ԭ��������ȫ���滻����
                        * */         
                          run.get(i).setText((String) map.get(key),0);    
                      }    
                     }    
                }    
            }
         // �滻����е�ָ������
            Iterator<XWPFTable> itTable = document.getTablesIterator();
            while (itTable.hasNext()) {
                XWPFTable table = (XWPFTable) itTable.next();
                int rcount = table.getNumberOfRows();
                for (int i = 0; i < rcount; i++) {
                    XWPFTableRow row = table.getRow(i);
                    List<XWPFTableCell> cells = row.getTableCells(); 
                    for (XWPFTableCell cell : cells) {
                        for (Entry<String, Object> e : map.entrySet()) {
                            if (cell.getText().equals(e.getKey())) {
                                cell.removeParagraph(0);
                                cell.setText((String) e.getValue());
                            }
                        }
                    }
                }
            }
            FileOutputStream outStream = null;
            outStream = new FileOutputStream(destPath);
            document.write(outStream);
            outStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	public static void main(String[] args) throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("${name}", "xxx");
        params.put("${sex}", "��");
        params.put("${pol-status}", "������Ա");
        params.put("${place}", "sssss");
        params.put("${classes}", "3102");
        params.put("${nation}", "��");
        params.put("${date}", new Date());
        params.put("${phone}", "312313213");
        params.put("${education}", "����");
        params.put("${weight}", "66kg");
        params.put("${college}", "�廪��ѧ");
        params.put("${major}", "�����");
        params.put("${e-mail}", "562398@qq.com");
        params.put("${skills}", "aaaaaaaaaaaaaaaa");
        params.put("${classes}", "bbbbbbbbbbbbbbbbbbb");
        params.put("${computer-level}", "6");
        params.put("${communication}", "����");
        String srcPath = "C\\word\\test1.doc";
        String destPath = "C\\word\\test5.doc";
        searchAndReplace(srcPath, destPath, params);
    }
}
