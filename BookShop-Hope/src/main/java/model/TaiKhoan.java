package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Entity
@Table(name = "[Tài khoản]")
public class TaiKhoan implements Serializable {
	@Id
	@Column(name = "[Mã nhân viên]")
	private String maNhanVien;
	@Column(name = "[Mật khẩu]")
	private String matKhau;
	@Column(name = "[Quyền]")
	private String loaiTaiKhoan;
	
	public TaiKhoan() {
	}
	
	public TaiKhoan( String maNhanVien, String matKhau, String loaiTaiKhoan) {
		this.maNhanVien = maNhanVien;
		this.matKhau = matKhau;
		this.loaiTaiKhoan = loaiTaiKhoan;
	}

	

	public String getId() {
		return maNhanVien;
	}

	public void setId(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getLoaiTaiKhoan() {
		return loaiTaiKhoan;
	}

	public void setLoaiTaiKhoan(String loaiTaiKhoan) {
		this.loaiTaiKhoan = loaiTaiKhoan;
	}

	@Override
	public String toString() {
		return "TaiKhoan [maNhanVien=" + maNhanVien + ", matKhau=" + matKhau
				+ ", loaiTaiKhoan=" + loaiTaiKhoan + "]";
	}
	
	
	
	
}
