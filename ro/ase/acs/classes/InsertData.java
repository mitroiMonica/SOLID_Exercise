package ro.ase.acs.classes;

import ro.ase.acs.enums.TableSQL;
import ro.ase.acs.interfaces.DatabaseUpdateHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData implements DatabaseUpdateHandler {
    @Override
    public void handleData(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(TableSQL.INSERT_DATA.getCommand());
        statement.close();

        PreparedStatement preparedStatement =
                connection.prepareStatement(TableSQL.INSERT_DATA_WITH_PARAMS.getCommand());
        preparedStatement.setInt(1, 2);
        preparedStatement.setString(2, "Ionescu Vasile");
        preparedStatement.setString(3, "Brasov");
        preparedStatement.setDouble(4, 4500);
        preparedStatement.executeUpdate();
        preparedStatement.close();

        connection.commit();
    }
}
