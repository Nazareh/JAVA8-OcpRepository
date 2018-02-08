//Testing Anonymous Inner Class
public class AnonInner {
	interface SaleTodayOnly {
		int dollarsOff();	
	}

	public int admission(int basePrice) {
		SaleTodayOnly sale = new SaleTodayOnly() {
			public int dollarsOff() { return 3; }
		};
		
		return basePrice - sale.dollarsOff();
	} 
	public int admission(int basePrice, SaleTodayOnly sale) {
		return basePrice - sale.dollarsOff();
	}
	
	public int pay() {
		return admission(5, new SaleTodayOnly() {public int dollarsOff() { return 3;}});
	}
	
}