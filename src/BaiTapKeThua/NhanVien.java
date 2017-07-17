package BaiTapKeThua;

public class NhanVien extends Person{
	private String MaNV;
	private Float HSL;
	
	public NhanVien(String maNV, String hoTen, String ngaySinh, Boolean gioiTinh, String queQuan, Float hSL, String maKhoa) {
		
		super(maKhoa, hoTen, ngaySinh, gioiTinh, queQuan);
		MaNV = maNV;
		HSL = hSL;
	}

	public String getMaNV() {
		return MaNV;
	}

	public void setMaNV(String maNV) {
		MaNV = maNV;
	}

	public Float getHSL() {
		return HSL;
	}

	public void setHSL(Float hSL) {
		HSL = hSL;
	}
	
}
