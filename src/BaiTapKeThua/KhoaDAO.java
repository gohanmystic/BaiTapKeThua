package BaiTapKeThua;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class KhoaDAO {
	public Set<Khoa> dsKhoa = new TreeSet<>(new Comparator<Khoa>() {

		@Override
		public int compare(Khoa o1, Khoa o2) {
			return o1.getMaKhoa().compareToIgnoreCase(o2.getMaKhoa());
		}
	});

	public Set<Khoa> getKhoa() {
		try{
			ConnectDatabase connDB = new ConnectDatabase();
			
			ResultSet rs = connDB.GetDataByTableName("Khoa");
			
			while (rs.next()) {
				Khoa khoa = new Khoa(rs.getString(1));
				dsKhoa.add(khoa);
			}
			rs.close();
			connDB.getConn().close();
			return this.dsKhoa;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
