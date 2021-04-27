package net.codejava;

public class Pres {
	private int doc_id;
	private int pat_id;
	private String date;
	private String mname;
	private int count;
	public Pres(int doc_id, int pat_id, String date, String mname, int count) {
		super();
		this.doc_id = doc_id;
		this.pat_id = pat_id;
		this.date = date;
		this.mname = mname;
		this.count = count;
	}
	public int getDoc_id() {
		return doc_id;
	}
	public void setDoc_id(int doc_id) {
		this.doc_id = doc_id;
	}
	public int getPat_id() {
		return pat_id;
	}
	public void setPat_id(int pat_id) {
		this.pat_id = pat_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
