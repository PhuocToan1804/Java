package model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "[Lich sử đăng nhập]")
public class LichSuDangNhap implements Serializable {
	@Id
	@Column(name = "[Thời gian]")
	private String id;
	@Column(name = "[Mã nhân viên]")
	private String maNV;
	
	public LichSuDangNhap() {
	}
	
	public LichSuDangNhap(String id, String maNV) {
		this.id = id;
		this.maNV = maNV;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	
	
	
	
}
