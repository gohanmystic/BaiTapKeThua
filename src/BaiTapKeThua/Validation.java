package BaiTapKeThua;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Validation {
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
	
}
