package week2.day2;

public class BiCycle {
	
	public BiCycle() {
		System.out.println("i'm in con");
	}
	
	public BiCycle(String brand) {
		System.out.println("i'm in con");
	}
	
	public void applyBrake() {
		
	}
	
	public String getColor() {
		return "red";
	}
	
	
	public String getColor(int val) {
		return "red";
	}
	
	public String getColor(String whom) {
		if(whom.equalsIgnoreCase("wife"))
			return "red";
		else if(whom.equalsIgnoreCase("daughter"))
			return "orange";
		else 
			return "blue";
	}
	
	public String getColor(String whom, String brand) {
		if(whom.equalsIgnoreCase("wife") && brand.equals("BSA"))
			return "red";
		else 
			return "blue";
	}
	
	
	
	
	
	
	
	public boolean isPuncture() {
		return true;
	}
	
	
	
	
	
	
	
	
	

}
