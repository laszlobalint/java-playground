package phonebook;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
        
        try {
            dbmd = conn.getMetaData();
        } catch (SQLException ex) {
            System.out.println("Something went wront during creating Database Meta Data.");
            System.out.println("" + ex);
        }
        
        try {
            ResultSet rs = dbmd.getTables(null, "APP", "CONTACTS", null);
            if (!rs.next()) {
                createStatement.execute("create table contacts(id INT not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCEREMENT BY 1), lastname varchar(20), firstname varchar(20), email varchar(30))");
            } 
        } catch (SQLException ex) {
            System.out.println("Error during creating database tables.");
            System.out.println("" + ex);
        }
    }
    
    public ArrayList<Person> getAllContacts() {
        String sql = "select * from contacts";
        ArrayList<Person> users = null;
        try {
            ResultSet rs = createStatement.executeQuery(sql);
            users = new ArrayList<>();
            
            while (rs.next()) {
                Person actualPerson = new Person(rs.getInt("id"), rs.getString("lastname"), rs.getString("firstname"), rs.getString("email"));
                users.add(actualPerson);
            }
        } catch (SQLException ex) {
            System.out.println("Error happened during loading user details.");
            System.out.println("" + ex);
        }
        return users;
    }
    
    public void addContact(Person person) {
        try {
            String sql = "insert into contacts (lastname, firstname, email) values (?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, person.getLastName());
            preparedStatement.setString(2, person.getFirstName());
            preparedStatement.setString(3, person.getEmail());
            preparedStatement.execute();
        } catch (SQLException ex) {
            System.out.println("Error happened during adding new contact.");
            System.out.println("" + ex);
        }
    }
    
    public void updateContact(Person person) {
        try {
            String sql = "update contacts set lastname = ?, firstname = ?, email = ? where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, person.getLastName());
            preparedStatement.setString(2, person.getFirstName());
            preparedStatement.setString(3, person.getEmail());
            preparedStatement.setInt(4, Integer.parseInt(person.getId()));
            preparedStatement.execute();
        } catch (SQLException ex) {
            System.out.println("Error happened during updating contact.");
            System.out.println("" + ex);
        }
    }
    
    public void removeContact(Person person) {
        try {
            String sql = "delete from contacts where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(person.getId()));
            preparedStatement.execute();
        } catch (SQLException ex) {
            System.out.println("Error happened during deleting contact.");
            System.out.println("" + ex);
        }
    }
}
