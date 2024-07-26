package pojo;

public class TacGia {
    private int maTacGia;
    private String tenTacGia;
    private String diaChi;
    private String dienThoai;
    private String tieuSu; // Trường tiểu sử của tác giả
    
    public TacGia() {
    }
    
    // Constructor
    public TacGia(int maTacGia, String tenTacGia, String diaChi, String dienThoai, String tieuSu) {
        this.maTacGia = maTacGia;
        this.tenTacGia = tenTacGia;
        this.diaChi = diaChi;
        this.dienThoai = dienThoai;
        this.tieuSu = tieuSu;
    }
    
    // Getters and Setters
    public int getMaTacGia() {
        return maTacGia;
    }

    public void setMaTacGia(int maTacGia) {
        this.maTacGia = maTacGia;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }
    
    public String getTieuSu() {
        return tieuSu;
    }

    public void setTieuSu(String tieuSu) {
        this.tieuSu = tieuSu;
    }

    // toString method
    @Override
    public String toString() {
        return "TacGia{" +
                "maTacGia=" + maTacGia +
                ", tenTacGia='" + tenTacGia + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", dienThoai='" + dienThoai + '\'' +
                ", tieuSu='" + tieuSu + '\'' +
                '}';
    }
}
