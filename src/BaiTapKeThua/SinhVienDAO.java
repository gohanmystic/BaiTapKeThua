package BaiTapKeThua;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SinhVienDAO {
	public void InsertSinhVien(Connection conn, String masv, String hoten, String ngaysinh, boolean gioitinh, String quequan, Float dtb, String makhoa) {
		try {
			
			String query = "insert into SinhVien values(?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, masv);
			ps.setString(2, hoten);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			Date dateUtil = sdf.parse(ngaysinh);
			java.sql.Date dateSql = new java.sql.Date(dateUtil.getTime());
			ps.setDate(3, dateSql);
			ps.setBoolean(4, gioitinh);
			ps.setString(5, quequan);
			ps.setFloat(6, dtb);
			ps.setString(7, makhoa);
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<SinhVien> getSinhVienFromDatabase() {
		try{
			ArrayList<SinhVien> ds = new ArrayList<>();
			ConnectDatabase conn = new ConnectDatabase();
			
			ResultSet rs = conn.GetDataByTableName("SinhVien");
			
			while(rs.next()) {
				if(rs.getString(1).contains("sv")) {
					SinhVien sv = new SinhVien(rs.getString(1), rs.getString(2), rs.getDate(3).toString(), rs.getBoolean(4), rs.getString(5), rs.getFloat(6), rs.getString(7));
					ds.add(sv);
				}
			}
			rs.close();
			conn.getConn().close();
			
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
