package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DAO.ChiTietHoaDonDAO;
import DAO.HoaDonDAO;
import DAO.khachHangDAO;
import DAO.sachDAO;
import antlr.debug.NewLineEvent;
import model.ChiTietHoaDon;
import model.HoaDon;
import model.KhachHang;
import model.LichSuDangNhap;
import model.NhaCungCap;
import model.NhanVien;
import model.Sach;
import model.TaiKhoan;
import view.NVForm;
import view.TKForm;
import view.CustomerForm;
import view.KHForm;
import view.NCCForm;
import view.main;
import java.io.*;
import java.net.*;

public class Control1 implements ActionListener {
	private main view;
	private static final String URL = "localhost";
	private static final int PORT = 8080;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private String tenDangNhap;
	private Socket clientSocket;
	private double tongTien;
	private CustomerForm customerForm;
	private boolean isUpdateMode;
	private KHForm khForm;
	private NVForm nvForm;
	private TKForm tkForm;
	private NCCForm nccForm;
	private String search;
	private String combobox;

	public Control1(main view) {
		this.view = view;
		customerForm = new CustomerForm();
		customerForm.getBtnSave().addActionListener(this);
		khForm = new KHForm();
		khForm.getBtnSave().addActionListener(this);
		nvForm = new NVForm();
		nvForm.getBtnSave().addActionListener(this);
		tkForm = new TKForm();
		tkForm.getBtnSave().addActionListener(this);
		nccForm = new NCCForm();
		nccForm.getBtnSave().addActionListener(this);

		try {
			clientSocket = new Socket("localhost", PORT);
			out = new ObjectOutputStream(clientSocket.getOutputStream());
			in = new ObjectInputStream(clientSocket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == view.getDangNhapButton()) {
			tenDangNhap = Control1.this.view.getMaNV();
			String matKhau = encodeString(Control1.this.view.getMatKhau());
			String loaiTaiKhoan = Control1.this.view.getCombobox();
			TaiKhoan taiKhoan = new TaiKhoan(tenDangNhap, matKhau, loaiTaiKhoan);
			try {
				out.writeObject("SIGN_IN");
				out.writeObject(taiKhoan);
				out.flush();
				String response = (String) in.readObject();
				if (response.equals("TaiKhoan_Exists")) {
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
					LocalDateTime now = LocalDateTime.now();
					String time = dtf.format(now);
					LichSuDangNhap lichSuDangNhap = new LichSuDangNhap(time, tenDangNhap);
					insertLSDN(lichSuDangNhap);
					if (view.getCombobox() == "Nhân viên") {
						combobox = "Nhân viên";
						view.init();
						view.BookSell();
						loadSach();
						view.getTKMenu().setVisible(false);
						view.getNVMenu().setVisible(false);
						view.getDoanhThuMenu().setVisible(false);
						view.getLSDNMenu().setVisible(false);
						view.getNCCMenu().setVisible(false);

					} else {
						combobox = "Chủ";
						view.init();
						view.thongKeSach();
						loadSach1();
						view.getthanhToanMenu().setVisible(false);
					}

				} else if (response.equals("TaiKhoan_NotExists")) {
					JOptionPane.showMessageDialog(null, "Kiểm tra lại tên đăng nhập, mật khẩu và quyền");
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		if (source == view.getDangXuatButton()) {
			view.login();
		}
		if (source == view.getThemButton()) {

			int selectedRow = view.getsachTable().getSelectedRow();
			if (selectedRow >= 0) {
				String tenSach = view.getTableModel().getValueAt(selectedRow, 1).toString();
				float gia = Float.parseFloat(view.getTableModel().getValueAt(selectedRow, 4).toString());
				int soLuong = (int) view.getSpinner().getValue();
				float tong = soLuong * (float) gia;
				if (soLuong == 0) {
					JOptionPane.showMessageDialog(null, "Số lượng không thể bằng 0");
					return;
				}
				for (int i = 0; i < view.getTableModel1().getRowCount(); i++) {
					if (view.getTableModel1().getValueAt(i, 0).equals(tenSach)) {
						int soLuongCu = (int) view.getTableModel1().getValueAt(i, 1);
						soLuong += soLuongCu;
						tong = soLuong * (float) gia;
						view.getTableModel1().removeRow(i);
					}
				}
				view.getTableModel1().addRow(new Object[] { tenSach, soLuong, gia, tong });
				for (int i = 0; i < view.getTableModel1().getRowCount(); i++) {
					tongTien += (float) view.getTableModel1().getValueAt(i, 3);
				}

				view.getTongTienALl().setText(String.valueOf(tongTien));
				tongTien = 0;
			} else {
				JOptionPane.showMessageDialog(view, "Vui lòng chọn một hàng trong bảng.");
			}

		}

		if (source == view.getXoaHDButton()) {
			int selectedRow = view.getHoaDonTable1().getSelectedRow();
			if (selectedRow >= 0) {
				view.getTableModel1().removeRow(selectedRow);
				;
				view.getTableModel1().fireTableDataChanged();
			} else {
				view.getTableModel1().setRowCount(0);
				view.getTableModel1().fireTableDataChanged();
			}
		}
		if (source == view.getDTAllNam()) {
			view.doanhThu();
			search = "DT";
			loadDoanhThuNam();
			if (combobox == "Nhân viên") {
				view.getTKMenu().setVisible(false);
				view.getNVMenu().setVisible(false);
				view.getDoanhThuMenu().setVisible(false);
				view.getLSDNMenu().setVisible(false);
				view.getNCCMenu().setVisible(false);
			} else {
				view.getthanhToanMenu().setVisible(false);
			}
			view.getDTTable().getColumnModel().getColumn(0).setHeaderValue("Năm");
		}
		if (source == view.getDTAllThang()) {
			view.doanhThu();
			loadDoanhThuTHang();
			if (combobox == "Nhân viên") {
				view.getTKMenu().setVisible(false);
				view.getNVMenu().setVisible(false);
				view.getDoanhThuMenu().setVisible(false);
				view.getLSDNMenu().setVisible(false);
				view.getNCCMenu().setVisible(false);
			} else {
				view.getthanhToanMenu().setVisible(false);
			}
			view.getDTTable().getColumnModel().getColumn(0).setHeaderValue("Tháng");
		}

		if (source == view.getAllKhachHang()) {
			view.khachhang();
			if (combobox == "Nhân viên") {
				view.getTKMenu().setVisible(false);
				view.getNVMenu().setVisible(false);
				view.getDoanhThuMenu().setVisible(false);
				view.getLSDNMenu().setVisible(false);
				view.getNCCMenu().setVisible(false);
			} else {
				view.getthanhToanMenu().setVisible(false);
			}
		}

		if (source == view.getTrangChuMenuItem()) {
			view.init();
			view.BookSell();
			search = "TKS1";
			if (combobox == "Nhân viên") {
				view.getTKMenu().setVisible(false);
				view.getNVMenu().setVisible(false);
				view.getDoanhThuMenu().setVisible(false);
				view.getLSDNMenu().setVisible(false);
				view.getNCCMenu().setVisible(false);
			} else {
				view.getthanhToanMenu().setVisible(false);
			}
		}

		if (source == view.getThongKeSachItem()) {
			view.init();
			view.thongKeSach();
			search = "TKS";
			if (combobox == "Nhân viên") {
				view.getTKMenu().setVisible(false);
				view.getNVMenu().setVisible(false);
				view.getDoanhThuMenu().setVisible(false);
				view.getLSDNMenu().setVisible(false);
				view.getNCCMenu().setVisible(false);
			} else {
				view.getthanhToanMenu().setVisible(false);
			}
		}

		if (source == view.getSuaKHButtonSach()) {
			isUpdateMode = true;
			int selectedRow = view.getSachTable().getSelectedRow();
			if (selectedRow >= 0) {
				String bookID = view.getSachTable().getValueAt(selectedRow, 0).toString();
				String bookName = view.getSachTable().getValueAt(selectedRow, 1).toString();
				String bookTheLoai = view.getSachTable().getValueAt(selectedRow, 2).toString();
				String bookNXB = view.getSachTable().getValueAt(selectedRow, 3).toString();
				String bookNamXB = view.getSachTable().getValueAt(selectedRow, 4).toString();
				String bookNCC = view.getSachTable().getValueAt(selectedRow, 5).toString();
				String bookTG = view.getSachTable().getValueAt(selectedRow, 6).toString();
				String bookSL = view.getSachTable().getValueAt(selectedRow, 7).toString();
				String bookG = view.getSachTable().getValueAt(selectedRow, 8).toString();

				customerForm.getBookID().setText(bookID);
				customerForm.getBookName().setText(bookName);
				customerForm.getBookTheLoai().setText(bookTheLoai);
				customerForm.getBookNXB().setText(bookNXB);
				customerForm.getBookNamXB().setText(bookNamXB);
				customerForm.getBookNCC().setText(bookNCC);
				customerForm.getBookTG().setText(bookTG);
				customerForm.getBookSL().setText(bookSL);
				customerForm.getBookG().setText(bookG);
				customerForm.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(view, "Vui lòng chọn một hàng trong bảng.");
			}

		}

		if (source == view.getTKAll()) {
			view.TaiKhoan();
			loadTaiKhoan();
			search = "TK";
			if (combobox == "Nhân viên") {
				view.getTKMenu().setVisible(false);
				view.getNVMenu().setVisible(false);
				view.getDoanhThuMenu().setVisible(false);
				view.getLSDNMenu().setVisible(false);
				view.getNCCMenu().setVisible(false);
			} else {
				view.getthanhToanMenu().setVisible(false);
			}
		}

		if (source == view.getThemButtonTK()) {
			isUpdateMode = false;
			tkForm.setVisible(true);
		}

		if (source == view.getThemButtonNCC()) {
			isUpdateMode = false;
			nccForm.setVisible(true);
		}

		if (source == view.getSuaButtonNCC()) {
			isUpdateMode = true;
			int selectedRow = view.getNCCTable().getSelectedRow();
			if (selectedRow >= 0) {
				String id = view.getNCCTable().getValueAt(selectedRow, 0).toString();
				String tenNCC = view.getNCCTable().getValueAt(selectedRow, 1).toString();
				nccForm.getBookID().setText(id);
				nccForm.getBookName().setText(tenNCC);
			} else {
				JOptionPane.showMessageDialog(view, "Vui lòng chọn một hàng trong bảng.");
			}
		}

		if (source == view.getSuaButtonTK()) {
			isUpdateMode = true;
			int selectedRow = view.getTKTable().getSelectedRow();
			if (selectedRow >= 0) {
				String id = view.getTKTable().getValueAt(selectedRow, 0).toString();
				String matKhau = decodeString(view.getTKTable().getValueAt(selectedRow, 1).toString());
				String loaiTaiKhoan = view.getTKTable().getValueAt(selectedRow, 2).toString();

				tkForm.getBookID().setText(id);
				tkForm.getBookName().setText(matKhau);
				tkForm.getBookTheLoai().setText(loaiTaiKhoan);
				tkForm.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(view, "Vui lòng chọn một hàng trong bảng.");
			}
		}
		if (source == nccForm.getBtnSave()) {
			nccForm.setVisible(false);
			String id = nccForm.getBookID().getText();
			String tenNCC = nccForm.getBookName().getText();
			NhaCungCap ncc = new NhaCungCap(id, tenNCC);
			if (!isUpdateMode) {
				try {
					out.writeObject("INSERT_NCC");
					out.writeObject(ncc);
					out.flush();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				loadNCC();
			} else {
				try {
					out.writeObject("UPDATE_NCC");
					out.writeObject(ncc);
					out.flush();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				loadNCC();
			}
		}

		if (source == tkForm.getBtnSave()) {
			tkForm.setVisible(false);
			String id = tkForm.getBookID().getText();
			String matKhau = encodeString(tkForm.getBookName().getText());
			String loaiTaiKhoan = tkForm.getBookTheLoai().getText();
			TaiKhoan tk = new TaiKhoan(id, matKhau, loaiTaiKhoan);
			if (!isUpdateMode) {
				try {
					out.writeObject("INSERT_ACCOUNT");
					out.writeObject(tk);
					out.flush();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				loadTaiKhoan();
			} else {
				try {
					out.writeObject("UPDATE_ACCOUNT");
					out.writeObject(tk);
					out.flush();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				loadTaiKhoan();
			}
		}

		if (source == view.getXoaButtonNCC()) {
			int selectedRow = view.getNCCTable().getSelectedRow();
			if (selectedRow >= 0) {
				String id = view.getNCCTable().getValueAt(selectedRow, 0).toString();
				String tenNCC = view.getNCCTable().getValueAt(selectedRow, 1).toString();
				NhaCungCap ncc = new NhaCungCap(id, tenNCC);
				try {
					out.writeObject("DELETE_NCC");
					out.writeObject(ncc);
					out.flush();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				loadNCC();
			} else {
				JOptionPane.showMessageDialog(view, "Vui lòng chọn một hàng trong bảng.");
			}
		}
		if (source == view.getXoaButtonTK()) {
			int selectedRow = view.getTKTable().getSelectedRow();
			if (selectedRow >= 0) {
				String id = view.getTKTable().getValueAt(selectedRow, 0).toString();
				String matKhau = encodeString(view.getTKTable().getValueAt(selectedRow, 1).toString());
				String loaiTaiKhoan = view.getTKTable().getValueAt(selectedRow, 2).toString();
				TaiKhoan tk = new TaiKhoan(id, matKhau, loaiTaiKhoan);
				try {
					out.writeObject("DELETE_ACCOUNT");
					out.writeObject(tk);
					out.flush();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				loadTaiKhoan();
			} else {
				JOptionPane.showMessageDialog(view, "Vui lòng chọn một hàng trong bảng.");
			}
		}
		if (source == view.getDTAll()) {
			view.doanhThu();
			loadDoanhThu();
			search = "DT";
			if (combobox == "Nhân viên") {
				view.getTKMenu().setVisible(false);
				view.getNVMenu().setVisible(false);
				view.getDoanhThuMenu().setVisible(false);
				view.getLSDNMenu().setVisible(false);
				view.getNCCMenu().setVisible(false);
			} else {
				view.getthanhToanMenu().setVisible(false);
			}

		}
		if (source == view.getThemKHButtonSach()) {
			isUpdateMode = false;
			customerForm.setVisible(true);
		}

		if (source == view.getThemButtonNV()) {
			isUpdateMode = false;
			nvForm.setVisible(true);
		}

		if (source == view.getThemKHButton()) {
			isUpdateMode = false;
			khForm.setVisible(true);
		}

		if (source == view.getNCCAll()) {
			view.nhaCungCap();
			loadNCC();
			if (combobox == "Nhân viên") {
				view.getTKMenu().setVisible(false);
				view.getNVMenu().setVisible(false);
				view.getDoanhThuMenu().setVisible(false);
				view.getLSDNMenu().setVisible(false);
				view.getNCCMenu().setVisible(false);
			} else {
				view.getthanhToanMenu().setVisible(false);
			}

		}

		if (source == view.getSuaButtonNV()) {
			isUpdateMode = true;
			int selectedRow = view.getTableNV().getSelectedRow();
			if (selectedRow >= 0) {
				String id = view.getTableNV().getValueAt(selectedRow, 0).toString();
				String hoTen = view.getTableNV().getValueAt(selectedRow, 1).toString();
				String gioiTinh = view.getTableNV().getValueAt(selectedRow, 2).toString();
				String sdt = view.getTableNV().getValueAt(selectedRow, 3).toString();
				String viTri = view.getTableNV().getValueAt(selectedRow, 4).toString();

				nvForm.getBookID().setText(id);
				nvForm.getBookName().setText(hoTen);
				nvForm.getBookTheLoai().setText(gioiTinh);
				nvForm.getBookTG().setText(sdt);
				nvForm.getBookNamXB().setText(viTri);
				nvForm.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(view, "Vui lòng chọn một hàng trong bảng.");
			}
		}

		if (source == nvForm.getBtnSave()) {
			nvForm.setVisible(false);
			String id = nvForm.getBookID().getText();
			String hoTen = nvForm.getBookName().getText();
			String gioiTinh = nvForm.getBookTheLoai().getText();
			String sdt = nvForm.getBookTG().getText();
			String viTri = nvForm.getBookNamXB().getText();
			NhanVien nv = new NhanVien(id, hoTen, gioiTinh, viTri, sdt);
			if (!isUpdateMode) {
				try {
					out.writeObject("INSERT_NV");
					out.writeObject(nv);
					out.flush();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				loadNV();
			} else {
				try {
					out.writeObject("UPDATE_NV");
					out.writeObject(nv);
					out.flush();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				loadNV();
			}
		}

		if (source == view.getSuaKHButton()) {
			isUpdateMode = true;
			int selectedRow = view.getTableKH().getSelectedRow();
			if (selectedRow >= 0) {
				String sdt = view.getTableKH().getValueAt(selectedRow, 0).toString();
				String tongTien = view.getTableKH().getValueAt(selectedRow, 1).toString();
				String thanThiet = view.getTableKH().getValueAt(selectedRow, 2).toString();
				khForm.getBookID().setText(sdt);
				khForm.getBookName().setText(tongTien);
				khForm.getBookTheLoai().setText(thanThiet);
				khForm.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(view, "Vui lòng chọn một hàng trong bảng.");
			}
		}

		if (source == view.getXoaKHButton()) {
			int selectedRow = view.getTableKH().getSelectedRow();
			if (selectedRow >= 0) {
				String sdt = view.getTableKH().getValueAt(selectedRow, 0).toString();
				String tongTien = view.getTableKH().getValueAt(selectedRow, 1).toString();
				String thanThiet = view.getTableKH().getValueAt(selectedRow, 2).toString();
				KhachHang kh = new KhachHang(sdt, Float.parseFloat(tongTien), Integer.parseInt(thanThiet));
				try {
					out.writeObject("DELETE_CUSTOMER");
					out.writeObject(kh);
					out.flush();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				loadKH();
			} else {
				JOptionPane.showMessageDialog(view, "Vui lòng chọn một hàng trong bảng.");
			}
		}

		if (source == view.getXoaButtonNV()) {
			int selectedRow = view.getTableNV().getSelectedRow();
			if (selectedRow >= 0) {
				String id = view.getTableNV().getValueAt(selectedRow, 0).toString();
				String hoTen = view.getTableNV().getValueAt(selectedRow, 1).toString();
				String gioiTinh = view.getTableNV().getValueAt(selectedRow, 2).toString();
				String sdt = view.getTableNV().getValueAt(selectedRow, 3).toString();
				String viTri = view.getTableNV().getValueAt(selectedRow, 4).toString();
				NhanVien nv = new NhanVien(id, hoTen, gioiTinh, viTri, sdt);
				try {
					out.writeObject("DELETE_NV");
					out.writeObject(nv);
					out.flush();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				loadNV();
			} else {
				JOptionPane.showMessageDialog(view, "Vui lòng chọn một hàng trong bảng.");
			}
		}

		if (source == khForm.getBtnSave()) {
			khForm.setVisible(false);
			String sdt = khForm.getBookID().getText();
			float tongTien = Float.parseFloat(khForm.getBookName().getText());
			int thanThiet = Integer.parseInt(khForm.getBookTheLoai().getText());
			KhachHang kh = new KhachHang(sdt, tongTien, thanThiet);
			if (!isUpdateMode) {
				try {
					out.writeObject("INSERT_CUSTOMER");
					out.writeObject(kh);
					out.flush();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				loadKH();
			} else {
				try {
					out.writeObject("UPDATE_CUSTOMER");
					out.writeObject(kh);
					out.flush();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				loadKH();
			}
		}

		if (source == customerForm.getBtnSave()) {
			customerForm.setVisible(false);
			String bookID = customerForm.getBookID().getText();
			String bookName = customerForm.getBookName().getText();
			String bookTheLoai = customerForm.getBookTheLoai().getText();
			String bookNXB = customerForm.getBookNXB().getText();
			int bookNamXB = Integer.parseInt(customerForm.getBookNamXB().getText());
			String bookNCC = customerForm.getBookNCC().getText();
			String bookTG = customerForm.getBookTG().getText();
			int bookSL = Integer.parseInt(customerForm.getBookSL().getText());
			float bookG = Float.parseFloat(customerForm.getBookG().getText());
			Sach sach = new Sach(bookID, bookName, bookTheLoai, bookTG, bookNXB, bookNamXB, bookG, bookSL, bookNCC);
			if (!isUpdateMode) {
				try {
					out.writeObject("ADD_BOOK");
					out.writeObject(sach);
					out.flush();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				loadSach1();
			} else {
				try {
					out.writeObject("UPDATE_BOOK");
					out.writeObject(sach);
					out.flush();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				loadSach1();
			}

		}

		if (source == view.getXoaKHButtonSach()) {
			int selectedRow = view.getSachTable().getSelectedRow();
			if (selectedRow >= 0) {
				String bookID = view.getSachTable().getValueAt(selectedRow, 0).toString();
				String bookName = view.getSachTable().getValueAt(selectedRow, 1).toString();
				String bookTheLoai = view.getSachTable().getValueAt(selectedRow, 2).toString();
				String bookNXB = view.getSachTable().getValueAt(selectedRow, 3).toString();
				String bookNamXB = view.getSachTable().getValueAt(selectedRow, 4).toString();
				String bookNCC = view.getSachTable().getValueAt(selectedRow, 5).toString();
				String bookTG = view.getSachTable().getValueAt(selectedRow, 6).toString();
				String bookSL = view.getSachTable().getValueAt(selectedRow, 7).toString();
				String bookG = view.getSachTable().getValueAt(selectedRow, 8).toString();

				Sach sach = new Sach(bookID, bookName, bookTheLoai, bookTG, bookNXB, Integer.parseInt(bookNamXB),
						Float.parseFloat(bookG), Integer.parseInt(bookSL), bookNCC);

				try {
					out.writeObject("DELETE_BOOK");
					out.writeObject(sach);
					out.flush();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				loadSach1();
			} else {
				JOptionPane.showMessageDialog(view, "Vui lòng chọn một hàng trong bảng.");
			}
		}

		if (source == view.getdongYButton()) {
			if (view.getSdtKH().getText() != null) {
				khachHangDAO khachHangDAO = new khachHangDAO();
				double tien = Double.parseDouble(view.getTongTienALl().getText());
				KhachHang khachHang = new KhachHang(view.getSdtKH().getText(), tien, 0);
				if (khachHangDAO.selectById(khachHang) != null) {
					khachHang.setTongTien(khachHangDAO.selectById(khachHang).getTongTien() + tien);
					if (khachHang.getTongTien() >= 1000000) {
						khachHang.setThanThiet(1);
					}
					try {
						out.writeObject("UPDATE_CUSTOMER");
						out.writeObject(khachHang);
						out.flush();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				} else {
					try {
						if (Float.parseFloat(view.getTongTienALl().getText()) > 1000000) {
							khachHang.setThanThiet(1);
						}
						out.writeObject("INSERT_CUSTOMER");
						out.writeObject(khachHang);
						out.flush();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
			HoaDonDAO hoaDonDAO = new HoaDonDAO();

			String time = LocalDateTime.now().toString();
			if (view.getHoaDonTable().getRowCount() >= 0) {
				String sdt = view.getSdtKH().getText();
				int ma = 0;
				if (hoaDonDAO.selectIdMax() != null) {
					ma = hoaDonDAO.selectIdMax().getId() + 1;
				}
				double tongAll = Float.parseFloat(view.getTongTienALl().getText());
				HoaDon hoaDon = new HoaDon(ma, time, tongAll, sdt, tenDangNhap);
				try {
					out.writeObject("ADD_BILL");
					out.writeObject(hoaDon);
					out.flush();
				} catch (Exception e2) {
					e2.printStackTrace();
				}

				int maHoaDon = ma;
				for (int i = 0; i < view.getHoaDonTable().getRowCount(); i++) {
					String tenSach = view.getHoaDonTable().getValueAt(i, 0).toString();
					int soLuong = (int) view.getHoaDonTable().getValueAt(i, 1);
					float tong = Float.parseFloat(view.getHoaDonTable().getValueAt(i, 3).toString());

					for (int j = 0; j < view.getsachTable().getRowCount(); j++) {
						if (view.getsachTable().getValueAt(j, 1).equals(tenSach)) {
							String maSach = view.getsachTable().getValueAt(j, 0).toString();
							ChiTietHoaDon cthd = new ChiTietHoaDon(maHoaDon, maSach, soLuong, tong);
							sachDAO sachDAO = new sachDAO();
							Sach sach = sachDAO.selectById(new Sach(maSach));
							sach.setSoLuong(sach.getSoLuong() - soLuong);
							try {
								out.writeObject("ADD_DETAIL_BILL");
								out.writeObject(cthd);
								out.flush();

								out.writeObject("UPDATE_BOOK");
								out.writeObject(sach);
								out.flush();
							} catch (Exception e2) {
								e2.printStackTrace();
							}
						}
					}

				}
			}
			view.getTableModel1().setRowCount(0);
			view.getSdtKH().setText("");
			loadSach();
			JOptionPane.showMessageDialog(view, "Thanh toán thành công");
		}
		if (source == view.getAllNV()) {
			view.nhanVien();
			loadNV();
			search = "NV";
			if (combobox == "Nhân viên") {
				view.getTKMenu().setVisible(false);
				view.getNVMenu().setVisible(false);
				view.getDoanhThuMenu().setVisible(false);
				view.getLSDNMenu().setVisible(false);
				view.getNCCMenu().setVisible(false);
			} else {
				view.getthanhToanMenu().setVisible(false);
			}
		}

		if (source == view.getLichSu()) {
			view.lichSuMuaHang();
			loadHoaDon();
			search = "LS";
			if (combobox == "Nhân viên") {
				view.getTKMenu().setVisible(false);
				view.getNVMenu().setVisible(false);
				view.getDoanhThuMenu().setVisible(false);
				view.getLSDNMenu().setVisible(false);
				view.getNCCMenu().setVisible(false);
			} else {
				view.getthanhToanMenu().setVisible(false);
			}
		}

		if (source == view.getchiTiet()) {
			int selectedRow = view.getLSTable().getSelectedRow();
			if (selectedRow >= 0) {

				int maHoaDon = (int) view.getTableModelLS().getValueAt(selectedRow, 0);
				ChiTietHoaDon hd = new ChiTietHoaDon(maHoaDon);
				view.chiTietDonHang();
				try {
					out.writeObject("GET_DETAIL_BILL");
					out.writeObject(hd);
					out.flush();
					List<ChiTietHoaDon> listCTHD = (List<ChiTietHoaDon>) in.readObject();
					DefaultTableModel tableModel = view.getTableModelCT();
					tableModel.setRowCount(0);
					for (ChiTietHoaDon s : listCTHD) {
						tableModel.addRow(new Object[] { s.getId(), s.getMaSach(), s.getSoLuong(), s.getGia() });
					}
					search = "CTHD";
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}

		if (source == view.getQuayLai()) {
			view.lichSuMuaHang();
			loadHoaDon();
			search = "LS";
			if (combobox == "Nhân viên") {
				view.getTKMenu().setVisible(false);
				view.getNVMenu().setVisible(false);
				view.getDoanhThuMenu().setVisible(false);
				view.getLSDNMenu().setVisible(false);
				view.getNCCMenu().setVisible(false);
			} else {
				view.getthanhToanMenu().setVisible(false);
			}
		}

		if (source == view.getSearchButton()) {
			String giaTri = view.getSearchField().getText();
			System.out.println(search);
			if (search == "TKS1") {
				findSach(giaTri);
			}
			if (search == "TKS") {
				findTKSach(giaTri);
			}
			if (search == "KH") {
				findKH(giaTri);
			}
			if (search == "LS") {
				findLS(giaTri);
			}
			if (search == "CTHD") {
				findCTLS(giaTri);
			}
			if (search == "NV") {
				findNV(giaTri);
			}
		}

		if (source == view.getLSDN()) {
			view.lichSuDangNhap();
			loadLSDN();
			if (combobox == "Nhân viên") {
				view.getTKMenu().setVisible(false);
				view.getNVMenu().setVisible(false);
				view.getDoanhThuMenu().setVisible(false);
				view.getLSDNMenu().setVisible(false);
				view.getNCCMenu().setVisible(false);
			} else {
				view.getthanhToanMenu().setVisible(false);
			}
		}
	}

	public void loadSach() {
		try {
			out.writeObject("GET_ALL_BOOKS");
			out.flush();
			List<Sach> listSach = (List<Sach>) in.readObject();
			DefaultTableModel tableModel = view.getTableModel();
			tableModel.setRowCount(0);
			for (Sach s : listSach) {
				tableModel.addRow(new Object[] { s.getId(), s.getTenSach(), s.getTheLoai(), s.getTacGia(),
						s.getGiaBan(), s.getSoLuong() });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		search = "TKS1";
	}

	public void loadSach1() {
		try {
			out.writeObject("GET_ALL_BOOKS");
			out.flush();
			List<Sach> listSach = (List<Sach>) in.readObject();
			DefaultTableModel tableModel = view.getTableModelSach();
			tableModel.setRowCount(0);
			for (Sach s : listSach) {
				tableModel.addRow(new Object[] { s.getId(), s.getTenSach(), s.getTheLoai(), s.getNhaXuatBan(),
						s.getNamXuatBan(), s.getMaNhaCungCap(), s.getTacGia(), s.getSoLuong(), s.getGiaBan() });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		search = "TKS";
	}

	public void loadKH() {
		try {
			out.writeObject("GET_KH_BOOKS");
			out.flush();
			List<KhachHang> listKH = (List<KhachHang>) in.readObject();
			DefaultTableModel tableModel = view.getTableModelKH();
			tableModel.setRowCount(0);
			for (KhachHang s : listKH) {
				tableModel.addRow(new Object[] { s.getId(), s.getTongTien(), s.getThanThiet() });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		search = "KH";
	}

	public void loadNV() {
		try {
			out.writeObject("GET_NV");
			out.flush();
			List<NhanVien> listNV = (List<NhanVien>) in.readObject();
			DefaultTableModel tableModel = view.getTableModelNV();
			tableModel.setRowCount(0);
			for (NhanVien s : listNV) {
				tableModel.addRow(new Object[] { s.getId(), s.getHoTen(), s.getGioiTinh(), s.getSdt(), s.getViTri() });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		search = "NV";
	}

	public void loadHoaDon() {
		try {
			out.writeObject("GET_HD");
			out.flush();
			List<HoaDon> listHD = (List<HoaDon>) in.readObject();
			DefaultTableModel tableModel = view.getTableModelLS();
			tableModel.setRowCount(0);
			for (HoaDon s : listHD) {
				tableModel.addRow(
						new Object[] { s.getId(), s.getSdt(), s.getThoiGian(), s.getTongTien(), s.getMaNhanVien() });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		search = "LS";
	}

	public void loadChiTiet() {
		try {
			out.writeObject("GET_HDCT");
			out.flush();
			List<ChiTietHoaDon> listCTHD = (List<ChiTietHoaDon>) in.readObject();
			DefaultTableModel tableModel = view.getTableModelLS();
			tableModel.setRowCount(0);
			for (ChiTietHoaDon s : listCTHD) {
				tableModel.addRow(new Object[] { s.getId(), s.getMaSach(), s.getSoLuong(), s.getGia() });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		search = "CTHD";
	}

	public void loadTaiKhoan() {
		try {
			out.writeObject("GET_ALL_ACCOUNT");
			out.flush();
			List<TaiKhoan> listTK = (List<TaiKhoan>) in.readObject();
			DefaultTableModel tableModel = view.getTableModelTK();
			tableModel.setRowCount(0);
			for (TaiKhoan s : listTK) {
				tableModel.addRow(new Object[] { s.getId(), s.getMatKhau(), s.getLoaiTaiKhoan() });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		search = "TK";
	}

	public void saveInvoiceToFile() {
		try {
			FileWriter writer = new FileWriter("thanhToan.txt");
			BufferedWriter buffer = new BufferedWriter(writer);

			// Write phone number
			buffer.write("SDT: " + view.getSdtKH().getText());
			buffer.newLine();

			// Write table headers
			for (int i = 0; i < view.getTableModel1().getColumnCount(); i++) {
				buffer.write(view.getTableModel1().getColumnName(i) + "\t");
			}
			buffer.newLine();

			// Write table data
			for (int i = 0; i < view.getsachTable().getRowCount(); i++) {
				for (int j = 0; j < view.getTableModel1().getColumnCount(); j++) {
					buffer.write(view.getTableModel1().getValueAt(i, j).toString() + "\t");
				}
				buffer.newLine();
			}

			// Write total amount
			buffer.write("Tổng: " + view.getTongTienALl().getText());
			buffer.newLine();

			buffer.close();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadDoanhThu() {
		try {
			out.writeObject("DOANH_THU");
			out.flush();
			List<Object[]> listDT = (List<Object[]>) in.readObject();
			DefaultTableModel tableModel = view.getTableModelDT();
			tableModel.setRowCount(0);
			for (Object[] s : listDT) {
				tableModel.addRow(new Object[] { s[0], s[1] });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		search = "DT";
	}

	public void loadDoanhThuTHang() {
		try {
			out.writeObject("DOANH_THU_THANG");
			out.flush();
			List<Object[]> listDT = (List<Object[]>) in.readObject();
			DefaultTableModel tableModel = view.getTableModelDT();
			tableModel.setRowCount(0);
			for (Object[] s : listDT) {
				tableModel.addRow(new Object[] { s[0] + "-" + s[1], s[2] });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		search = "DT";
	}

	public void loadDoanhThuNam() {
		try {
			out.writeObject("DOANH_THU_NAM");
			out.flush();
			List<Object[]> listDT = (List<Object[]>) in.readObject();
			DefaultTableModel tableModel = view.getTableModelDT();
			tableModel.setRowCount(0);
			for (Object[] s : listDT) {
				tableModel.addRow(new Object[] { s[0], s[1] });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		search = "DT";
	}

	public void findSach(String giaTri) {
		try {
			out.writeObject("FIND_BOOK_HD");
			out.writeObject(giaTri);
			out.flush();
			List<Sach> listSach = (List<Sach>) in.readObject();
			DefaultTableModel tableModel = view.getTableModel();
			tableModel.setRowCount(0);
			for (Sach s : listSach) {
				tableModel.addRow(new Object[] { s.getId(), s.getTenSach(), s.getTheLoai(), s.getTacGia(),
						s.getGiaBan(), s.getSoLuong() });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void findTKSach(String giaTri) {
		try {
			out.writeObject("FIND_BOOK");
			out.writeObject(giaTri);
			out.flush();
			List<Sach> listSach = (List<Sach>) in.readObject();
			DefaultTableModel tableModel = view.getTableModelSach();
			tableModel.setRowCount(0);
			for (Sach s : listSach) {
				tableModel.addRow(new Object[] { s.getId(), s.getTenSach(), s.getTheLoai(), s.getNhaXuatBan(),
						s.getNamXuatBan(), s.getMaNhaCungCap(), s.getTacGia(), s.getSoLuong(), s.getGiaBan() });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void findKH(String giaTri) {
		try {
			out.writeObject("FIND_KH");
			out.writeObject(new KhachHang(giaTri));
			out.flush();
			KhachHang listKH = (KhachHang) in.readObject();
			DefaultTableModel tableModel = view.getTableModelKH();
			tableModel.setRowCount(0);
			tableModel.addRow(new Object[] { listKH.getId(), listKH.getTongTien(), listKH.getThanThiet() });
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void findLS(String giaTri) {
		try {
			out.writeObject("FIND_LS");
			out.writeObject(giaTri);
			out.flush();
			List<HoaDon> listHD = (List<HoaDon>) in.readObject();
			DefaultTableModel tableModel = view.getTableModelLS();
			tableModel.setRowCount(0);
			for (HoaDon s : listHD) {
				tableModel.addRow(
						new Object[] { s.getId(), s.getSdt(), s.getThoiGian(), s.getTongTien(), s.getMaNhanVien() });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void findCTLS(String giaTri) {
		try {
			out.writeObject("FIND_CTLS");
			out.writeObject(giaTri);
			out.flush();
			List<ChiTietHoaDon> listCTHD = (List<ChiTietHoaDon>) in.readObject();
			DefaultTableModel tableModel = view.getTableModelCT();
			tableModel.setRowCount(0);
			for (ChiTietHoaDon s : listCTHD) {
				tableModel.addRow(new Object[] { s.getId(), s.getMaSach(), s.getSoLuong(), s.getGia() });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void findNV(String giaTri) {
		try {
			out.writeObject("FIND_NV");
			out.writeObject(giaTri);
			out.flush();
			List<NhanVien> listNV = (List<NhanVien>) in.readObject();
			DefaultTableModel tableModel = view.getTableModelNV();
			tableModel.setRowCount(0);
			for (NhanVien s : listNV) {
				tableModel.addRow(new Object[] { s.getId(), s.getHoTen(), s.getGioiTinh(), s.getSdt(), s.getViTri() });
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertLSDN(LichSuDangNhap l) {
		try {
			out.writeObject("INSERT_LSDN");
			out.writeObject(l);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loadNCC() {
		try {
			out.writeObject("GET_NCC");
			out.flush();
			List<NhaCungCap> listNV = (List<NhaCungCap>) in.readObject();
			DefaultTableModel tableModel = view.getTableModelNCC();
			tableModel.setRowCount(0);
			for (NhaCungCap s : listNV) {
				tableModel.addRow(new Object[] { s.getId(), s.getTenNhaCungCap() });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loadLSDN() {
		try {
			out.writeObject("GET_LSDN");
			out.flush();
			List<LichSuDangNhap> listNV = (List<LichSuDangNhap>) in.readObject();
			DefaultTableModel tableModel = view.getTableModelLSDN();
			tableModel.setRowCount(0);

			// Thêm các hàng từ cuối danh sách lên đầu bảng
			for (int i = listNV.size() - 1; i >= 0; i--) {
				LichSuDangNhap lsDN = listNV.get(i);
				tableModel.addRow(new Object[] { lsDN.getId(), lsDN.getMaNV() });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	   public static String encodeString(String input) {
	        // Sử dụng Base64 encoder để mã hóa chuỗi
	        return Base64.getEncoder().encodeToString(input.getBytes());
	    }
	   
	   public static String decodeString(String encodedInput) {
	        byte[] decodedBytes = Base64.getDecoder().decode(encodedInput);
	        return new String(decodedBytes);
	    }

}
