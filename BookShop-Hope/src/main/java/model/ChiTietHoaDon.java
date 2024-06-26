package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name = "[Chi tiết hóa đơn]")
public class ChiTietHoaDon implements Serializable {
	@Id
	@Column(name = "[Mã hóa đơn]")
	private int id;
	@Id
	@Column(name = "[Mã sách]")
	private String maSach;
	@Column(name = "[Số lượng]")
	private int soLuong;
	@Column(name = "[Giá]")
	private double gia;
	
	public ChiTietHoaDon() {
	}
	
	public ChiTietHoaDon(int maHoaDon) {
		this.id = maHoaDon;
	}
	
	public ChiTietHoaDon(int maHoaDon, String maSach, int soLuong, double gia) {
		this.id = maHoaDon;
		this.maSach = maSach;
		this.soLuong = soLuong;
		this.gia = gia;
	}

	public int getId() {
		return id;
	}

	public void setMaHoaDon(int maHoaDon) {
		this.id = maHoaDon;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}
	
	
}
