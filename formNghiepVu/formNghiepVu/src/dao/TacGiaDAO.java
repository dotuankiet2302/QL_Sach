package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import pojo.TacGia;

public class TacGiaDAO {

    public static ArrayList<TacGia> hienThiDanhSachTacGia(String strUserName, String strPass) {
        ArrayList<TacGia> danhSachTacGia = new ArrayList<>();
        SQLServerDataProvider provider = new SQLServerDataProvider();
        
        try {
            // Mở kết nối đến cơ sở dữ liệu
            provider.ketnoi(strUserName, strPass);
            
            String sqlSelect = "SELECT * FROM TacGia"; 
            ResultSet resultSet = provider.executeQuery(sqlSelect);
            
            while (resultSet.next()) {
                TacGia tacGia = new TacGia();
                tacGia.setMaTacGia(resultSet.getInt("MaTacGia"));
                tacGia.setTenTacGia(resultSet.getString("TenTacGia"));
                tacGia.setDiaChi(resultSet.getString("DiaChi"));
                tacGia.setDienThoai(resultSet.getString("DienThoai"));
                tacGia.setTieuSu(resultSet.getString("TieuSu")); // Lấy tiểu sử từ cơ sở dữ liệu
                danhSachTacGia.add(tacGia);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
          
        }
        
        return danhSachTacGia;
    }

    public static ArrayList<TacGia> timKiemTacGiaTheoTen(String strUserName, String strPass, String tenTacGiaTimKiem) {
        ArrayList<TacGia> danhSachTacGia = new ArrayList<>();
        SQLServerDataProvider provider = new SQLServerDataProvider();
        
        try {
            // Mở kết nối đến cơ sở dữ liệu
            provider.ketnoi(strUserName, strPass);
            
            // Sử dụng LIKE để tìm kiếm tên tác giả gần đúng
            String sqlSelect = "SELECT * FROM TacGia WHERE TenTacGia LIKE ?";
            PreparedStatement preparedStatement = provider.prepareStatement(sqlSelect);
            preparedStatement.setString(1, "%" + tenTacGiaTimKiem + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                TacGia tacGia = new TacGia();
                tacGia.setMaTacGia(resultSet.getInt("MaTacGia"));
                tacGia.setTenTacGia(resultSet.getString("TenTacGia"));
                tacGia.setDiaChi(resultSet.getString("DiaChi"));
                tacGia.setDienThoai(resultSet.getString("DienThoai"));
                tacGia.setTieuSu(resultSet.getString("TieuSu")); // Lấy tiểu sử từ cơ sở dữ liệu
                danhSachTacGia.add(tacGia);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           
        }
        
        return danhSachTacGia;
    }
      public static boolean themTacGia(String strUserName, String strPass, TacGia tacGia) {
        SQLServerDataProvider provider = new SQLServerDataProvider();
        
        try {
            provider.ketnoi(strUserName, strPass);
            String sqlInsert = "INSERT INTO TacGia (TenTacGia, DiaChi, DienThoai, TieuSu) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = provider.prepareStatement(sqlInsert);
            preparedStatement.setString(1, tacGia.getTenTacGia());
            preparedStatement.setString(2, tacGia.getDiaChi());
            preparedStatement.setString(3, tacGia.getDienThoai());
            preparedStatement.setString(4, tacGia.getTieuSu());
            
            int result = preparedStatement.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           
        }
        
        return false;
    }
      public static boolean capNhatTacGia(String strUserName, String strPass, TacGia tacGia) {
    SQLServerDataProvider provider = new SQLServerDataProvider();
    
    try {
        provider.ketnoi(strUserName, strPass);
        String sqlUpdate = "UPDATE TacGia SET TenTacGia = ?, DiaChi = ?, DienThoai = ?, TieuSu = ? WHERE MaTacGia = ?";
        PreparedStatement preparedStatement = provider.prepareStatement(sqlUpdate);
        preparedStatement.setString(1, tacGia.getTenTacGia());
        preparedStatement.setString(2, tacGia.getDiaChi());
        preparedStatement.setString(3, tacGia.getDienThoai());
        preparedStatement.setString(4, tacGia.getTieuSu());
        preparedStatement.setInt(5, tacGia.getMaTacGia());
        
        int result = preparedStatement.executeUpdate();
        return result > 0;
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
       
    }
    
    return false;
}
             
      public static boolean xoaTacGia(String strUserName, String strPass, int maTacGia) {
        SQLServerDataProvider provider = new SQLServerDataProvider();
        
        try {
            provider.ketnoi(strUserName, strPass);
            String sqlDelete = "DELETE FROM TacGia WHERE MaTacGia = ?";
            PreparedStatement preparedStatement = provider.prepareStatement(sqlDelete);
            preparedStatement.setInt(1, maTacGia);
            
            int result = preparedStatement.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối và tài nguyên khác nếu cần
        }
        
        return false;
    }
      
      
      
      

}
