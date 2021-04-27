package net.codejava;

public class Medicine {
	
	private String Mname;
	private float cost;
	public Medicine(String mname, float cost) {
		super();
		Mname = mname;
		this.cost = cost;
	}
	public String getMname() {
		return Mname;
	}
	public void setMname(String mname) {
		Mname = mname;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	
}
