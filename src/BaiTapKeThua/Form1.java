package BaiTapKeThua;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Choice;
import java.awt.Label;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Form1 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public ArrayList<SinhVien> dssv = new ArrayList<>();
	public ArrayList<NhanVien> dsnv = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form1 frame = new Form1();
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
	public Form1() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Choice choice = new Choice();

		choice.setBounds(94, 10, 154, 20);
		contentPane.add(choice);

		Label label = new Label("Chon 1 loai");
		label.setBounds(10, 8, 62, 22);
		contentPane.add(label);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 57, 414, 193);
		contentPane.add(tabbedPane);

		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("New tab", null, scrollPane, null);

		table = new JTable();
		scrollPane.setViewportView(table);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				setData();
				choice.add("SinhVien");
				choice.add("NhanVien");

				SetDataTable(choice.getSelectedItem());
			}
		});

		choice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				SetDataTable(choice.getSelectedItem());
			}
		});

	}

	public void setData() {
		SinhVienDAO svDAO = new SinhVienDAO();
		dssv = svDAO.getSinhVienFromDatabase();
		NhanVienDAO nvDAO = new NhanVienDAO();
		dsnv = nvDAO.getNhanVienFromDatabase();
	}

	/*public void SetDataTable(String ma) {
		if (ma.equalsIgnoreCase("sinh vien")) {
			DefaultTableModel df = new DefaultTableModel();
			df.addColumn("Ma Sinh Vien");
			df.addColumn("Ho Ten");
			df.addColumn("Ngay Sinh");
			df.addColumn("Gioi Tinh");
			df.addColumn("Que Quan");
			df.addColumn("DTB");
			df.addColumn("Ma Khoa");
			Object[] dSV = new Object[7];

			for (SinhVien sv : dssv) {
				dSV[0] = sv.getMaSV();
				dSV[1] = sv.getHoTen();
				dSV[2] = sv.getNgaySinh();
				dSV[3] = sv.getGioiTinh();
				dSV[4] = sv.getQueQuan();
				dSV[5] = sv.getDtb();
				dSV[6] = sv.getMaKhoa();
				df.addRow(dSV);
			}
			table.setModel(df);
		} else if (ma.equalsIgnoreCase("Nhan Vien")) {
			DefaultTableModel df = new DefaultTableModel();
			df.addColumn("Ma Nhan Vien");
			df.addColumn("Ho Ten");
			df.addColumn("Ngay Sinh");
			df.addColumn("Gioi Tinh");
			df.addColumn("Que Quan");
			df.addColumn("He So Luong");
			df.addColumn("Ma Khoa");
			Object[] dNV = new Object[7];

			for (NhanVien nv : dsnv) {
				dNV[0] = nv.getMaNV();
				dNV[1] = nv.getHoTen();
				dNV[2] = nv.getNgaySinh();
				dNV[3] = nv.getGioiTinh();
				dNV[4] = nv.getQueQuan();
				dNV[5] = nv.getHSL();
				dNV[6] = nv.getMaKhoa();
				df.addRow(dNV);
			}
			table.setModel(df);
		}
	}*/
	
	public void SetDataTable(String loai) {
		ConnectDatabase connDB = new ConnectDatabase();
		DefaultTableModel dtm = connDB.GetDefaultTable(loai);
		table.setModel(dtm);
	}
}
