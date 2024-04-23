import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            var authors = new AuthorDAO();
            authors.create("faasgfas");
            System.out.println(authors.findByName("fsaf"));
            System.out.println(authors.findById(1));
            Database.getConnection().commit();
            Database.closeConnection();
        } catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        }
    }

}
