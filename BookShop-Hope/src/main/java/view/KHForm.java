package view;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;

public class KHForm extends JFrame {
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

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public KHForm() {
		getContentPane().setBackground(new Color(255, 255, 255));
		 setTitle("Thêm sách");
	        setSize(457, 398);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	        JLabel lblbookId = new JLabel("SDT :");
	        lblbookId.setFont(new Font("Tahoma", Font.BOLD, 19));
	        lblbookId.setBounds(68, 78, 94, 24);
	        txtbookid = new JTextField();
	        txtbookid.setBounds(68, 101, 321, 31);

	        JLabel lblbookName = new JLabel("Tổng tiền đã mua:");
	        lblbookName.setFont(new Font("Tahoma", Font.BOLD, 19));
	        lblbookName.setBounds(68, 130, 114, 25);
	        txtbookname = new JTextField();
	        txtbookname.setBounds(68, 154, 321, 31);

	        JLabel lbtheloai = new JLabel("Thân thiết:");
	        lbtheloai.setFont(new Font("Tahoma", Font.BOLD, 19));
	        lbtheloai.setBounds(68, 186, 114, 24);
	        txttheloai = new JTextField();
	        txttheloai.setBounds(68, 209, 321, 31);

	        
	        btnSave = new JButton("Lưu");
	        btnSave.setForeground(new Color(255, 255, 255));
	        btnSave.setBackground(new Color(0, 102, 51));
	        btnSave.setFont(new Font("Tahoma", Font.BOLD, 16));
	        btnSave.setBounds(68, 293, 114, 41);
	        btnCancel = new JButton("Hủy");
	        btnCancel.setForeground(new Color(255, 255, 255));
	        btnCancel.setBackground(new Color(0, 102, 51));
	        btnCancel.setFont(new Font("Tahoma", Font.BOLD, 16));
	        btnCancel.setBounds(237, 293, 114, 41);
	        getContentPane().setLayout(null);

	        getContentPane().add(lblbookId);
	        getContentPane().add(txtbookid);
	        getContentPane().add(lblbookName);
	        getContentPane().add(txtbookname);
	        getContentPane().add(lbtheloai);
	        getContentPane().add(txttheloai);
	        
	      
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


