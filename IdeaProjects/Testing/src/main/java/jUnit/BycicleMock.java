package jUnit;

public class BycicleMock {

    DatabaseConnector dbConn;

    BycicleMock() {}

    public BycicleMock(DatabaseConnector dbConn) {
        this.dbConn = dbConn;
    }

    public Integer sum (String user, String password, int a, int b, int c) {
        boolean checkUser = dbConn.checkUserPass(user, password);

        if (checkUser) {
            return a + b + c;
        }

        return null;
    }
}
