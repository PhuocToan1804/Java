package view;

import javax.swing.*;

import controller.Control1;

import java.awt.*;

public class CustomerForm extends JFrame {
	private JTextField txtbookid;
	private JTextField txtCustomerName;
	private JTextField txtbookname;
	private JTextField txttheloai;
	private JTextField txtNXB;
	private JTextField txtNamXB;
	private JTextField txtMaNCC;
	private JTextField txtTG;
	private JTextField txtSL;
	private JTextField txtG;
	private JButton btnSave;
	private JButton btnCancel;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private Control1 control;

	public CustomerForm() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("Thêm sách");
		setSize(457, 702);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JLabel lblbookId = new JLabel("Mã sách:");
		lblbookId.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblbookId.setBounds(68, 78, 94, 24);
		txtbookid = new JTextField();
		txtbookid.setBounds(68, 101, 321, 31);

		JLabel lblbookName = new JLabel("Tên sách:");
		lblbookName.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblbookName.setBounds(68, 130, 114, 25);
		txtbookname = new JTextField();
		txtbookname.setBounds(68, 154, 321, 31);

		JLabel lbtheloai = new JLabel("Thể loại:");
		lbtheloai.setFont(new Font("Tahoma", Font.BOLD, 19));
		lbtheloai.setBounds(68, 186, 114, 24);
		txttheloai = new JTextField();
		txttheloai.setBounds(68, 209, 321, 31);

		JLabel lblTG = new JLabel("Tác giả:");
		lblTG.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblTG.setBounds(68, 403, 114, 31);
		txtTG = new JTextField();
		txtTG.setBounds(68, 432, 321, 31);

		JLabel lblNXB = new JLabel("Nhà xuất bản:");
		lblNXB.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNXB.setBounds(68, 240, 144, 24);
		txtNXB = new JTextField();
		txtNXB.setBounds(68, 264, 321, 31);

		JLabel lblNamXB = new JLabel("Năm xuất bản:");
		lblNamXB.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNamXB.setBounds(67, 293, 142, 24);
		txtNamXB = new JTextField();
		txtNamXB.setBounds(68, 317, 321, 31);

		JLabel lblMaNCC = new JLabel("Nhà cung cấp:");
		lblMaNCC.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblMaNCC.setBounds(68, 344, 184, 31);
		txtMaNCC = new JTextField();
		txtMaNCC.setBounds(68, 375, 321, 31);

		JLabel lblSL = new JLabel("Số lượng:");
		lblSL.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblSL.setBounds(68, 460, 114, 31);
		txtSL = new JTextField();
		txtSL.setBounds(68, 489, 321, 31);
		JLabel lblG = new JLabel("Giá:");
		lblG.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblG.setBounds(68, 519, 114, 24);
		txtG = new JTextField();
		txtG.setBounds(68, 546, 321, 31);

		btnSave = new JButton("Lưu");
		btnSave.setForeground(new Color(255, 255, 255));
		btnSave.setBackground(new Color(0, 102, 51));
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSave.setBounds(71, 595, 114, 41);
		btnSave.addActionListener(control);
		btnCancel = new JButton("Hủy");
		btnCancel.setForeground(new Color(255, 255, 255));
		btnCancel.setBackground(new Color(0, 102, 51));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCancel.setBounds(249, 595, 114, 41);
		getContentPane().setLayout(null);

		getContentPane().add(lblbookId);
		getContentPane().add(txtbookid);
		getContentPane().add(lblbookName);
		getContentPane().add(txtbookname);
		getContentPane().add(lbtheloai);
		getContentPane().add(txttheloai);
		getContentPane().add(lblTG);
		getContentPane().add(txtTG);
		getContentPane().add(lblNXB);
		getContentPane().add(txtNXB);
		getContentPane().add(lblNamXB);
		getContentPane().add(txtNamXB);
		getContentPane().add(lblMaNCC);
		getContentPane().add(txtMaNCC);
		getContentPane().add(lblSL);
		getContentPane().add(txtSL);
		getContentPane().add(lblG);
		getContentPane().add(txtG);

		getContentPane().add(btnSave);
		getContentPane().add(btnCancel);

		panel = new JPanel();
		panel.setBackground(new Color(0, 102, 0));
		panel.setBounds(0, 0, 443, 57);
		getContentPane().add(panel);
		panel.setLayout(null);

		lblNewLabel = new JLabel("NHÀ SÁCH HI VỌNG");
		lblNewLabel.setBounds(82, 10, 282, 34);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setBackground(new Color(51, 102, 0));
		panel.add(lblNewLabel);

		btnCancel.addActionListener(e -> dispose());
	}

	public JTextField getBookID() {
		return txtbookid;
	}

	public JTextField getBookName() {
		return txtbookname;
	}

	public JTextField getBookTheLoai() {
		return txttheloai;
	}

	public JTextField getBookTG() {
		return txtTG;
	}

	public JTextField getBookNXB() {
		return txtNXB;
	}

	public JTextField getBookNamXB() {
		return txtNamXB;
	}

	public JTextField getBookNCC() {
		return txtMaNCC;
	}

	public JTextField getBookSL() {
		return txtSL;
	}

	public JTextField getBookG() {
		return txtG;
	}

	public JButton getBtnSave() {
		return btnSave;
	}
}
