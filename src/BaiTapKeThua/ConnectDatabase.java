package BaiTapKeThua;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.table.DefaultTableModel;

public class ConnectDatabase {
	private Connection conn;
	
	public void Connection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://GOHANMYSTIC:1433;databaseName=QuanLyNguoi;user=sa;password=1234";
			
			conn = DriverManager.getConnection(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	public boolean KiemTraNgay(String st) {
		if(st.length() != 10) return false;
		int vt1 = st.indexOf('/');
		int vt2 = st.indexOf('/', vt1+1);
		if(vt2 == -1) return false;
		
		try{
			SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			df.setLenient(false);
			Date d = df.parse(st);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	public void DropTable(Connection conn, String table) {
		try {
			String query = "delete from " + table;
			PreparedStatement ps = conn.prepareStatement(query);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void DocFile () {
		SinhVienDAO svDAO = new SinhVienDAO();
		NhanVienDAO nvDAO = new NhanVienDAO();
		try {
			FileInputStream FIS = new FileInputStream("data.txt");
			InputStreamReader ISR = new InputStreamReader(FIS);
			BufferedReader BRdata = new BufferedReader(ISR);
			
			Connection();
			Connection conn = this.getConn();
			
			//xoa tat ca du lieu trong bang truoc khi insert tranh bi trung ma
			DropTable(conn, "SinhVien");
			DropTable(conn, "NhanVien");
			
			while (true) {
				String data = BRdata.readLine();
				if (data == "" || data == null || data.isEmpty()) break;
				String[] ds = data.split("[;]");
				
				if (ds[0].contains("sv")){
					if(KiemTraNgay(ds[2])){// check ngay truoc khi them vao database
						// insert database
						svDAO.InsertSinhVien(conn, ds[0] , ds[1], ds[2], Boolean.parseBoolean(ds[3]), ds[4], Float.parseFloat(ds[5]), ds[6]);
					}
				}else if(ds[0].contains("nv")){
					if(KiemTraNgay(ds[2])){ // check ngay truoc khi them vao database
						// insert database
						nvDAO.InsertNhanVien(conn, ds[0] , ds[1], ds[2], Boolean.parseBoolean(ds[3]), ds[4], Float.parseFloat(ds[5]), ds[6]);
					}
				}
			}
			BRdata.close();
			conn.close();
			System.out.println("Da dua du lieu tu file vao database!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ResultSet GetDataByTableName(String tablename) {
		try {
			Connection();
			String query = "select * from " + tablename;
			PreparedStatement ps = this.conn.prepareStatement(query);
			
			return ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public DefaultTableModel GetDefaultTable(String table) {
		DefaultTableModel dtm = new DefaultTableModel();
		try{
			Connection();
			
			String query = "select * from " + table;
			
			PreparedStatement ps = this.conn.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			ResultSetMetaData rsmd = rs.getMetaData();
			int ColumnCount = rsmd.getColumnCount();
			
			for (int i = 1; i <= ColumnCount; i++) {
				dtm.addColumn(rsmd.getColumnName(i));
			}
			Object[] t = new Object[ColumnCount];
			while(rs.next()) {
				for (int i = 1; i <= ColumnCount; i++) {
					t[i-1] = rs.getString(i);
				}
				dtm.addRow(t);
			}
			
			return dtm;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
