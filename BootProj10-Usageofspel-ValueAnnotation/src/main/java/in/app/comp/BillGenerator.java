package in.app.comp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import in.app.dependent.ItemsInfo;

@Component("bill")
public class BillGenerator {

	@Value("#{item.idlePrice+item.dosaPrice+item.vadaPrice}")
	private Float billAmt;

	@Value("ABC")
	private String hotelName;

	@Autowired
	private ItemsInfo info;

	@Override
	public String toString() {
		return "BillGenerator [billAmt=" + billAmt + ", hotelName=" + hotelName + ", info=" + info + "]";
	}

}
