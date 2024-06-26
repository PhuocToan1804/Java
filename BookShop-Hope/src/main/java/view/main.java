package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import DAO.nhanVienDAO;
import DAO.sachDAO;
import DAO.taiKhoanDAO;
import controller.Control1;

import model.Sach;
import model.TaiKhoan;

import javax.swing.JSpinner;
import javax.swing.SwingConstants;

public class main extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField searchField;
	private DefaultTableModel tableModel;
	private DefaultTableModel tableModel1;
	private DefaultTableModel tableModelKH;
	private JTable sachTable;
	
	private sachDAO sachDAO;
	private JTable hoaDonTable;
	private JTable hoaDonTable_1;
	private JSpinner spinner;
	private taiKhoanDAO taiKhoan;
	private String tenDangNhap;
	private TaiKhoan objTaiKhoan;
	private nhanVienDAO nhanVien;
	private JPanel contentPaneView;
	private JTextField dangNhap;
	private JPasswordField passWord;
	private JButton themButton;
	private JButton dangNhapButton;
	private JComboBox comboBox;
	private Control1 control;
	private JMenuItem allKhachHang;
	private JButton themKHButton;
	private JButton suaKHButton;
	private JButton xoaKHButton;
	private JTextField textField;
	private JButton dongYButton;
	private JLabel tongTienAll;
	private JTable KHTable;
	private  JMenuItem trangChuMenuItem;
	private JMenuItem thongKeSachItem;
	private JTable SachTable;
	private DefaultTableModel tableModelSach;
	private JButton themKHButtonSach;
	private JButton xoaKHButtonSach;
	private JButton suaKHButtonSach;
    private DefaultTableModel tableModelNV;
	private JMenuItem allNV;
	private JButton themKHButtonNV;
	private JButton xoaButtonNV;
	private JButton suaButtonNV;
	private JTable NVTable;
	private JMenuItem lichSu;
	private JTable LSTable;
	private DefaultTableModel tableModelLS;
	private JButton chiTiet;
    private DefaultTableModel tableModelCT;
    private JTable CTTable;
    private JButton quayLai;
    private JMenuItem TKAll;
    private JTable TKTable;
    private DefaultTableModel tableModelTK;
    private JButton themKHButtonTK;
    private JButton xoaButtonTK;
    private JButton suaButtonTK;
    private JMenu TKMenu;
    private JMenu NVMenu;
    private JMenu HDMenu;
    private JMenu khachHangMenu;
    private JMenu mnNewMenu_2;
    private JMenu trangChu;
    private JButton xoaHDButton;
    private JTable DTTable;
    private DefaultTableModel tableModelDT;
    private JButton chiTietDT;
    private JMenuItem DTAll;
    private JMenu doanhThuMenu;
    private JMenuItem DTAllThang;
    private JMenuItem DTAllNam;
    private JButton searchButton;
    private JTable NCCTable;
    private DefaultTableModel tableModelNCC;
    private JButton themButtonNCC;
    private JButton xoaButtonNCC;
    private JButton suaButtonNCC;
    private JMenuItem NCCAll;
    private JMenu NCCMenu;
    private JTable LSDNTable;
    private DefaultTableModel tableModelLSDN;
    private JMenuItem LSDNAll;
    private JMenu LSDNMenu;
    private JButton dangXuatButton;
	 public main() {
		 	control = new Control1(this);
		    this.login();
	    }
	 public void login() {
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 1040, 585);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(0, 100, 0));
			panel.setBounds(0, 0, 626, 558);
			contentPane.add(panel);
			panel.setLayout(null);
			
			JLabel lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\truon\\Downloads\\books.png"));
			lblNewLabel_2.setBounds(159, 58, 268, 264);
			panel.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("NHÀ SÁCH HI VỌNG");
			lblNewLabel_3.setForeground(new Color(255, 255, 255));
			lblNewLabel_3.setBackground(new Color(255, 255, 255));
			lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD, 48));
			lblNewLabel_3.setBounds(99, 356, 473, 61);
			panel.add(lblNewLabel_3);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(new Color(255, 255, 255));
			panel_1.setBounds(625, 0, 401, 548);
			contentPane.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Tên đăng nhập:");
			lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
			lblNewLabel.setBounds(36, 137, 176, 45);
			panel_1.add(lblNewLabel);
			
			dangNhap = new JTextField();
			dangNhap.setBounds(36, 178, 335, 36);
			panel_1.add(dangNhap);
			dangNhap.setColumns(10);
			
			JLabel lblMtKhu = new JLabel("Mật khẩu:");
			lblMtKhu.setFont(new Font("Arial", Font.BOLD, 18));
			lblMtKhu.setBounds(36, 224, 133, 45);
			panel_1.add(lblMtKhu);
			
			passWord = new JPasswordField();
			passWord.setBounds(36, 263, 335, 36);
			panel_1.add(passWord);
			
			JLabel lblNewLabel_1 = new JLabel("ĐĂNG NHẬP");
			lblNewLabel_1.setForeground(new Color(0, 128, 0));
			lblNewLabel_1.setBackground(new Color(0, 128, 0));
			lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 30));
			lblNewLabel_1.setBounds(105, 52, 219, 63);
			panel_1.add(lblNewLabel_1);
			
			dangNhapButton = new JButton("Đăng nhập");
			dangNhapButton.setForeground(new Color(255, 255, 255));
			dangNhapButton.setBackground(new Color(0, 128, 0));
			dangNhapButton.setFont(new Font("Arial", Font.BOLD, 16));
			dangNhapButton.addActionListener(control);
			
			dangNhapButton.setBounds(119, 371, 161, 36);
			panel_1.add(dangNhapButton);
			
			comboBox = new JComboBox();
			comboBox.setFont(new Font("Arial", Font.BOLD, 14));
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nhân viên", "Chủ"}));
			comboBox.setBounds(36, 324, 103, 36);
			panel_1.add(comboBox);
		}
		
		
		
	/**
	 * Create the frame.
	 */
	public void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 675);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(0, 102, 102));
		menuBar.setBounds(0, 0, 651, 39);
		contentPane.add(menuBar);
		
		trangChu = new JMenu("Thanh toán");
		trangChu.setForeground(Color.WHITE);
		menuBar.add(trangChu);
		trangChuMenuItem = new JMenuItem("Thanh toán");
		trangChuMenuItem.addActionListener(control);
		trangChu.add(trangChuMenuItem);
		
		
		mnNewMenu_2 = new JMenu("Thống kê sách");
		mnNewMenu_2.setForeground(Color.WHITE);
		thongKeSachItem = new JMenuItem("Tất cả");
		mnNewMenu_2.add(thongKeSachItem);
		thongKeSachItem.addActionListener(control);
		menuBar.add(mnNewMenu_2);
		
		
		khachHangMenu = new JMenu("Khách hàng");
		menuBar.add(khachHangMenu);
		
		allKhachHang = new JMenuItem("Tất cả");
		khachHangMenu.add(allKhachHang);
		allKhachHang.addActionListener(control);
		 HDMenu = new JMenu("Lịch sử mua hàng");
		menuBar.add(HDMenu);
		lichSu = new JMenuItem("Tất cả");
		HDMenu.add(lichSu);
		lichSu.addActionListener(control);
		 NVMenu = new JMenu("Nhân viên");
		menuBar.add(NVMenu);
		
		allNV = new JMenuItem("Tất cả");
		NVMenu.add(allNV);
		allNV.addActionListener(control);
		
	 TKMenu = new JMenu("Tài khoản");
		menuBar.add(TKMenu);
		TKAll = new JMenuItem("Tất cả");
		TKMenu.add(TKAll);
		TKAll.addActionListener(control);
		
		doanhThuMenu = new JMenu("Doanh thu");
		menuBar.add(doanhThuMenu);
		DTAll = new JMenuItem("Theo ngày");
		doanhThuMenu.add(DTAll);
		DTAll.addActionListener(control);
		
		DTAllThang = new JMenuItem("Theo tháng");
		doanhThuMenu.add(DTAllThang);
		DTAllThang.addActionListener(control);
		
		DTAllNam = new JMenuItem("Theo năm");
		doanhThuMenu.add(DTAllNam);
		DTAllNam.addActionListener(control);
		
		NCCMenu = new JMenu("Nhà cung cấp");
		menuBar.add(NCCMenu);
		NCCAll = new JMenuItem("Tất cả");
		NCCMenu.add(NCCAll);
		NCCAll.addActionListener(control);
		
		LSDNMenu = new JMenu("Lịch sử đăng nhập");
		menuBar.add(LSDNMenu);
		LSDNAll = new JMenuItem("Tất cả");
		LSDNMenu.add(LSDNAll);
		LSDNAll.addActionListener(control);
		searchField = new JTextField();
		searchField.setBounds(653, 10, 161, 29);
		contentPane.add(searchField);
		searchField.setColumns(10);
		
		 searchButton = new JButton("");
		 searchButton.addActionListener(control);
		searchButton.setBackground(Color.WHITE);
		searchButton.setIcon(new ImageIcon("C:\\Users\\truon\\Downloads\\search.png"));
		searchButton.addActionListener(control);
		searchButton.setBounds(824, 10, 51, 28);
		contentPane.add(searchButton);
		

		dangXuatButton = new JButton("Đăng xuất");
		dangXuatButton.setBackground(new Color(0, 100, 0));
		dangXuatButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		dangXuatButton.setForeground(new Color(255, 255, 255));
		dangXuatButton.setBounds(1014, 10, 162, 29);
		dangXuatButton.addActionListener(control);
		contentPane.add(dangXuatButton);
		
	}
	
	
	public void BookSell() {

		JTabbedPane sachPane = new JTabbedPane(JTabbedPane.TOP);
		sachPane.setBackground(new Color(255, 255, 255));
		sachPane.setBounds(0, 49, 762, 579);
		sachPane.setFont(new Font("Arial", Font.BOLD, 14));
		contentPane.add(sachPane);
		
		
		
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Mã Sách");
		tableModel.addColumn("Tên sách");
		tableModel.addColumn("Thể loại");
		tableModel.addColumn("Tác giả");
		tableModel.addColumn("Giá");
		tableModel.addColumn("Số lượng");
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		sachPane.addTab("Sách", null, panel_1, null);
		panel_1.setLayout(null);
		sachTable = new JTable(tableModel);
		sachTable.setBackground(new Color(255, 255, 255));
		sachTable.setFont(new Font("Arial", Font.PLAIN, 10));
		sachTable.setBounds(0, 0, 1140, 503);
		
		panel_1.add(sachTable);
		JScrollPane scrollPane2 = new JScrollPane(sachTable);
		scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_1.add(scrollPane2);
		scrollPane2.setBounds(0, 0, 757, 548);
		
		themButton = new JButton("Thêm");
		themButton.setFont(new Font("Arial", Font.BOLD, 20));
		themButton.setForeground(new Color(255, 255, 255));
		themButton.setBackground(new Color(0, 102, 51));
		themButton.setBounds(772, 591, 103, 37);
		themButton.addActionListener(control);
		contentPane.add(themButton);
		
		
		spinner = new JSpinner();
		spinner.setForeground(new Color(255, 255, 255));
		spinner.setBackground(new Color(0, 204, 153));
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 19));
		spinner.setBounds(885, 591, 94, 37);
		contentPane.add(spinner);
		
		JPanel panelHoaDon = new JPanel();
		panelHoaDon.setBounds(772, 49, 404, 532);
		contentPane.add(panelHoaDon);
		panelHoaDon.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HOÁ ĐƠN");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel.setBounds(113, 10, 176, 51);
		panelHoaDon.add(lblNewLabel);
		
		
		sachTable.getColumnModel().getColumn(0).setPreferredWidth(30);
		sachTable.getColumnModel().getColumn(1).setPreferredWidth(150);
		sachTable.getColumnModel().getColumn(2).setPreferredWidth(70);
		sachTable.getColumnModel().getColumn(3).setPreferredWidth(100);
		sachTable.getColumnModel().getColumn(4).setPreferredWidth(20);
		
		
		
		tableModel1 = new DefaultTableModel();
		tableModel1.addColumn("Tên sách");
		tableModel1.addColumn("Giá");
		tableModel1.addColumn("Số lượng");
		tableModel1.addColumn("Tổng");
		hoaDonTable_1 = new JTable(tableModel1);
		hoaDonTable_1.setFont(new Font("Arial", Font.PLAIN, 10));
		
		panelHoaDon.add(hoaDonTable_1);
		hoaDonTable_1.setShowGrid(false);
		JScrollPane scrollPane = new JScrollPane(hoaDonTable_1);
		
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 107, 404, 375);
		panelHoaDon.add(scrollPane);
		
		JLabel lblNewLabel_4 = new JLabel("SDT:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(64, 71, 51, 26);
		panelHoaDon.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(123, 71, 192, 26);
		panelHoaDon.add(textField);
		textField.setColumns(10);
		
		tongTienAll = new JLabel();
		tongTienAll.setForeground(new Color(0, 0, 0));
		tongTienAll.setBackground(new Color(0, 102, 51));
		tongTienAll.setFont(new Font("Tahoma", Font.BOLD, 14));
		tongTienAll.setBounds(244, 497, 150, 25);
		panelHoaDon.add(tongTienAll);
		
		JLabel lblNewLabel_6 = new JLabel("Tổng");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(10, 496, 65, 26);
		panelHoaDon.add(lblNewLabel_6);
		
		dongYButton = new JButton("Click");
		dongYButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		dongYButton.setBounds(989, 591, 88, 37);
		dongYButton.addActionListener(control);
		contentPane.add(dongYButton);
		
		xoaHDButton = new JButton("Xóa");
		xoaHDButton.setBounds(1087, 591, 85, 37);
		xoaHDButton.addActionListener(control);
		contentPane.add(xoaHDButton);
		
		
		
		
		hoaDonTable_1.getColumnModel().getColumn(0).setPreferredWidth(150);
		hoaDonTable_1.getColumnModel().getColumn(1).setPreferredWidth(10);
		hoaDonTable_1.getColumnModel().getColumn(2).setPreferredWidth(15);
		hoaDonTable_1.getColumnModel().getColumn(3).setPreferredWidth(15);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	    centerRenderer.setHorizontalAlignment(JLabel.CENTER);
	    for (int i = 1; i < hoaDonTable_1.getColumnCount(); i++) {
            hoaDonTable_1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
	    control.loadSach();
	}
	
	 
	
	public void khachhang() {
		contentPane.removeAll();

		init();
		JTabbedPane tabbedPaneKH = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneKH.setBackground(new Color(255, 255, 255));
		tabbedPaneKH.setBounds(0, 49, 1186, 579);
		tabbedPaneKH.setFont(new Font("Arial", Font.BOLD, 14));
		contentPane.add(tabbedPaneKH);
		tableModelKH = new DefaultTableModel();
		tableModelKH.addColumn("SDT");
		tableModelKH.addColumn("Tổng tiền đã mua");
		tableModelKH.addColumn("Thân thiết");
		
		JPanel panelKH = new JPanel();
		panelKH.setBackground(new Color(255, 255, 255));
		tabbedPaneKH.addTab("Khách hàng", null, panelKH, null);
		panelKH.setLayout(null);
		KHTable = new JTable(tableModelKH);
		KHTable.setBackground(new Color(255, 255, 255));
		KHTable.setFont(new Font("Arial", Font.PLAIN, 10));
		KHTable.setBounds(0, 0, 1140, 503);
		panelKH.add(KHTable);
		JScrollPane scrollPane2 = new JScrollPane(KHTable);
		scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panelKH.add(scrollPane2);
		scrollPane2.setBounds(0, 0, 1039, 548);
		
		themKHButton = new JButton("Thêm");
		themKHButton.setForeground(new Color(255, 255, 255));
		themKHButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		themKHButton.setBackground(new Color(0, 102, 0));
		themKHButton.addActionListener(control);
		themKHButton.setBounds(1049, 25, 122, 29);
		panelKH.add(themKHButton);
		
		xoaKHButton = new JButton("Xóa");
		xoaKHButton.setForeground(new Color(255, 255, 255));
		xoaKHButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		xoaKHButton.setBackground(new Color(0, 102, 0));
		xoaKHButton.setBounds(1049, 82, 122, 29);
		xoaKHButton.addActionListener(control);
		panelKH.add(xoaKHButton);
		
		suaKHButton = new JButton("Sửa");
		suaKHButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		suaKHButton.setForeground(new Color(255, 255, 255));
		suaKHButton.setBackground(new Color(0, 102, 0));
		suaKHButton.setBounds(1049, 128, 122, 29);
		suaKHButton.addActionListener(control);
		panelKH.add(suaKHButton);
		control.loadKH();
	}
	
	public void thongKeSach() {
		contentPane.removeAll();

		init();
		JTabbedPane tabbedPaneSach = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneSach.setBackground(new Color(255, 255, 255));
		tabbedPaneSach.setBounds(0, 49, 1186, 579);
		tabbedPaneSach.setFont(new Font("Arial", Font.BOLD, 14));
		contentPane.add(tabbedPaneSach);
		tableModelSach = new DefaultTableModel();
		tableModelSach.addColumn("Mã sách");
		tableModelSach.addColumn("Tên sách");
		tableModelSach.addColumn("Thể loại");
		tableModelSach.addColumn("Nhà xuất bản");
		tableModelSach.addColumn("Năm xuất bản");
		tableModelSach.addColumn("Mã nhà cung cấp");
		tableModelSach.addColumn("Tác giả");
		tableModelSach.addColumn("Số lượng");
		tableModelSach.addColumn("Giá");
		JPanel panelSach = new JPanel();
		panelSach.setBackground(new Color(255, 255, 255));
		tabbedPaneSach.addTab("Thống kê sách", null, panelSach, null);
		panelSach.setLayout(null);
		SachTable = new JTable(tableModelSach);
		SachTable.setBackground(new Color(255, 255, 255));
		SachTable.setFont(new Font("Arial", Font.PLAIN, 10));
		SachTable.setBounds(0, 0, 1140, 503);
		panelSach.add(SachTable);
		JScrollPane scrollPane2 = new JScrollPane(SachTable);
		scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panelSach.add(scrollPane2);
		scrollPane2.setBounds(0, 0, 1039, 548);
		
		themKHButtonSach = new JButton("Thêm");
		themKHButtonSach.setForeground(new Color(255, 255, 255));
		themKHButtonSach.setFont(new Font("Tahoma", Font.BOLD, 14));
		themKHButtonSach.setBackground(new Color(0, 102, 0));
		themKHButtonSach.addActionListener(control);
		themKHButtonSach.setBounds(1049, 25, 122, 29);
		panelSach.add(themKHButtonSach);
		
		xoaKHButtonSach = new JButton("Xóa");
		xoaKHButtonSach.setForeground(new Color(255, 255, 255));
		xoaKHButtonSach.setFont(new Font("Tahoma", Font.BOLD, 14));
		xoaKHButtonSach.setBackground(new Color(0, 102, 0));
		xoaKHButtonSach.setBounds(1049, 82, 122, 29);
		xoaKHButtonSach.addActionListener(control);
		panelSach.add(xoaKHButtonSach);
		
		suaKHButtonSach = new JButton("Sửa");
		suaKHButtonSach.setFont(new Font("Tahoma", Font.BOLD, 14));
		suaKHButtonSach.setForeground(new Color(255, 255, 255));
		suaKHButtonSach.setBackground(new Color(0, 102, 0));
		suaKHButtonSach.setBounds(1049, 128, 122, 29);
		suaKHButtonSach.addActionListener(control);
		panelSach.add(suaKHButtonSach);
		control.loadSach1();
	}

	public void nhanVien() {
		contentPane.removeAll();
		init();
		JTabbedPane tabbedPaneNV = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneNV.setBackground(new Color(255, 255, 255));
		tabbedPaneNV.setBounds(0, 49, 1186, 579);
		tabbedPaneNV.setFont(new Font("Arial", Font.BOLD, 14));
		contentPane.add(tabbedPaneNV);
		tableModelNV = new DefaultTableModel();
		tableModelNV.addColumn("Mã NV");
		tableModelNV.addColumn("Họ tên");
		tableModelNV.addColumn("Giới tính");
		tableModelNV.addColumn("SDT");
		tableModelNV.addColumn("Vị trí");
		JPanel panelNV = new JPanel();
		panelNV.setBackground(new Color(255, 255, 255));
		tabbedPaneNV.addTab("Nhân viên", null, panelNV, null);
		panelNV.setLayout(null);
		NVTable = new JTable(tableModelNV);
		NVTable.setBackground(new Color(255, 255, 255));
		NVTable.setFont(new Font("Arial", Font.PLAIN, 10));
		NVTable.setBounds(0, 0, 1140, 503);
		panelNV.add(NVTable);
		JScrollPane scrollPane2 = new JScrollPane(NVTable);
		scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panelNV.add(scrollPane2);
		scrollPane2.setBounds(0, 0, 1039, 548);
		
		themKHButtonNV = new JButton("Thêm");
		themKHButtonNV.setForeground(new Color(255, 255, 255));
		themKHButtonNV.setFont(new Font("Tahoma", Font.BOLD, 14));
		themKHButtonNV.setBackground(new Color(0, 102, 0));
		themKHButtonNV.addActionListener(control);
		themKHButtonNV.setBounds(1049, 25, 122, 29);
		panelNV.add(themKHButtonNV);
		
		xoaButtonNV = new JButton("Xóa");
		xoaButtonNV.setForeground(new Color(255, 255, 255));
		xoaButtonNV.setFont(new Font("Tahoma", Font.BOLD, 14));
		xoaButtonNV.setBackground(new Color(0, 102, 0));
		xoaButtonNV.setBounds(1049, 82, 122, 29);
		xoaButtonNV.addActionListener(control);
		panelNV.add(xoaButtonNV);
		
		suaButtonNV = new JButton("Sửa");
		suaButtonNV.setFont(new Font("Tahoma", Font.BOLD, 14));
		suaButtonNV.setForeground(new Color(255, 255, 255));
		suaButtonNV.setBackground(new Color(0, 102, 0));
		suaButtonNV.setBounds(1049, 128, 122, 29);
		suaButtonNV.addActionListener(control);
		panelNV.add(suaButtonNV);
	
	}
	
	public void lichSuMuaHang() {
		contentPane.removeAll();
		init();
		JTabbedPane tabbedPaneLS = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneLS.setBackground(new Color(255, 255, 255));
		tabbedPaneLS.setBounds(0, 49, 1186, 579);
		tabbedPaneLS.setFont(new Font("Arial", Font.BOLD, 14));
		contentPane.add(tabbedPaneLS);
		tableModelLS = new DefaultTableModel();
		tableModelLS.addColumn("Mã hóa đơn");
		tableModelLS.addColumn("SDT");
		tableModelLS.addColumn("Thời gian");
		tableModelLS.addColumn("Tổng tiền");
		tableModelLS.addColumn("Mã nhân viên");
		
		JPanel panelLS = new JPanel();
		panelLS.setBackground(new Color(255, 255, 255));
		tabbedPaneLS.addTab("Lịch sử bán hàng", null, panelLS, null);
		panelLS.setLayout(null);
		LSTable = new JTable(tableModelLS);
		LSTable.setBackground(new Color(255, 255, 255));
		LSTable.setFont(new Font("Arial", Font.PLAIN, 10));
		LSTable.setBounds(0, 0, 1140, 503);
		panelLS.add(LSTable);
		JScrollPane scrollPane2 = new JScrollPane(LSTable);
		scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panelLS.add(scrollPane2);
		scrollPane2.setBounds(0, 0, 1039, 548);
		
		chiTiet = new JButton("Chi tiết");
		chiTiet.setFont(new Font("Tahoma", Font.BOLD, 14));
		chiTiet.setForeground(new Color(255, 255, 255));
		chiTiet.setBackground(new Color(0, 102, 0));
		chiTiet.setBounds(1049, 29, 122, 29);
		chiTiet.addActionListener(control);
		panelLS.add(chiTiet);
	}
	
	public void chiTietDonHang() {
	    contentPane.removeAll();
	    init();
	    
	    JTabbedPane tabbedPaneCT = new JTabbedPane(JTabbedPane.TOP);
	    tabbedPaneCT.setBackground(new Color(255, 255, 255));
	    tabbedPaneCT.setBounds(0, 49, 1186, 579);
	    tabbedPaneCT.setFont(new Font("Arial", Font.BOLD, 14));
	    contentPane.add(tabbedPaneCT);
	    
	    tableModelCT = new DefaultTableModel();
	    tableModelCT.addColumn("Mã hóa đơn");
	    tableModelCT.addColumn("Mã sách");
	    tableModelCT.addColumn("Số lượng");
	    tableModelCT.addColumn("Tổng tiền");

	    JPanel panelCT = new JPanel();
	    panelCT.setBackground(new Color(255, 255, 255));
	    panelCT.setLayout(null);

	    CTTable = new JTable(tableModelCT);
	    CTTable.setBackground(new Color(255, 255, 255));
	    CTTable.setFont(new Font("Arial", Font.PLAIN, 10));
	    CTTable.setBounds(0, 0, 1140, 503);

	    // Thay vì thêm CTTable trực tiếp vào panelCT, thêm nó vào JScrollPane
	    JScrollPane scrollPane2 = new JScrollPane(CTTable);
	    scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	    scrollPane2.setBounds(0, 0, 1039, 548);
	    panelCT.add(scrollPane2);

	    quayLai = new JButton("Quay lại");
	    quayLai.setFont(new Font("Tahoma", Font.BOLD, 14));
	    quayLai.setForeground(new Color(255, 255, 255));
	    quayLai.setBackground(new Color(0, 102, 0));
	    quayLai.setBounds(1049, 29, 122, 29);
	    quayLai.addActionListener(control);
	    panelCT.add(quayLai);

	    tabbedPaneCT.addTab("Chi tiết đơn hàng", null, panelCT, null);
	}

	
	public void TaiKhoan() {
		contentPane.removeAll();
		init();
		JTabbedPane tabbedPaneTK = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneTK.setBackground(new Color(255, 255, 255));
		tabbedPaneTK.setBounds(0, 49, 1186, 579);
		tabbedPaneTK.setFont(new Font("Arial", Font.BOLD, 14));
		contentPane.add(tabbedPaneTK);
		tableModelTK = new DefaultTableModel();
		tableModelTK.addColumn("Mã tài khoản");
		tableModelTK.addColumn("Mật khẩu");
		tableModelTK.addColumn("Loại tài khoản");
				
		JPanel panelTK = new JPanel();
		panelTK.setBackground(new Color(255, 255, 255));
		tabbedPaneTK.addTab("Tài khoản", null, panelTK, null);
		panelTK.setLayout(null);
		TKTable = new JTable(tableModelTK);
		TKTable.setBackground(new Color(255, 255, 255));
		TKTable.setFont(new Font("Arial", Font.PLAIN, 10));
		TKTable.setBounds(0, 0, 1140, 503);
		panelTK.add(TKTable);
		JScrollPane scrollPane2 = new JScrollPane(TKTable);
		scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panelTK.add(scrollPane2);
		scrollPane2.setBounds(0, 0, 1039, 548);
		
		themKHButtonTK = new JButton("Thêm");
		themKHButtonTK.setForeground(new Color(255, 255, 255));
		themKHButtonTK.setFont(new Font("Tahoma", Font.BOLD, 14));
		themKHButtonTK.setBackground(new Color(0, 102, 0));
		themKHButtonTK.addActionListener(control);
		themKHButtonTK.setBounds(1049, 25, 122, 29);
		panelTK.add(themKHButtonTK);
		
		xoaButtonTK = new JButton("Xóa");
		xoaButtonTK.setForeground(new Color(255, 255, 255));
		xoaButtonTK.setFont(new Font("Tahoma", Font.BOLD, 14));
		xoaButtonTK.setBackground(new Color(0, 102, 0));
		xoaButtonTK.setBounds(1049, 82, 122, 29);
		xoaButtonTK.addActionListener(control);
		panelTK.add(xoaButtonTK);
		
		suaButtonTK = new JButton("Sửa");
		suaButtonTK.setFont(new Font("Tahoma", Font.BOLD, 14));
		suaButtonTK.setForeground(new Color(255, 255, 255));
		suaButtonTK.setBackground(new Color(0, 102, 0));
		suaButtonTK.setBounds(1049, 128, 122, 29);
		suaButtonTK.addActionListener(control);
		panelTK.add(suaButtonTK);
	}
	
	public void doanhThu() {
		contentPane.removeAll();
		init();
		JTabbedPane tabbedPaneDT = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneDT.setBackground(new Color(255, 255, 255));
		tabbedPaneDT.setBounds(0, 49, 1186, 579);
		tabbedPaneDT.setFont(new Font("Arial", Font.BOLD, 14));
		contentPane.add(tabbedPaneDT);
		tableModelDT = new DefaultTableModel();
		tableModelDT.addColumn("Ngày");
		tableModelDT.addColumn("Tổng doanh thu");
		
		
		JPanel panelDT = new JPanel();
		panelDT.setBackground(new Color(255, 255, 255));
		tabbedPaneDT.addTab("Doanh thu", null, panelDT, null);
		panelDT.setLayout(null);
		DTTable = new JTable(tableModelDT);
		DTTable.setBackground(new Color(255, 255, 255));
		DTTable.setFont(new Font("Arial", Font.PLAIN, 10));
		DTTable.setBounds(0, 0, 1140, 503);
		panelDT.add(DTTable);
		JScrollPane scrollPane2 = new JScrollPane(DTTable);
		scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panelDT.add(scrollPane2);
		scrollPane2.setBounds(0, 0, 1039, 548);
		
		
	}
	
	public void nhaCungCap() {
		contentPane.removeAll();

		init();
		JTabbedPane tabbedPaneNCC = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneNCC.setBackground(new Color(255, 255, 255));
		tabbedPaneNCC.setBounds(0, 49, 1186, 579);
		tabbedPaneNCC.setFont(new Font("Arial", Font.BOLD, 14));
		contentPane.add(tabbedPaneNCC);
		tableModelNCC = new DefaultTableModel();
		tableModelNCC.addColumn("Mã nhà cung cấp");
		tableModelNCC.addColumn("Tên nhà cung cấp");
		
		JPanel panelNCC = new JPanel();
		panelNCC.setBackground(new Color(255, 255, 255));
		tabbedPaneNCC.addTab("Thống kê sách", null, panelNCC, null);
		panelNCC.setLayout(null);
		NCCTable = new JTable(tableModelNCC);
		NCCTable.setBackground(new Color(255, 255, 255));
		NCCTable.setFont(new Font("Arial", Font.PLAIN, 10));
		NCCTable.setBounds(0, 0, 1140, 503);
		panelNCC.add(NCCTable);
		JScrollPane scrollPane2 = new JScrollPane(NCCTable);
		scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panelNCC.add(scrollPane2);
		scrollPane2.setBounds(0, 0, 1039, 548);
		
		themButtonNCC = new JButton("Thêm");
		themButtonNCC.setForeground(new Color(255, 255, 255));
		themButtonNCC.setFont(new Font("Tahoma", Font.BOLD, 14));
		themButtonNCC.setBackground(new Color(0, 102, 0));
		themButtonNCC.addActionListener(control);
		themButtonNCC.setBounds(1049, 25, 122, 29);
		panelNCC.add(themButtonNCC);
		
		xoaButtonNCC = new JButton("Xóa");
		xoaButtonNCC.setForeground(new Color(255, 255, 255));
		xoaButtonNCC.setFont(new Font("Tahoma", Font.BOLD, 14));
		xoaButtonNCC.setBackground(new Color(0, 102, 0));
		xoaButtonNCC.setBounds(1049, 82, 122, 29);
		xoaButtonNCC.addActionListener(control);
		panelNCC.add(xoaButtonNCC);
		
		suaButtonNCC = new JButton("Sửa");
		suaButtonNCC.setFont(new Font("Tahoma", Font.BOLD, 14));
		suaButtonNCC.setForeground(new Color(255, 255, 255));
		suaButtonNCC.setBackground(new Color(0, 102, 0));
		suaButtonNCC.setBounds(1049, 128, 122, 29);
		suaButtonNCC.addActionListener(control);
		panelNCC.add(suaButtonNCC);
	
	}
	
	public void lichSuDangNhap() {
	    contentPane.removeAll();

	    init(); // Đảm bảo phương thức này được định nghĩa ở nơi khác và hoạt động đúng cách

	    JTabbedPane tabbedPaneLSDN = new JTabbedPane(JTabbedPane.TOP);
	    tabbedPaneLSDN.setBackground(new Color(255, 255, 255));
	    tabbedPaneLSDN.setBounds(0, 49, 1186, 579);
	    tabbedPaneLSDN.setFont(new Font("Arial", Font.BOLD, 14));
	    contentPane.add(tabbedPaneLSDN);

	    tableModelLSDN = new DefaultTableModel();
	    tableModelLSDN.addColumn("Thời gian");
	    tableModelLSDN.addColumn("Mã Nhân Viên");

	    JTable LSDNTable = new JTable(tableModelLSDN);
	    LSDNTable.setBackground(new Color(255, 255, 255));
	    LSDNTable.setFont(new Font("Arial", Font.PLAIN, 10));

	    JScrollPane scrollPane2 = new JScrollPane(LSDNTable);
	    scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	    scrollPane2.setBounds(0, 0, 1039, 548);

	    JPanel panelLSDN = new JPanel();
	    panelLSDN.setLayout(null);
	    panelLSDN.setBackground(new Color(255, 255, 255));
	    panelLSDN.add(scrollPane2);

	    tabbedPaneLSDN.addTab("Thống kê sách", null, panelLSDN, null);

	    contentPane.revalidate();
	    contentPane.repaint();
	}

	
	
	
	
	public JButton getThemKHButtonSach() {
		return themKHButtonSach;
	}
	
	public JButton getXoaKHButtonSach() {
        return xoaKHButtonSach;
    }
	public JTable getHoaDonTable1() {
		return hoaDonTable_1;
	}
	public JButton getSuaKHButtonSach() {
		return suaKHButtonSach;
	}
	public DefaultTableModel getTableModelKH() {
		return tableModelKH;
	}
	public JTable getTableKH() {
		return KHTable;
	}
	public JButton getThemKHButton() {
		return themKHButton;
	}
	
	public JButton getXoaKHButton() {
		return xoaKHButton;
	}
	
	public JButton getSuaKHButton() {
		return suaKHButton;
	}
	
	public JLabel getTongTienALl() {
		return tongTienAll;
	}
	public JTable getSachTable() {
		return SachTable;
	}
	
	
	public JTable getsachTable() {
		return sachTable;
	}
	
	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public JSpinner getSpinner() {
		return spinner;
	}

	public DefaultTableModel getTableModel1() {
		return tableModel1;
	}
	
	public void addThemButtonListener(ActionListener listener) {
		themButton.addActionListener(listener);
	}
	
	public void addDangNhapButtonListener(ActionListener actionListener) {
		dangNhapButton.addActionListener(actionListener);
	}
	
	public JButton getDangNhapButton() {
		return dangNhapButton;
	}

	public String getMaNV() {
        return this.dangNhap.getText();
    }
	
	public String getMatKhau() {
	    return new String(this.passWord.getPassword());
	}
	
	public JButton getThemButton() {
		return themButton;
	}
	
	public String getCombobox() {
		return comboBox.getSelectedItem().toString();
	}
	
	public JMenuItem getAllKhachHang() {
		return allKhachHang;
	}
	
	public JButton getdongYButton() {
		return dongYButton;
    }
	
	public JTable getHoaDonTable() {
		return hoaDonTable_1;
	}
	
	public JTextField getSdtKH() {
		return textField;
	}
	
	public JMenuItem getTrangChuMenuItem() {
		return trangChuMenuItem;
	}
	
	public JMenuItem getThongKeSachItem() {
		return thongKeSachItem;
	}
	
	public DefaultTableModel getTableModelSach() {
		return tableModelSach;
	}
	
	public JTable getTableSach() {
        return SachTable;
    }
	
	public JButton getThemButtonNV() {
		return themKHButtonNV;
	}
	
	public JButton getXoaButtonNV() {
		return xoaButtonNV;
	}
	
	public JButton getSuaButtonNV() {
		return suaButtonNV;
	}
	
	public JTable getTableNV() {
		return NVTable;
	}
	
	public DefaultTableModel getTableModelNV() {
		return tableModelNV;
	}
	
	public JMenuItem getAllNV() {
		return allNV;
	}
	
	public JMenuItem getLichSu() {
		return lichSu;
	}
	
	public JTable getLSTable() {
		return LSTable;
	}
	
	public DefaultTableModel getTableModelLS() {
		return tableModelLS;
	}
	
	public JButton getchiTiet() {
		return chiTiet;
	}
	
	public JTable getCTTable() {
		return CTTable;
	}
	
	public DefaultTableModel getTableModelCT() {
		return tableModelCT;
	}
	
	public JButton getQuayLai() {
		return quayLai;
	}
	
	public JMenuItem getTKAll() {
		return TKAll;
	}
	
	public JTable getTKTable() {
		return TKTable;
	}
	
	public DefaultTableModel getTableModelTK() {
		return tableModelTK;
	}

	public JButton getThemButtonTK() {
		return themKHButtonTK;
	}
	
	public JButton getXoaButtonTK() {
		return xoaButtonTK;
	}
	
	public JButton getSuaButtonTK() {
		return suaButtonTK;
	}
	
	public JMenu getTKMenu() {
		return TKMenu;
	}
	
	public JMenu getNVMenu() {
		return NVMenu;
	}
	
	public JMenu getLSMenu() {
		return HDMenu;
	}
	
	public JMenu getKhachHangMenu() {
		return khachHangMenu;
	}
	
	public JMenu getSachMenu() {
		return mnNewMenu_2;
	}
	
	public JMenu getthanhToanMenu() {
		return trangChu;
	}
	
	public JButton getXoaHDButton() {
		return xoaHDButton;
	}
	
	public JButton getChiTietDT() {
		return chiTietDT;
	}
	
	public JTable getDTTable() {
		return DTTable;
	}

	public DefaultTableModel getTableModelDT() {
		return tableModelDT;
	}
	
	public JMenuItem getDTAll() {
		return DTAll;
	}
	
	public JMenuItem getDTAllThang() {
		return DTAllThang;
	}
	
	public JMenuItem getDTAllNam() {
		return DTAllNam;
	}
	
	public JTextField getSearchField() {
		return searchField;
	}
	
	public JButton getSearchButton() {
		return searchButton;
	}

	public JMenu getDoanhThuMenu() {
		return doanhThuMenu;
	}
	
	public JTable getNCCTable() {
		return NCCTable;
	}
	
	public DefaultTableModel getTableModelNCC() {
		return tableModelNCC;
	}
	
	public JButton getThemButtonNCC() {
		return themButtonNCC;
	}
	
	public JMenuItem getNCCAll() {
		return NCCAll;
	}
	
	
	public JButton getXoaButtonNCC() {
		return xoaButtonNCC;
	}
	
	public JButton getSuaButtonNCC() {
		return suaButtonNCC;
	}
	
	public JMenuItem getLSDN() {
		return LSDNAll;
	}
	
	public DefaultTableModel getTableModelLSDN() {
		return tableModelLSDN;
	}

	public JMenu getNCCMenu() {
		return NCCMenu;
	}

	public JMenu getLSDNMenu() {
		return LSDNMenu;
	}
	
	public JButton getDangXuatButton() {
		return dangXuatButton;
	}	
}
