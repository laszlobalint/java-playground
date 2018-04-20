package origo.parser;

import java.sql.*;

class DBConnect {
    final String DRIVER = "com.mysql.jdbc.Driver";
    final String DB_PATH = "jdbc:mysql://localhost/articles?verifyServerCertificate=false&useSSL=true";
    String username = null;
    String password = null;
    Connection conn = null;
    Statement stat = null;
    PreparedStatement prepStmnt = null;

    public DBConnect(String name, String pass) {
        username = name;
        password = pass;
    }

    public void connect() throws SQLException, Exception {
        Class.forName(DRIVER);
        System.out.println("Connecting...");
        conn = DriverManager.getConnection(DB_PATH, username, password);
        stat = conn.createStatement();
    }

    public void closeConnection() throws SQLException, Exception {
        stat.close();
        conn.close();
    }

    public void insertArticle(String keyword, String content) throws SQLException, Exception {
        System.out.println("Adding...");
        String query = "INSERT INTO origo (keyword, content) VALUES (?, ?)";
        prepStmnt = conn.prepareStatement(query);
        prepStmnt.setString(1, keyword);
        prepStmnt.setString(2, content);
        prepStmnt.execute();
        prepStmnt.close();
    }

    public String getDRIVER() {
        return DRIVER;
    }

    public String getDB_PATH() {
        return DB_PATH;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public Statement getStat() {
        return stat;
    }

    public void setStat(Statement stat) {
        this.stat = stat;
    }

    public PreparedStatement getPrepStmnt() {
        return prepStmnt;
    }

    public void setPrepStmnt(PreparedStatement prepStmnt) {
        this.prepStmnt = prepStmnt;
    }
}