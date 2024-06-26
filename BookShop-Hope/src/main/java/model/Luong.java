package model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Lương")
public class Luong implements Serializable{
	@Id
	@Column(name = "[Vị trí]")
	private String viTri;
	@Column(name = "[Lương]")
	private double luong;
	
	public Luong() {
	}
	
	public Luong(String viTri, double luong) {
		this.viTri = viTri;
		this.luong = luong;
	}

	public String getViTri() {
		return viTri;
	}

	public void setViTri(String viTri) {
		this.viTri = viTri;
	}

	public double getLuong() {
		return luong;
	}

	public void setLuong(double luong) {
		this.luong = luong;
	}
	
	

}
