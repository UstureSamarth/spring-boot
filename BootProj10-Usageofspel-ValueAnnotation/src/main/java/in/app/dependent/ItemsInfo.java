package in.app.dependent;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("item")
public class ItemsInfo {

	@Value("${items.info.idlePrice}")
	public Float idlePrice;
	@Value("${items.info.dosaPrice}")
	public Float dosaPrice;
	@Value("${items.info.vadaPrice}")
	public Float vadaPrice;

	public void setIdlePrice(Float idlePrice) {
		this.idlePrice = idlePrice;
	}

	public void setDosaPrice(Float dosaPrice) {
		this.dosaPrice = dosaPrice;
	}

	public void setVadaPrice(Float vadaPrice) {
		this.vadaPrice = vadaPrice;
	}

	@Override
	public String toString() {
		return "ItemsInfo [idlePrice=" + idlePrice + ", dosaPrice=" + dosaPrice + ", vadaPrice=" + vadaPrice + "]";
	}

}
