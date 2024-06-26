package model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "[Nhân viên]")
public class NhanVien implements Serializable {
	@Id
	@Column(name = "[Mã nhân viên]")
	private String id;
	@Column(name = "[Tên nhân viên]")
	private String hoTen;
	@Column(name = "[Giới tính]")
	private String gioiTinh;
	@Column(name = "[Vị trí]")
	private String viTri;
	@Column(name = "[SDT]")
	private String sdt;
	
	public NhanVien() {
	}
	
	public NhanVien(String id, String hoTen, String gioiTinh, String viTri, String sdt) {
		this.id = id;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.viTri = viTri;
		this.sdt = sdt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getViTri() {
		return viTri;
	}

	public void setViTri(String viTri) {
		this.viTri = viTri;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	@Override
	public String toString() {
		return "NhanVien [id=" + id + ", hoTen=" + hoTen + ", ngaySinh="  + ", gioiTinh=" + gioiTinh
				+ ", viTri=" + viTri + ", sdt=" + sdt + "]";
	}
	
	
}
