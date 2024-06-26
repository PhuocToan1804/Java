package Server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import DAO.ChiTietHoaDonDAO;
import DAO.HoaDonDAO;
import DAO.LichSuDangNhapDAO;
import DAO.sachDAO;
import DAO.taiKhoanDAO;
import model.ChiTietHoaDon;
import model.HoaDon;
import model.KhachHang;
import model.NhanVien;
import model.Sach;
import model.TaiKhoan;
import DAO.khachHangDAO;
import DAO.nhanVienDAO;
import model.LichSuDangNhap;
import model.NhaCungCap;
import DAO.nhaCungCapDAO;;
public class ClientHandler extends Thread {
	private Socket socket;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private sachDAO bookDAO;
	private taiKhoanDAO accountDAO;
	private HoaDonDAO billDAO;
	private ChiTietHoaDonDAO detailBillDAO;
	private khachHangDAO khachHangDAO;
	private nhanVienDAO nhanVienDAO;
	private LichSuDangNhapDAO lichSuDangNhapDAO;
private nhaCungCapDAO nhaCungCapDAO;
	public ClientHandler(Socket socket) {
		this.socket = socket;
		this.bookDAO = new sachDAO();
		this.accountDAO = new taiKhoanDAO();
		this.billDAO = new HoaDonDAO();
		this.detailBillDAO = new ChiTietHoaDonDAO();
		this.khachHangDAO = new khachHangDAO();
		this.nhanVienDAO = new nhanVienDAO();
		this.lichSuDangNhapDAO = new LichSuDangNhapDAO();
		this.nhaCungCapDAO = new nhaCungCapDAO();
		
	}

	public void run() {
		try {
			in = new ObjectInputStream(socket.getInputStream());
			out = new ObjectOutputStream(socket.getOutputStream());

			Object request;
			while ((request = in.readObject()) != null) {
				if (request instanceof String) {
					String command = (String) request;
					switch (command) {
					case "ADD_BOOK":
						handleAddBook();
						break;
					case "UPDATE_BOOK":
						handleUpdateBook();
						break;
					case "DELETE_BOOK":
						handleDeleteBook();
						break;
					case "SIGN_IN":
						checkTaiKhoan();
						break;
					case "GET_ALL_BOOKS":
						getAllBook();
						break;
					case "ADD_BILL":
						addBill();
						break;
					case "ADD_DETAIL_BILL":
						addDetailBill();
						break;
					case "UPDATE_CUSTOMER":
						updateCustomer();
						break;
					case "INSERT_CUSTOMER":
						addCustomer();
						break;
					case "GET_KH_BOOKS":
						getAllKH();
						break;
					case "GET_NV":
						getNV();
						break;
					case "GET_HD":
						getHD();
						break;
					case "GET_DETAIL_BILL":
						getCTHD();
						break;
					case "DELETE_CUSTOMER":
						deleteKH();
						break;
					case "INSERT_NV":
						addNV();
						break;
					case "UPDATE_NV":
						updateNV();
						break;
					case "DELETE_NV":
					    deleteNV();
                        break;
					case "INSERT_ACCOUNT":
						insertACC();
						break;
					case "UPDATE_ACCOUNT":
						upDateACC();
						break;
					case "DELETE_ACCOUNT":
						deleteAcc();
						break;
					case "GET_ALL_ACCOUNT":
						getAllAccount();
						break;
					case "DOANH_THU":
						getDoanhThu();
						break;
					case "DOANH_THU_THANG":
						getDoanhThuThang();
						break;
					case "DOANH_THU_NAM":
						getDoanhThuNam();
						break;
					case "FIND_BOOK_HD":
						findSachHD();
						break;
					case "FIND_BOOK":
						findSach();
						break;
					case "FIND_KH":
						findKH();
						break;
					case "FIND_LS":
						findLS();
						break;
					case "FIND_CTLS":
						findCTLS();
						break;
					case "FIND_NV":
						findNV();
						break;
					case "INSERT_LSDN":
						insertLSDN();
						break;
					case "GET_NCC":
						getNCC();
						break;
					case "GET_LSDN":
						getLSDN();
						break;
					case "INSERT_NCC":
						insertNCC();
						break;
					case "UPDATE_NCC":
						upDateNCC();
						break;
					case "DELETE_NCC":
						deleteNCC();
						break;
					default:
						System.out.println("Unknown command: " + command);
					}
				}
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deleteNCC() {
		try {
			NhaCungCap ncc = (NhaCungCap) in.readObject();
			nhaCungCapDAO.delete(ncc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertNCC() {
		try {
			NhaCungCap ncc = (NhaCungCap) in.readObject();
			nhaCungCapDAO.insert(ncc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void upDateNCC() {
		try {
			NhaCungCap ncc = (NhaCungCap) in.readObject();
			nhaCungCapDAO.update(ncc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void getLSDN() {
        List<LichSuDangNhap> listLSDN = lichSuDangNhapDAO.selectAll();
        try {
            out.writeObject(listLSDN);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	public void getNCC() {
		List<NhaCungCap> listNCC = nhaCungCapDAO.selectAll();
        try {
            out.writeObject(listNCC);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public void insertLSDN() {
		try {
			LichSuDangNhap l = (LichSuDangNhap) in.readObject();
			lichSuDangNhapDAO.insert(l);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void findNV() {
		try {
			String nv = (String) in.readObject();
			List<NhanVien> listNV = nhanVienDAO.searchByCriteria(nv);
			out.writeObject(listNV);
			out.flush();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void findCTLS() {
		try {
			String ctls = (String) in.readObject();
			List<ChiTietHoaDon> listCTLS = detailBillDAO.searchByCriteria(ctls);
			out.writeObject(listCTLS);
			out.flush();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void findLS() {
		try {
			String ls = (String) in.readObject();
			List<HoaDon> listHD = billDAO.searchByCriteria(ls);
			out.writeObject(listHD);
			out.flush();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void findKH() {
		try {
			KhachHang kh = (KhachHang) in.readObject();
			KhachHang KHV = khachHangDAO.selectById(kh);
			out.writeObject(KHV);
			out.flush();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void findSachHD() {
		try {
			String sach = (String) in.readObject();
			List<Sach> listSach = bookDAO.searchByCriteria(sach);
			out.writeObject(listSach);
			out.flush();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void findSach() {
		try {
			String sach = (String) in.readObject();
			List<Sach> listSach = bookDAO.searchByCriteria(sach);
			out.writeObject(listSach);
			out.flush();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void getDoanhThuThang() {
		List<Object[]> listDT = billDAO.getDoanhThuTheoThang();
		try {
			out.writeObject(listDT);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getDoanhThuNam() {
		List<Object[]> listDT = billDAO.getDoanhThuTheoNam();
		try {
			out.writeObject(listDT);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void getDoanhThu() {
		List<Object[]> listDT = billDAO.getDoanhThuTheoNgay();
		try {
			out.writeObject(listDT);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void getAllAccount() {
		List<TaiKhoan> listAcc = accountDAO.selectAll();
		try {
			out.writeObject(listAcc);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void deleteAcc() {
		try {
			TaiKhoan acc = (TaiKhoan) in.readObject();
			accountDAO.delete(acc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void deleteNV() {
		try {
			NhanVien nv = (NhanVien) in.readObject();
			nhanVienDAO.delete(nv);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addNV() {
		try {
			NhanVien nv = (NhanVien) in.readObject();
			nhanVienDAO.insert(nv);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertACC() {
		try {
			TaiKhoan acc = (TaiKhoan) in.readObject();
			accountDAO.insert(acc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void upDateACC() {
		try {
			TaiKhoan acc = (TaiKhoan) in.readObject();
			accountDAO.update(acc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateNV() {
		try {
			NhanVien nv = (NhanVien) in.readObject();
			nhanVienDAO.update(nv);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void handleAddBook() {
		try {
			Sach book = (Sach) in.readObject();
			bookDAO.insert(book);

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void handleUpdateBook() {
		try {
			Sach updatedBook = (Sach) in.readObject();
			bookDAO.update(updatedBook);

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void handleDeleteBook() {
		try {
			Sach deleteBook = (Sach) in.readObject();
			bookDAO.delete(deleteBook);
			;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
	}
	
	public void deleteKH() {
		try {
			KhachHang deleteKH = (KhachHang) in.readObject();
			khachHangDAO.delete(deleteKH);
			;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
	}
	public void getAllBook() {
		List<Sach> listSach = bookDAO.selectAll();
		try {
			out.writeObject(listSach);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getAllKH() {
		List<KhachHang> listKH = khachHangDAO.selectAll();
		try {
			out.writeObject(listKH);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void checkTaiKhoan() {
		try {
			TaiKhoan checkTaiKhoan = (TaiKhoan) in.readObject();
			if (accountDAO.exists(checkTaiKhoan)) {
				out.writeObject("TaiKhoan_Exists");
			} else {
				out.writeObject("TaiKhoan_NotExists");
			}
			out.flush();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void addBill() {
		try {
			HoaDon bill = (HoaDon) in.readObject();
			billDAO.insert(bill);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void addDetailBill() {
		try {
			ChiTietHoaDon detailBill = (ChiTietHoaDon) in.readObject();
			detailBillDAO.insert(detailBill);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateCustomer() {
		try {
			KhachHang kh = (KhachHang) in.readObject();
			khachHangDAO.update(kh);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addCustomer() {
		try {
			KhachHang kh = (KhachHang) in.readObject();
			khachHangDAO.insert(kh);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getNV() {
		List<NhanVien> listNV = nhanVienDAO.selectAll();
		try {
			out.writeObject(listNV);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getHD() {
		List<HoaDon> listHD = billDAO.selectAll();
		try {
			out.writeObject(listHD);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getCTHD() {
		try {
			ChiTietHoaDon checkCT = (ChiTietHoaDon) in.readObject();
			List<ChiTietHoaDon> listCTHD = detailBillDAO.selectByIdList(checkCT);
			out.writeObject(listCTHD);
			out.flush();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	

}
