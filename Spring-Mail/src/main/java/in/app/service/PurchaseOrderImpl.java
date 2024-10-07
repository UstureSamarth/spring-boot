package in.app.service;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class PurchaseOrderImpl implements IPurchaseOrder {

	@Autowired
	private JavaMailSender mailSender;

	@Value("${spring.mail.username}")
	private String fromEmail;

	@Override
	public String purchase(String[] items, Double[] prices, String[] toEmails) throws Exception {
		Double amt = 0.0;
		for (Double price : prices)
			amt += price;
		String msg = Arrays.toString(items) + " with price " + Arrays.toString(prices) + " purchase with bill amt "
				+ amt;

//		String status=" ";
		String status = sendMails(msg, toEmails);
		System.out.println(status);
		return msg + " ----> " + status;
	}

	@SuppressWarnings("unused")
	private String sendMails(String msg, String[] toEmails) throws MessagingException {

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setFrom(fromEmail);
		helper.setCc(toEmails);
		helper.setSubject("Open it");
		helper.setSentDate(new Date());
		helper.setText(msg);
		helper.addAttachment("banner.txt", new ClassPathResource("banner.txt"));
		mailSender.send(message);

		return "mail-sent";

	}

}
