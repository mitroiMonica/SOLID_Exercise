package ro.ase.acs.classes;

import ro.ase.acs.interfaces.DataBaseHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DropTable implements DataBaseHandler {
    private static final String SQL_DROP = "DROP TABLE IF EXISTS employees";

    @Override
    public void handleData(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(SQL_DROP);
        statement.close();
        connection.commit();
    }
}
