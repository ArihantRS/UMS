package university.management.system;

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///universitymanagementsystem", "root", "1234567890");
            s = c.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}