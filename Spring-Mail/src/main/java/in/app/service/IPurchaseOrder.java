package in.app.service;

public interface IPurchaseOrder {
	
	String purchase(String[] items,Double[] prices,String[] toEmails) throws Exception;
}
