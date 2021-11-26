package database;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {

    private static Connection conn = null;
    private static Statement stmt = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    private static String URL = "jdbc:sqlserver://DESKTOP-5SBE75L\\LLOYY:1466;databaseName=qltd;integratedSecurity=true";


    public Connection getConnect() {
   
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
           conn = DriverManager.getConnection(URL);
            

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return this.conn;
    }
    
    //lay du lieu tu database
    public ResultSet loadData(String sql) {
        try {
            //tạo statement thực thi câu lệnh sql
            stmt = conn.createStatement();
            //tao resultset lấy dữ liệu
            rs = stmt.executeQuery(sql);

        } catch (SQLException ex) {
            System.out.println("Loi cau truy van khong chinh xac!" + ex.getMessage());
        }
        return rs;
    }

    //thuc thi cau truy van Insert, Update, delete
    public PreparedStatement excuteData(String spl) {
        try {
            //tao statement thuc thi cau  lenh sql
            ps = conn.prepareStatement(spl);

        } catch (SQLException ex) {
            System.out.println("Loi cau truy van khong chinh xac!" + ex.getMessage());
        } finally {
            return ps;
        }
    }

}
