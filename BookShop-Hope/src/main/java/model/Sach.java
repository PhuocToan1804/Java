package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Entity
@Table(name = "Sách")
public class Sach implements Serializable  {
	@Id 
	@Column(name = "[Mã sách]")
	private String id;
	@Column(name = "[Tên sách]")
	private String tenSach;
	@Column(name = "[Thể loại]")
	private String theLoai;
	@Column(name = "[Tác giả]")
	private String tacGia;
	@Column(name = "[Nhà xuất bản]")
	private String nhaXuatBan;
	@Column(name = "[Năm xuất bản]")
	private int namXuatBan;
	@Column(name = "[Giá]")
	private double giaBan;
	@Column(name = "[Số lượng]")
	private int soLuong;
	@Column(name = "[Mã nhà cung cấp]")
	private String maNhaCungCap;
	
	public Sach() {
	}
	
	public Sach(String id, String tenSach, String theLoai, String tacGia, String nhaXuatBan, int namXuatBan, double giaBan,
			int soLuong, String maNhaCungCap) {
		this.id = id;
		this.tenSach = tenSach;
		this.theLoai = theLoai;
		this.tacGia = tacGia;
		this.nhaXuatBan = nhaXuatBan;
		this.namXuatBan = namXuatBan;
		this.giaBan = giaBan;
		this.soLuong = soLuong;
		this.maNhaCungCap = maNhaCungCap;
	}
	public Sach(String maSach) {
		this.id = maSach;
	}
	
	@Id
	@Column(name = "[Mã sách]")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name = "[Tên sách]")
	public String getTenSach() {
		return tenSach;
	}
	
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	
	@Column(name = "[Thể loại]")
	public String getTheLoai() {
		return theLoai;
	}
	
	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}
	
	@Column(name = "[Tác giả]")
	public String getTacGia() {
		return tacGia;
	}
	
	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}
	
	@Column(name = "[Nhà xuất bản]")
	public String getNhaXuatBan() {
		return nhaXuatBan;
	}
	
	public void setNhaXuatBan(String nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}
	
	@Column(name = "[Năm xuất bản]")
	
	public int getNamXuatBan() {
		return namXuatBan;
	}
	
	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}
	
	@Column(name = "[Giá]")
	public double getGiaBan() {
		return giaBan;
	}
	
	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}
	
	@Column(name = "[Số lượng]")
	public int getSoLuong() {
		return soLuong;
	}
	
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
	@Column(name = "[Mã nhà cung cấp]")
	public String getMaNhaCungCap() {
		return maNhaCungCap;
	}
	
	public void setMaNhaCungCap(String maNhaCungCap) {
		this.maNhaCungCap = maNhaCungCap;
	}
	
	@Override
	public String toString() {
		return "Sach [id=" + id + ", tenSach=" + tenSach + ", theLoai=" + theLoai + ", tacGia=" + tacGia
				+ ", nhaXuatBan=" + nhaXuatBan + ", namXuatBan=" + namXuatBan + ", giaBan=" + giaBan + ", soLuong="
				+ soLuong + ", maNhaCungCap=" + maNhaCungCap + "]";
	}
}
