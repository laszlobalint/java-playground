package firstconnection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DB {
    
    final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    final String URL = "jdbc:derby:sampleDB;create=true";
    final String USERNAME = "";
    final String PASSWORD = "";
    Connection conn = null;
    Statement createStatement = null;
    DatabaseMetaData dbmd = null;

    public DB() {
        
        try {
            conn = DriverManager.getConnection(URL);
            System.out.println("Bridge established.");
        } catch (SQLException ex) {
            System.out.println("Error during connection.");
            System.out.println("" + ex);
        }
        
        if (conn != null) {
            try {
                createStatement = conn.createStatement();
            } catch (SQLException ex) {
                System.out.println("Error during creating statement.");
                System.out.println("" + ex);
            }
        }
        
        try {
            dbmd = conn.getMetaData();
        } catch (SQLException ex) {
                System.out.println("Error during getting metadata.");
                System.out.println("" + ex);
        }
        
        ResultSet rsl = null;
        try {
            rsl = dbmd.getTables(null, "APP", "USERS", null);
            if (!rsl.next()) {
                createStatement.execute("create table users(name varchar(20), address varchar(20))");
            }
        } catch (SQLException ex) {
                System.out.println("Error during creating datatable.");
                System.out.println("" + ex);
        }
    }
    
    public void addUser(String name, String address) {
        try {
            String sql = "insert into users values ('?','?')";
            PreparedStatement prepared = conn.prepareStatement(sql);
            prepared.setString(1, name);
            prepared.setString(2, address);
            prepared.execute();
        } catch (SQLException ex) {
            System.out.println("Error during adding new user.");
            System.out.println("" + ex);
        }
    }
    
    public void showAllUsers() {
        String sql = "select * from users";
        try {
            ResultSet rsl = createStatement.executeQuery(sql);
            while (rsl.next()) {
                String name = rsl.getString("name");
                String address = rsl.getString("address");
                System.out.println(name + " | " + address);
            }
        } catch (SQLException ex) {
            System.out.println("Error during showing all users.");
            System.out.println("" + ex);
        }
    }
    
    public void showUsersMeta() {
        String sql = "select * from users";
        ResultSet rsl = null;
        ResultSetMetaData rsmd = null;
        try {
            rsl = createStatement.executeQuery(sql);
            rsmd = rsl.getMetaData();
            int columnCount = rsmd.getColumnCount();
            for (int x = 1; x >= columnCount; x++) {
                System.out.print(rsmd.getColumnName(x) + " | ");
            }
        } catch (SQLException ex) {
            System.out.println("Error during showing users metadata.");
            System.out.println("" + ex);
        }   
    }
    
    public ArrayList<User> getAllUsers() {
        String sql = "select * from users";
        ArrayList<User> users = null;
        try {
            ResultSet rsl = createStatement.executeQuery(sql);
            users = new ArrayList<>();
            while (rsl.next()) {
                User user = new User(rsl.getString("name"), rsl.getString("address"));
                users.add(user);
            }
        } catch (SQLException ex) {
            System.out.println("Error during showing all users.");
            System.out.println("" + ex);
        } return users;
    }
    
    public void addUser(User user) {
        try {
            String sql = "insert into users values ('?','?')";
            PreparedStatement prepared = conn.prepareStatement(sql);
            prepared.setString(1, user.getName());
            prepared.setString(2, user.getAddress());
            prepared.execute();
        } catch (SQLException ex) {
            System.out.println("Error during adding new user.");
            System.out.println("" + ex);
        }
    }
}
