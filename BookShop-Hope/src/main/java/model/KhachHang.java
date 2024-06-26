package model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "[Khách hàng]")
public class KhachHang implements Serializable {
	@Id
	@Column(name = "[SDT]")
	private String id;
	@Column(name = "[Tổng tiền]")
	private double tongTien;
	@Column(name = "[Thân thiết]")
	private int thanThiet;
	
	public KhachHang() {
	}
	
	public KhachHang(String id, double tongTien, int thanThiet) {
		this.id = id;
		this.tongTien = tongTien;
		this.thanThiet = thanThiet;
	}
	
	public KhachHang(String id) {
		this.id = id;
	}
	
	public KhachHang(String id, double tongTien) {
		this.id = id;
		this.tongTien = tongTien;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getTongTien() {
		return tongTien;
	}
	
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public int getThanThiet() {
		return thanThiet;
	}

	public void setThanThiet(int i) {
		this.thanThiet = i;
	}
	
}
