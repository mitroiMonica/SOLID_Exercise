package ro.ase.acs.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface DatabaseUpdateHandler {
    void handleData(Connection connection) throws SQLException;
}
