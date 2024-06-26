package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.Control1;
import java.awt.event.ActionListener;

public class TKForm extends JFrame {
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
private JPanel panel;
private JLabel lblNewLabel;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
private Control1 control;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TKForm frame = new TKForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TKForm() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("Thêm sách");
		setSize(457, 406);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JLabel lblbookId = new JLabel("Mã tài khoản:");
		lblbookId.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblbookId.setBounds(68, 78, 198, 24);
		txtbookid = new JTextField();
		txtbookid.setBounds(68, 101, 321, 31);

		JLabel lblbookName = new JLabel("Mật khẩu:");
		lblbookName.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblbookName.setBounds(68, 130, 114, 25);
		txtbookname = new JTextField();
		txtbookname.setBounds(68, 154, 321, 31);

		JLabel lbtheloai = new JLabel("Loại tài khoản:");
		lbtheloai.setFont(new Font("Tahoma", Font.BOLD, 19));
		lbtheloai.setBounds(68, 186, 214, 24);
		txttheloai = new JTextField();
		txttheloai.setBounds(68, 209, 321, 31);


		btnSave = new JButton("Lưu");
		btnSave.setForeground(new Color(255, 255, 255));
		btnSave.setBackground(new Color(0, 102, 51));
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSave.setBounds(68, 291, 114, 41);
		btnSave.addActionListener(control);
		btnCancel = new JButton("Hủy");
		btnCancel.setForeground(new Color(255, 255, 255));
		btnCancel.setBackground(new Color(0, 102, 51));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCancel.setBounds(249, 291, 114, 41);
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