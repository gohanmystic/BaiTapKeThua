package BaiTapKeThua;

public class SinhVien extends Person{
	private String MaSV;
	private Float dtb;
	
	public SinhVien(String maSV, String hoTen, String ngaySinh, Boolean gioiTinh, String queQuan, Float dtb, String maKhoa) {
		super(maKhoa, hoTen, ngaySinh, gioiTinh, queQuan);
		this.MaSV = maSV;
		this.dtb = dtb;
	}

	public String getMaSV() {
		return MaSV;
	}

	public void setMaSV(String maSV) {
		MaSV = maSV;
	}

	public Float getDtb() {
		return dtb;
	}

	public void setDtb(Float dtb) {
		this.dtb = dtb;
	}
	
	
}
