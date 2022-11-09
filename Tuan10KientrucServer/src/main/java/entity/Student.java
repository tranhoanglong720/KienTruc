package entity;

import java.io.Serializable;

public class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7245162182369175215L;
	private String ma;
	private String ten;
	private String diachi;
	private String sdt;
	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	@Override
	public String toString() {
		return "Student [ma=" + ma + ", ten=" + ten + ", diachi=" + diachi + ", sdt=" + sdt + "]";
	}
	public Student(String ma, String ten, String diachi, String sdt) {
		super();
		this.ma = ma;
		this.ten = ten;
		this.diachi = diachi;
		this.sdt = sdt;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
