package firstconnection;

public class FirstConnection {

    public static void main(String[] args) {
        DB db = new DB();
        db.addUser("Francis", "Washington");
        db.addUser("Curtis", "London");
        db.showAllUsers();
        db.showUsersMeta();
        System.out.println(db.getAllUsers().toString());
    }    
}
