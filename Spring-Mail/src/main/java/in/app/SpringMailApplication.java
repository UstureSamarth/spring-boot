package in.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.app.service.IPurchaseOrder;
import in.app.service.PurchaseOrderImpl;

@SpringBootApplication
public class SpringMailApplication {

	public static void main(String[] args) {
		ApplicationContext app = SpringApplication.run(SpringMailApplication.class, args);

		IPurchaseOrder service = app.getBean(PurchaseOrderImpl.class);
		String[] items = new String[] { "Mobile", "Computer", "Laptop" };
		Double[] prices = new Double[] { 11000.0, 33000.0, 40000.0 };
		String[] emails = new String[] { "usturesamrth@gmail.com", "satyakijeet1@gmail.com" };
		String msg = null;

		try {
			msg = service.purchase(items, prices, emails);
			System.out.println(msg);
		} catch (Exception e) {
			e.getMessage();
		}

		/*
		 * EmailDetails emailDetails=new EmailDetails("usturesamarth@gmail.com",
		 * "Hello", "Simple Mail", null); EmailService
		 * service=app.getBean(EmailServiceImpl.class); String
		 * msg=service.sendSimpleMail(emailDetails); System.out.println(msg);
		 */
	}

	/*
	 * @Bean public JavaMailSender getJavaMailSender() { return new
	 * JavaMailSenderImpl(); }
	 */

}
