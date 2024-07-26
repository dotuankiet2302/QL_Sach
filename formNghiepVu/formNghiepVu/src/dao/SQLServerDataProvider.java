package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLServerDataProvider {
    private Connection connection;

    public void ketnoi(String strUserName, String strPass) {
        String strServer = "LAPTOP-E8D06NHE\\SQLEXPRESS";
        String strDatabase = "QuanLyBanSach";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String ConnectionURL = "jdbc:sqlserver://" + strServer
                + ":1433;databaseName=" + strDatabase
                + ";user=" + strUserName
                + ";password=" + strPass
                + ";encrypt=true"
                + ";trustServerCertificate=true";

            connection = DriverManager.getConnection(ConnectionURL);
            if (connection != null) {
                System.out.println("Ket noi thanh cong");
            } else {
                System.out.println("Ket noi that bai");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Close() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Da dong ket noi");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String sql) {
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public int executeUpdate(String sql) {
        int n = -1;
        try {
            Statement statement = connection.createStatement();
            n = statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }

    public PreparedStatement prepareStatement(String sql) {
        PreparedStatement preparedStatement = null;
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(sql);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    public Connection getConnection() {
        return connection;
    }

    public void Open() {
        String strSever = "LAPTOP-E8D06NHE\\SQLEXPRESS";
        String strDatabase = "QuanLyBanSach";
        String strUserName = "sa";
        String strPass = "123";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String ConnectionURL = "jdbc:sqlserver://" + strSever
                + ":1433;databaseName=" + strDatabase
                + ";user=" + strUserName
                + ";password=" + strPass
                + ";encrypt=true"
                + ";trustServerCertificate=true";

            connection = DriverManager.getConnection(ConnectionURL);
            if (connection != null) {
                System.out.println("Thanh cong");
            } else {
                System.out.println("Ket noi that bai");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
