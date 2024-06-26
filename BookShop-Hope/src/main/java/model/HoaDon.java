package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity
@Table(name = "[Hóa đơn]")
public class HoaDon implements Serializable{
	@Id
	@Generated(value = GenerationTime.INSERT)
	@Column(name = "[Mã hóa đơn]")
	private int id;
	@Column(name = "[Thời gian]")
	private	String thoiGian;
	@Column(name = "[Tổng tiền]")
	private double tongTien;
	@Column(name = "[SDT]")
	private String sdt;
	@Column(name = "[Mã nhân viên]")
	private String maNhanVien;
	
	public HoaDon() {
	}
	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	
	public HoaDon(int id, String thoiGian, double tongTien, String sdt, String maNhanVien) {
		this.id = id;
		this.thoiGian = thoiGian;
		this.tongTien = tongTien;
		this.sdt = sdt;
		this.maNhanVien = maNhanVien;
	}

	public HoaDon(String thoiGian, double tongTien, String sdt, String maNhanVien) {
		this.thoiGian = thoiGian;
		this.tongTien = tongTien;
		this.sdt = sdt;
		this.maNhanVien = maNhanVien;
	}

	public int getId() {
		return id;
	}

	

	public String getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	
	
}
