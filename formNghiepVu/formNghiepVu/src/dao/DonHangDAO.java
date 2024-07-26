package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import pojo.DonHang;

public class DonHangDAO {

    public static ArrayList<DonHang> hienThiDanhSachDonHang(String strUserName, String strPass) {
        ArrayList<DonHang> danhSachDonHang = new ArrayList<>();
        SQLServerDataProvider provider = new SQLServerDataProvider();
        
        try {
            // Mở kết nối đến cơ sở dữ liệu
            provider.ketnoi(strUserName, strPass);
            
            String sqlSelect = "SELECT * FROM DonHang"; // Chọn tất cả các cột từ bảng DonHang
            ResultSet resultSet = provider.executeQuery(sqlSelect);
            
            while (resultSet.next()) {
                DonHang donHang = new DonHang();
                donHang.setMaDonHang(resultSet.getInt("MaDonHang"));
                donHang.setNgayGiao(resultSet.getDate("NgayGiao"));
                donHang.setNgayDat(resultSet.getDate("NgayDat"));
                donHang.setDaThanhToan(resultSet.getString("DaThanhToan"));
                donHang.setTinhTrangGiaoHang(resultSet.getInt("TinhTrangGiaoHang"));
                donHang.setMaKH(resultSet.getInt("MaKH"));
                danhSachDonHang.add(donHang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối
   
        }
        
        return danhSachDonHang;
    }

    public static boolean themDonHang(DonHang donHang, String strUserName, String strPass) {
        boolean success = false;
        SQLServerDataProvider provider = new SQLServerDataProvider();

        try {
            // Mở kết nối đến cơ sở dữ liệu
            provider.ketnoi(strUserName, strPass);

            String sqlInsert = "INSERT INTO DonHang (NgayGiao, NgayDat, DaThanhToan, TinhTrangGiaoHang, MaKH) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = provider.prepareStatement(sqlInsert);
            preparedStatement.setDate(1, new java.sql.Date(donHang.getNgayGiao().getTime()));
            preparedStatement.setDate(2, new java.sql.Date(donHang.getNgayDat().getTime()));
            preparedStatement.setString(3, donHang.getDaThanhToan());
            preparedStatement.setInt(4, donHang.getTinhTrangGiaoHang());
            preparedStatement.setInt(5, donHang.getMaKH());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                success = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối
            provider.Close();
        }

        return success;
    }
    public static boolean xoaDonHang(int maDonHang, String strUserName, String strPass) {
    boolean success = false;
    SQLServerDataProvider provider = new SQLServerDataProvider();

    try {
        // Mở kết nối đến cơ sở dữ liệu
        provider.ketnoi(strUserName, strPass);

        String sqlDelete = "DELETE FROM DonHang WHERE MaDonHang = ?";
        PreparedStatement preparedStatement = provider.prepareStatement(sqlDelete);
        preparedStatement.setInt(1, maDonHang);

        int rowsAffected = preparedStatement.executeUpdate();

        if (rowsAffected > 0) {
            success = true;
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        // Đóng kết nối
        provider.Close();
    }

    return success;
}

}
