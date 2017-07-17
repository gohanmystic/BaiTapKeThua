package BaiTapKeThua;
	
public abstract class Person extends Khoa{
	private String HoTen;
	private String NgaySinh;
	private Boolean GioiTinh;
	private String QueQuan;
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public String getNgaySinh() {
		return NgaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		NgaySinh = ngaySinh;
	}
	public Boolean getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(Boolean gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public String getQueQuan() {
		return QueQuan;
	}
	public void setQueQuan(String queQuan) {
		QueQuan = queQuan;
	}
	public Person(String maKhoa, String hoTen, String ngaySinh, Boolean gioiTinh, String queQuan) {
		super(maKhoa);
		HoTen = hoTen;
		NgaySinh = ngaySinh;
		GioiTinh = gioiTinh;
		QueQuan = queQuan;
	}
	
}
