package ro.ase.acs.classes;

import ro.ase.acs.interfaces.DataBaseHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable implements DataBaseHandler {
    private static final String SQL_CREATE = "CREATE TABLE employees(id INTEGER PRIMARY KEY,"
            + "name TEXT, address TEXT, salary REAL)";

    @Override
    public void handleData(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(SQL_CREATE);
        statement.close();
        connection.commit();
    }
}
