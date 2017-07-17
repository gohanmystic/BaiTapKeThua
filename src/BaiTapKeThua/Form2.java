package BaiTapKeThua;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Label;
import java.awt.Choice;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Set;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Form2 extends JFrame {

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
					Form2 frame = new Form2();
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
	public Form2() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Label label = new Label("Chon 1 khoa");
		label.setBounds(10, 10, 83, 22);
		contentPane.add(label);

		Choice choiceKhoa = new Choice();

		choiceKhoa.setBounds(109, 10, 117, 20);
		contentPane.add(choiceKhoa);

		Label label_1 = new Label("Chon 1 loai");
		label_1.setBounds(10, 43, 83, 22);
		contentPane.add(label_1);

		Choice choiceLoai = new Choice();

		choiceLoai.setBounds(109, 45, 117, 20);
		contentPane.add(choiceLoai);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 85, 414, 165);
		contentPane.add(tabbedPane);

		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("New tab", null, scrollPane, null);

		table = new JTable();
		scrollPane.setViewportView(table);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				KhoaDAO khoa = new KhoaDAO();
				Set<Khoa> dskhoa = khoa.getKhoa();
				for (Khoa k : dskhoa) {
					choiceKhoa.add(k.getMaKhoa());
				}

				choiceLoai.add("Sinh Vien");
				choiceLoai.add("Nhan Vien");
				SetDataTable(choiceKhoa.getSelectedItem(), choiceLoai.getSelectedItem());
				setData();
			}
		});

		choiceKhoa.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				SetDataTable(choiceKhoa.getSelectedItem(), choiceLoai.getSelectedItem());
			}
		});

		choiceLoai.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				SetDataTable(choiceKhoa.getSelectedItem(), choiceLoai.getSelectedItem());
			}
		});
	}

	public void setData() {
		SinhVienDAO svDAO = new SinhVienDAO();
		dssv = svDAO.getSinhVienFromDatabase();
		NhanVienDAO nvDAO = new NhanVienDAO();
		dsnv = nvDAO.getNhanVienFromDatabase();
	}

	public void SetDataTable(String khoa, String ma) {

		if (ma.equalsIgnoreCase("sinh vien")) {
			DefaultTableModel df = new DefaultTableModel();
			df.addColumn("Ma Sinh Vien");
			df.addColumn("Ho Ten");
			df.addColumn("Ngay Sinh");
			df.addColumn("Gioi Tinh");
			df.addColumn("Que Quan");
			df.addColumn("DTB");
			Object[] dSV = new Object[6];

			for (SinhVien sv : dssv) {
				if (sv.getMaKhoa().equalsIgnoreCase(khoa)) {
					dSV[0] = sv.getMaSV();
					dSV[1] = sv.getHoTen();
					dSV[2] = sv.getNgaySinh();
					dSV[3] = sv.getGioiTinh();
					dSV[4] = sv.getQueQuan();
					dSV[5] = sv.getDtb();
					df.addRow(dSV);
				}
				table.setModel(df);
			}

		} else if (ma.equalsIgnoreCase("Nhan Vien")) {
			DefaultTableModel df = new DefaultTableModel();
			df.addColumn("Ma Nhan Vien");
			df.addColumn("Ho Ten");
			df.addColumn("Ngay Sinh");
			df.addColumn("Gioi Tinh");
			df.addColumn("Que Quan");
			df.addColumn("Luong");
			Object[] dNV = new Object[6];

			for (NhanVien nv : dsnv) {
				if (nv.getMaKhoa().equalsIgnoreCase(khoa)) {
					dNV[0] = nv.getMaNV();
					dNV[1] = nv.getHoTen();
					dNV[2] = nv.getNgaySinh();
					dNV[3] = nv.getGioiTinh();
					dNV[4] = nv.getQueQuan();
					dNV[5] = nv.getHSL();
					df.addRow(dNV);
				}
				table.setModel(df);
			}
		}
	}
}
