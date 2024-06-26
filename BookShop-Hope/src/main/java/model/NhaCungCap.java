package model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "[Nhà cung cấp]")
public class NhaCungCap implements Serializable {
	@Id
	@Column(name = "[Mã Nhà cung cấp]")
	private String id;
	@Column(name = "[Tên nhà cung cấp]")
	private String tenNhaCungCap;
	
	public NhaCungCap() {
	}
	
	public NhaCungCap(String id, String tenNhaCungCap) {
		this.id = id;
		this.tenNhaCungCap = tenNhaCungCap;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTenNhaCungCap() {
		return tenNhaCungCap;
	}

	public void setTenNhaCungCap(String tenNhaCungCap) {
		this.tenNhaCungCap = tenNhaCungCap;
	}


	
}
