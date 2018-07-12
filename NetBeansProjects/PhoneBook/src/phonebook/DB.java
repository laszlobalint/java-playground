package phonebook;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
    
    final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    final String URL = "jdbc:derbi:sampleDB;create=true";
    final String USERNAME = "";
    final String PASSWORD = "";
    
    Connection conn = null;
    Statement createStatement = null;
    DatabaseMetaData dbmd = null;
    
    public DB() {
        try {
            conn = DriverManager.getConnection(URL);
            System.out.println("Bridge has been established.");
        } catch (SQLException ex){
            System.out.println("Something went wrong when establishing bridge.");
            System.out.println("" + ex);
        }
        
        if (conn != null) {
            try {
                createStatement = conn.createStatement();
            } catch (SQLException ex) {
                System.out.println("Some trouble at creating statement.");
                System.out.println("" + ex);
            }
        }
    }
}
