import java.io.File;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import net.proteanit.sql.DbUtils; //rs2xml.jar

public class sqlConnect {
    
    static Connection conn = null;
    private static Statement stmt;

    public static Connection connectDB(){
       
        try {
            Class.forName("org.sqlite.JDBC");
            // open file db.sqlite from current folder
            conn = DriverManager.getConnection("jdbc:sqlite:db.sqlite");
            
            stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS CalendarData " +
                         "(id INTEGER PRIMARY KEY, " +
                         " date TEXT , " + 
                         " time TEXT , " +
                         " duration  TEXT , " +
                         " header TEXT , " +
                         " comment TEXT)"; 
            stmt.executeUpdate(sql);
            stmt.close();
            
        } 
        catch (Exception e){
                JOptionPane.showMessageDialog(null,e);
                conn = null;
        }
        return conn;
    }
}