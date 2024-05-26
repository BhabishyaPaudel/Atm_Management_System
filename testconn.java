import java.util.Date;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
public class testconn {
    public static void main(String[] args) throws SQLException {
        
    
    conn c = new conn();
    Date date = new Date();
    String query1 = "INSERT INTO bank (pin, date, type, amountt) VALUES ('" + 4266 + "', '" + date + "', 'Withdrawal', '" + 500 + "')";
    c.s.executeUpdate(query1);
    }
 
}
