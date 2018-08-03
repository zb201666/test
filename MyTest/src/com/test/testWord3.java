package com.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.xwpf.usermodel.*;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.junit.Test;

public class testWord3 {
	String filePath = "C:\\word\\һ����֪ͨ��.docx";
    InputStream is;
    XWPFDocument doc;
    Map<String, Object> params = new HashMap<String, Object>();

    {
//        params.put("${name}", "xxx");
//        params.put("${sex}", "��");
//        params.put("${pol-status}", "������Ա");
//        params.put("${place}", "sssss");
//        params.put("${classes}", "3102");
//        params.put("${nation}", "��");
//        params.put("${date}", new Date());
//        params.put("${phone}", "312313213");
//        params.put("${education}", "����");
//        params.put("${weight}", "66kg");
//        params.put("${college}", "�廪��ѧ");
//        params.put("${major}", "�����");
//        params.put("${e-mail}", "562398@qq.com");
//        params.put("${skills}", "aaaaaaaaaaaaaaaa");
//        params.put("${classes}", "bbbbbbbbbbbbbbbbbbb");
//        params.put("${computer-level}", "6");
//        params.put("${communication}", "����");
    	params.put("${NAME}", "xxxxx");
    	params.put("${CODE}", "XXXXX");
    	params.put("${ORG}", "AAAAA");
    	params.put("${LEVEL}", "BBBBB");

        try {
            is = new FileInputStream(filePath);
            doc = new XWPFDocument(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * ��һ��docx�ĵ���Ϊģ�壬Ȼ���滻���е����ݣ���д��Ŀ���ĵ��С�
     *
     * @throws Exception
     */
    @Test
    public void testTemplateWrite() throws Exception {
        //�滻��������ı���
        this.replaceInPara(doc, params);
        //�滻�������ı���
        this.replaceInTable(doc, params);
        OutputStream os = new FileOutputStream("C:\\word\\һ����֪ͨ��2.docx");
        doc.write(os);
        this.close(os);
        this.close(is);
    }

//    @Test
//    public void myTest1() throws Exception {
//        Iterator<XWPFParagraph> iterator = doc.getParagraphsIterator();
//        XWPFParagraph para;
//        while (iterator.hasNext()) {
//            para = iterator.next();
//            List<XWPFRun> runs = para.getRuns();
//            para.removeRun(0);
//            para.insertNewRun(0).setText("hello");
//        }
//
//        OutputStream os = new FileOutputStream("C:\\word\\test4.doc");
//        doc.write(os);
//        this.close(os);
//        this.close(is);
//
//        System.out.println(this.matcher("�������ڣ�${reportDate}").find());
//
//    }

//    @Test
//    public void myReplaceInPara() {
//        Iterator<XWPFParagraph> iterator = doc.getParagraphsIterator();
//        XWPFParagraph para;
//        while (iterator.hasNext()) {
//            para = iterator.next();
//            List<XWPFRun> runs = para.getRuns();
//
//
//        }
//
//        System.out.println('{'=='{');
//
//    }

    /**
     * �滻��������ı���
     *
     * @param doc    Ҫ�滻���ĵ�
     * @param params ����
     */
    public void replaceInPara(XWPFDocument doc, Map<String, Object> params) {
        Iterator<XWPFParagraph> iterator = doc.getParagraphsIterator();
        XWPFParagraph para;
        while (iterator.hasNext()) {
            para = iterator.next();
            this.replaceInPara(para, params);
        }
    }

    /**
     * �滻��������ı���
     *
     * @param para   Ҫ�滻�Ķ���
     * @param params ����
     */
    public void replaceInPara(XWPFParagraph para, Map<String, Object> params) {
        List<XWPFRun> runs;
        Matcher matcher;
        if (this.matcher(para.getParagraphText()).find()) {
            runs = para.getRuns();

            int start = -1;
            int end = -1;
            String str = "";
            for (int i = 0; i < runs.size(); i++) {
                XWPFRun run = runs.get(i);
                String runText = run.toString();
                System.out.println("------>>>>>>>>>" + runText);
                if ('$' == runText.charAt(0)&&'{' == runText.charAt(1)) {
                    start = i;
                }
                if ((start != -1)) {
                    str += runText;
                }
                if ('}' == runText.charAt(runText.length() - 1)) {
                    if (start != -1) {
                        end = i;
                        break;
                    }
                }
            }
            System.out.println("start--->"+start);
            System.out.println("end--->"+end);

            System.out.println("str---->>>" + str);

            for (int i = start; i <= end; i++) {
                para.removeRun(i);
                i--;
                end--;
                System.out.println("remove i="+i);
            }

            for (String key : params.keySet()) {
                if (str.equals(key)) {
                    para.createRun().setText((String) params.get(key));
                    break;
                }
            }


        }
    }

    /**
     * �滻�������ı���
     *
     * @param doc    Ҫ�滻���ĵ�
     * @param params ����
     */
    public void replaceInTable(XWPFDocument doc, Map<String, Object> params) {
        Iterator<XWPFTable> iterator = doc.getTablesIterator();
        XWPFTable table;
        List<XWPFTableRow> rows;
        List<XWPFTableCell> cells;
        List<XWPFParagraph> paras;
        while (iterator.hasNext()) {
            table = iterator.next();
            rows = table.getRows();
            for (XWPFTableRow row : rows) {
                cells = row.getTableCells();
                for (XWPFTableCell cell : cells) {
                    paras = cell.getParagraphs();
                    for (XWPFParagraph para : paras) {
                        this.replaceInPara(para, params);
                    }
                }
            }
        }
    }

    /**
     * ����ƥ���ַ���
     *
     * @param str
     * @return
     */
    private Matcher matcher(String str) {
        Pattern pattern = Pattern.compile("\\$\\{(.+?)\\}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        return matcher;
    }

    /**
     * �ر�������
     *
     * @param is
     */
    public void close(InputStream is) {
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
     *
     * @param os
     */
    public void close(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
