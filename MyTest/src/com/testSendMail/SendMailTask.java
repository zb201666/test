package com.testSendMail;

import java.io.File;
import java.util.Properties;
import java.util.TimerTask;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMailTask extends TimerTask {

	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		sendMail("smtp.qq.com", "1639047465@qq.com",
				"bin2.zhang@changhong.com", "xmcjhfjpsludfddf");// ����ָ������Ȩ������ʼ�����
	}

	public static void sendMail(String host, String fromAddress,
			String toAddress, String password) {
		Properties props = System.getProperties();
		props.setProperty("mail.smtp.host", host);// �����ʼ�������
		props.setProperty("mail.transport.protocol", "smtp");// ����Э��
		props.setProperty("mail.smtp.port", "465");// �˿ں�
		props.setProperty("mail.smtp.auth", "true");// ��֤�û�
		props.setProperty("mail.smtp.ssl.enable", "true");// ����SSL��ȫ����
		props.setProperty("mail.debug", "true");// ��ʾdebug��Ϣ
		Session session = Session.getDefaultInstance(props);// ��ȡSession����
		MimeMessage msg = new MimeMessage(session);
		Transport trans = null;
		try {
			msg.setFrom(new InternetAddress(fromAddress));// ���÷�����
			msg.setRecipients(Message.RecipientType.TO,
					new InternetAddress[] { new InternetAddress(toAddress) });// �����ռ���
			msg.setSubject("һ������ʼ�");// ���ñ���
			// msg.setText("�ʼ����ݣ������ʼ�����..........");// ��������
			// msg.setContent("<h1>�ʼ����ݣ������ʼ�����..........</h1>",
			// "text/html;charset=utf-8");
			createMessage(msg);
			trans = session.getTransport();
			trans.connect(fromAddress, password);// ȡ������
			if (trans.isConnected()) {
				trans.sendMessage(msg, msg.getAllRecipients());// ������Ϣ
				System.out.println("���ͳɹ�........");
			} else {
				System.out.println("���Ӳ�ͨ���޷������ʼ�.........");
			}
		} catch (MessagingException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} finally {
			if (trans != null) {
				try {
					trans.close();
				} catch (MessagingException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
		}

	}

	public static void createMessage(Message msg) throws MessagingException {// ������Ϣ����
		// ��������
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent("<h1>�ʼ����ݣ������ʼ�����..........</h1>",
				"text/html;charset=utf-8");
		Multipart multi = new MimeMultipart();
		multi.addBodyPart(messageBodyPart);

		// ��������
		String fileName = "test.txt";
		File file = new File("src/com/testSendMail/test.txt");
		DataSource source = new FileDataSource(file);
		MimeBodyPart attachmentBodyPart = new MimeBodyPart();
		attachmentBodyPart.setDataHandler(new DataHandler(source));
		attachmentBodyPart.setFileName(fileName);

		multi.addBodyPart(attachmentBodyPart);
		msg.setContent(multi);
	}
}
