/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import pojo.Sach;
/**
 *
 * @author Ther
 */
public class SachDAO {

   public static ArrayList<Sach> hienThiDanhSachSach() {
        ArrayList<Sach> lstAllSach = new ArrayList<>();
        try {
            String sqlSelect = "SELECT * FROM Sach"; // Chọn tất cả các cột từ bảng Sach
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.Open();
            ResultSet resultSet = provider.executeQuery(sqlSelect);
            while (resultSet.next()) {
                Sach sach = new Sach();
                sach.setMasach(resultSet.getInt("MaSach"));
                sach.setTensach(resultSet.getString("TenSach"));
                sach.setGiaban(resultSet.getInt("GiaBan"));
                sach.setMota(resultSet.getString("MoTa"));
                sach.setNgaycapnhat(resultSet.getDate("NgayCapNhat"));
                sach.setMaanhbia(resultSet.getString("AnhBia"));
                sach.setSoluongton(resultSet.getInt("SoLuongTon"));
                sach.setMachude(resultSet.getInt("MaChuDe"));
                sach.setManxb(resultSet.getInt("MaNXB"));
                sach.setMoi(resultSet.getInt("Moi"));

                lstAllSach.add(sach);
            }
            provider.Close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstAllSach;
    }
   
   public static int getMaxValuePriceBook() {
        int priceMax = 0;
        try {
               String sqlSelect = "SELECT MAX(GiaBan) as price FROM Sach"; 
               SQLServerDataProvider provider = new SQLServerDataProvider();
               provider.Open();
               ResultSet resultSet = provider.executeQuery(sqlSelect);
               if (resultSet.next()) {
                   // Lấy giá trị của cột "price" và gán vào biến priceMax
                   priceMax = resultSet.getInt("price");
               }
               provider.Close();
           } catch (Exception e) {
               e.printStackTrace();
           }
           return priceMax;
    }
   
   public static int getMinValuePriceBook() {
        int priceMin = 0;
        try {
               String sqlSelect = "SELECT MIN(GiaBan) as price FROM Sach"; 
               SQLServerDataProvider provider = new SQLServerDataProvider();
               provider.Open();
               ResultSet resultSet = provider.executeQuery(sqlSelect);
               if (resultSet.next()) {
                   // Lấy giá trị của cột "price" và gán vào biến priceMax
                   priceMin = resultSet.getInt("price");
               }
               provider.Close();
           } catch (Exception e) {
               e.printStackTrace();
           }
           return priceMin;
    }
   
    public static int getTotalBook() {
        int totalOfBook = 0;
        try {
               String sqlSelect = "SELECT COUNT(*) as total FROM Sach"; 
               SQLServerDataProvider provider = new SQLServerDataProvider();
               provider.Open();
               ResultSet resultSet = provider.executeQuery(sqlSelect);
               if (resultSet.next()) {
                   // Lấy giá trị của cột "price" và gán vào biến priceMax
                   totalOfBook = resultSet.getInt("total");
               }
               provider.Close();
           } catch (Exception e) {
               e.printStackTrace();
           }
           return totalOfBook;
    }
    
    public static int getTotalBookTypes() {
        int totalBookTypes = 0;
        SQLServerDataProvider provider = new SQLServerDataProvider();
        try {
            String sqlSelect = "SELECT COUNT(DISTINCT MaChuDe) as total FROM Sach"; 
            provider.Open();
            ResultSet resultSet = provider.executeQuery(sqlSelect);

            if (resultSet.next()) {
                totalBookTypes = resultSet.getInt("total");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            provider.Close();
        }
        return totalBookTypes;  
    }
    
    public static Vector getBookTypes() {
        Vector BookTypes = new Vector();
        SQLServerDataProvider provider = new SQLServerDataProvider();
        try {
            String sqlSelect = "SELECT DISTINCT MaChuDe as total FROM ChuDe"; 
            provider.Open();
            ResultSet resultSet = provider.executeQuery(sqlSelect);

            while (resultSet.next()) {
                Vector<Integer> type = new Vector<Integer>();
                type.add(resultSet.getInt("total"));
                BookTypes.add(type);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            provider.Close();
        }
        return BookTypes;  
    }
    
    public static Vector getNXBTypes() {
        Vector NXBTypes = new Vector();
        SQLServerDataProvider provider = new SQLServerDataProvider();
        try {
            String sqlSelect = "SELECT MaNXB as total FROM NhaXuatBan"; 
            provider.Open();
            ResultSet resultSet = provider.executeQuery(sqlSelect);

            while (resultSet.next()) {
                Vector<Integer> type = new Vector<Integer>();
                type.add(resultSet.getInt("total"));
                NXBTypes.add(type);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            provider.Close();
        }
        return NXBTypes;  
    }
    
    public static ArrayList<Sach> getBookByName(String nameBook) {
        ArrayList<Sach> lstBook = new ArrayList<Sach>();
        SQLServerDataProvider provider = new SQLServerDataProvider();
        try {
            String sqlSelect = String.format("SELECT * FROM Sach WHERE TenSach = N'%s'", nameBook);
            provider.Open();
            ResultSet resultSet = provider.executeQuery(sqlSelect);
            while (resultSet.next()) {
                Sach sach = new Sach();
                sach.setMasach(resultSet.getInt("MaSach"));
                sach.setTensach(resultSet.getString("TenSach"));
                sach.setGiaban(resultSet.getInt("GiaBan"));
                sach.setMota(resultSet.getString("MoTa"));
                sach.setNgaycapnhat(resultSet.getDate("NgayCapNhat"));
                sach.setMaanhbia(resultSet.getString("AnhBia"));
                sach.setSoluongton(resultSet.getInt("SoLuongTon"));
                sach.setMachude(resultSet.getInt("MaChuDe"));
                sach.setManxb(resultSet.getInt("MaNXB"));
                sach.setMoi(resultSet.getInt("Moi"));

                lstBook.add(sach);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            provider.Close();
        }
        return lstBook;  
    }
    
    public static ArrayList<Sach> getBookByAuthor(String nameAuthor) {
        ArrayList<Sach> lstBook = new ArrayList<Sach>();
        SQLServerDataProvider provider = new SQLServerDataProvider();
        try {
            String sqlSelect = "select Sach.* from  Sach\n" +
                                "join ThamGia \n" +
                                "on Sach.MaSach = ThamGia.MaSach\n" +
                                "join TacGia\n" +
                                "on ThamGia.MaTacGia = TacGia.MaTacGia\n" +
                                "where ThamGia.VaiTro = N'Tác giả' and TacGia.TenTacGia = N'%s'".formatted(nameAuthor); 
            provider.Open();
            ResultSet resultSet = provider.executeQuery(sqlSelect);

            while (resultSet.next()) {
                Sach sach = new Sach();
                sach.setMasach(resultSet.getInt("MaSach"));
                sach.setTensach(resultSet.getString("TenSach"));
                sach.setGiaban(resultSet.getInt("GiaBan"));
                sach.setMota(resultSet.getString("MoTa"));
                sach.setNgaycapnhat(resultSet.getDate("NgayCapNhat"));
                sach.setMaanhbia(resultSet.getString("AnhBia"));
                sach.setSoluongton(resultSet.getInt("SoLuongTon"));
                sach.setMachude(resultSet.getInt("MaChuDe"));
                sach.setManxb(resultSet.getInt("MaNXB"));
                sach.setMoi(resultSet.getInt("Moi"));

                lstBook.add(sach);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            provider.Close();
        }
        return lstBook;  
    }
    
    
    public static ArrayList<Sach> getBookByNXB(String idNXB) {
        ArrayList<Sach> lstBook = new ArrayList<Sach>();
        SQLServerDataProvider provider = new SQLServerDataProvider();
        try {
            String sqlSelect = "SELECT * FROM Sach where MaNXB=%s".formatted(idNXB); 
            provider.Open();
            ResultSet resultSet = provider.executeQuery(sqlSelect);

            while (resultSet.next()) {
                Sach sach = new Sach();
                sach.setMasach(resultSet.getInt("MaSach"));
                sach.setTensach(resultSet.getString("TenSach"));
                sach.setGiaban(resultSet.getInt("GiaBan"));
                sach.setMota(resultSet.getString("MoTa"));
                sach.setNgaycapnhat(resultSet.getDate("NgayCapNhat"));
                sach.setMaanhbia(resultSet.getString("AnhBia"));
                sach.setSoluongton(resultSet.getInt("SoLuongTon"));
                sach.setMachude(resultSet.getInt("MaChuDe"));
                sach.setManxb(resultSet.getInt("MaNXB"));
                sach.setMoi(resultSet.getInt("Moi"));

                lstBook.add(sach);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            provider.Close();
        }
        return lstBook;  
    }
    
    public static ArrayList<Sach> getBookByPriceAndNXB(double priceMin, double priceMax, String idNXB) {
         ArrayList<Sach> lstBook = new ArrayList<Sach>();
        SQLServerDataProvider provider = new SQLServerDataProvider();
        try {
            String sqlSelect = "select * from Sach\n" +
                                "where GiaBan >= %s and GiaBan <= %s and MaNXB=%s".formatted(priceMin, priceMax, idNXB);
            provider.Open();
            ResultSet resultSet = provider.executeQuery(sqlSelect);

            while (resultSet.next()) {
                Sach sach = new Sach();
                sach.setMasach(resultSet.getInt("MaSach"));
                sach.setTensach(resultSet.getString("TenSach"));
                sach.setGiaban(resultSet.getInt("GiaBan"));
                sach.setMota(resultSet.getString("MoTa"));
                sach.setNgaycapnhat(resultSet.getDate("NgayCapNhat"));
                sach.setMaanhbia(resultSet.getString("AnhBia"));
                sach.setSoluongton(resultSet.getInt("SoLuongTon"));
                sach.setMachude(resultSet.getInt("MaChuDe"));
                sach.setManxb(resultSet.getInt("MaNXB"));
                sach.setMoi(resultSet.getInt("Moi"));

                lstBook.add(sach);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            provider.Close();
        }
        return lstBook;  
    }
    
    
    public static ArrayList<Sach> getBookByTypes(String idTypes) {
        ArrayList<Sach> lstBook = new ArrayList<Sach>();
        SQLServerDataProvider provider = new SQLServerDataProvider();
        try {
            String sqlSelect = "SELECT * FROM Sach where MaChuDe=%s".formatted(idTypes); 
            provider.Open();
            ResultSet resultSet = provider.executeQuery(sqlSelect);

            while (resultSet.next()) {
                Sach sach = new Sach();
                sach.setMasach(resultSet.getInt("MaSach"));
                sach.setTensach(resultSet.getString("TenSach"));
                sach.setGiaban(resultSet.getInt("GiaBan"));
                sach.setMota(resultSet.getString("MoTa"));
                sach.setNgaycapnhat(resultSet.getDate("NgayCapNhat"));
                sach.setMaanhbia(resultSet.getString("AnhBia"));
                sach.setSoluongton(resultSet.getInt("SoLuongTon"));
                sach.setMachude(resultSet.getInt("MaChuDe"));
                sach.setManxb(resultSet.getInt("MaNXB"));
                sach.setMoi(resultSet.getInt("Moi"));

                lstBook.add(sach);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            provider.Close();
        }
        return lstBook;  
    }
    
    public static ArrayList<Sach> getBookById(int idBook) {
        ArrayList<Sach> lstBook = new ArrayList<Sach>();
        SQLServerDataProvider provider = new SQLServerDataProvider();
        try {
            String sqlSelect = "SELECT * FROM Sach where MaSach=%s".formatted(idBook); 
            provider.Open();
            ResultSet resultSet = provider.executeQuery(sqlSelect);

            while (resultSet.next()) {
                Sach sach = new Sach();
                sach.setMasach(resultSet.getInt("MaSach"));
                sach.setTensach(resultSet.getString("TenSach"));
                sach.setGiaban(resultSet.getInt("GiaBan"));
                sach.setMota(resultSet.getString("MoTa"));
                sach.setNgaycapnhat(resultSet.getDate("NgayCapNhat"));
                sach.setMaanhbia(resultSet.getString("AnhBia"));
                sach.setSoluongton(resultSet.getInt("SoLuongTon"));
                sach.setMachude(resultSet.getInt("MaChuDe"));
                sach.setManxb(resultSet.getInt("MaNXB"));
                sach.setMoi(resultSet.getInt("Moi"));

                lstBook.add(sach);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            provider.Close();
        }
        return lstBook;  
    }
   
       public static ArrayList<Sach> getBookByPrice(double priceMin, double priceMax) {
        ArrayList<Sach> lstBook = new ArrayList<Sach>();
        SQLServerDataProvider provider = new SQLServerDataProvider();
        try {
            String sqlSelect = "select * from Sach\n" +
                                "where GiaBan >= %s and GiaBan <= %s".formatted(priceMin, priceMax); 
            provider.Open();
            ResultSet resultSet = provider.executeQuery(sqlSelect);

            while (resultSet.next()) {
                Sach sach = new Sach();
                sach.setMasach(resultSet.getInt("MaSach"));
                sach.setTensach(resultSet.getString("TenSach"));
                sach.setGiaban(resultSet.getInt("GiaBan"));
                sach.setMota(resultSet.getString("MoTa"));
                sach.setNgaycapnhat(resultSet.getDate("NgayCapNhat"));
                sach.setMaanhbia(resultSet.getString("AnhBia"));
                sach.setSoluongton(resultSet.getInt("SoLuongTon"));
                sach.setMachude(resultSet.getInt("MaChuDe"));
                sach.setManxb(resultSet.getInt("MaNXB"));
                sach.setMoi(resultSet.getInt("Moi"));

                lstBook.add(sach);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            provider.Close();
        }
        return lstBook;  
    }
   
    
    public static int addBook(String TenSach, int GiaBan, String MoTa, String NgayCapNhat, String AnhBia, int SoLuongTon, int MaChuDe, int MaNXB, int Moi) {
        SQLServerDataProvider provider = new SQLServerDataProvider();
        try {
            String sqlSelect = "INSERT INTO Sach \n" +
                                "VALUES (N'%s', %d, N'%s', %s, N'%s', %d, %d, %d, %d)".formatted(TenSach, GiaBan, MoTa, NgayCapNhat, AnhBia, SoLuongTon, MaChuDe, MaNXB, Moi); 
            provider.Open();
            System.out.println(sqlSelect);
            int isSuccessed = provider.executeUpdate(sqlSelect);
            if(isSuccessed >= 1) {
                return 1;
            }
            return 0;
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
    
    public static int updateBook(int MaSach, String TenSach, int GiaBan, String MoTa, String NgayCapNhat, String AnhBia, int SoLuongTon, int MaChuDe, int MaNXB, int Moi) {
        SQLServerDataProvider provider = new SQLServerDataProvider();
        try {
            String sqlSelect = "UPDATE Sach \n" +
                                "SET TenSach=N'%s', GiaBan=%d, MoTa=N'%s', NgayCapNhat=N'%s', AnhBia=N'%s', SoLuongTon=%d, MaChuDe=%d, MaNXB=%d, Moi=%d WHERE MaSach=%s".formatted(TenSach, GiaBan, MoTa, NgayCapNhat, AnhBia, SoLuongTon, MaChuDe, MaNXB, Moi, MaSach);
            provider.Open();
            int isSuccessed = provider.executeUpdate(sqlSelect);
            if(isSuccessed >= 1) {
                return 1;
            }
            return 0;
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
     
    public static int deleteBook(int MaSach) {
        SQLServerDataProvider provider = new SQLServerDataProvider();
        try {
            String sqlSelect = "DELETE FROM Sach WHERE MaSach=%s".formatted(MaSach);
            provider.Open();
            int isSuccessed = provider.executeUpdate(sqlSelect);
            if(isSuccessed >= 1) {
                return 1;
            }
            return 0;
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
    
    public static int addChiTietHoaDon(int MaDonHang, int MaSach, int SoLuong, int DonGia) {
        SQLServerDataProvider provider = new SQLServerDataProvider();
        try {
            String sqlSelect = "INSERT INTO ChiTietDonHang \n" +
                                "VALUES (%d, %d, %d, %d)".formatted(MaDonHang, MaSach, SoLuong, DonGia); 
            provider.Open();
            int isSuccessed = provider.executeUpdate(sqlSelect);
            if(isSuccessed >= 1) {
                return 1;
            }
            return 0;
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
    

}