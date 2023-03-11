package ro.ase.acs.classes;

import ro.ase.acs.enums.TableSQL;
import ro.ase.acs.interfaces.DatabaseUpdateHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable implements DatabaseUpdateHandler {
    @Override
    public void handleData(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(TableSQL.CREATE_TABLE.getCommand());
        statement.close();
        connection.commit();
    }
}
