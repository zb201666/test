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
		// TODO 自动生成的方法存根
		sendMail("smtp.qq.com", "1639047465@qq.com",
				"bin2.zhang@changhong.com", "xmcjhfjpsludfddf");// 密码指的是授权码而非邮件密码
	}

	public static void sendMail(String host, String fromAddress,
			String toAddress, String password) {
		Properties props = System.getProperties();
		props.setProperty("mail.smtp.host", host);// 设置邮件服务器
		props.setProperty("mail.transport.protocol", "smtp");// 连接协议
		props.setProperty("mail.smtp.port", "465");// 端口号
		props.setProperty("mail.smtp.auth", "true");// 验证用户
		props.setProperty("mail.smtp.ssl.enable", "true");// 启用SSL安全链接
		props.setProperty("mail.debug", "true");// 显示debug信息
		Session session = Session.getDefaultInstance(props);// 获取Session对象
		MimeMessage msg = new MimeMessage(session);
		Transport trans = null;
		try {
			msg.setFrom(new InternetAddress(fromAddress));// 设置发件人
			msg.setRecipients(Message.RecipientType.TO,
					new InternetAddress[] { new InternetAddress(toAddress) });// 设置收件人
			msg.setSubject("一封测试邮件");// 设置标题
			// msg.setText("邮件内容，测试邮件发送..........");// 设置内容
			// msg.setContent("<h1>邮件内容，测试邮件发送..........</h1>",
			// "text/html;charset=utf-8");
			createMessage(msg);
			trans = session.getTransport();
			trans.connect(fromAddress, password);// 取得连接
			if (trans.isConnected()) {
				trans.sendMessage(msg, msg.getAllRecipients());// 发送消息
				System.out.println("发送成功........");
			} else {
				System.out.println("连接不通，无法发送邮件.........");
			}
		} catch (MessagingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			if (trans != null) {
				try {
					trans.close();
				} catch (MessagingException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}

	}

	public static void createMessage(Message msg) throws MessagingException {// 创建信息内容
		// 创建正文
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent("<h1>邮件内容，测试邮件发送..........</h1>",
				"text/html;charset=utf-8");
		Multipart multi = new MimeMultipart();
		multi.addBodyPart(messageBodyPart);

		// 创建附件
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
