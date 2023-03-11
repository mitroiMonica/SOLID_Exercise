package ro.ase.acs.interfaces;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface DatabaseSelectHandler {
    List<Map<String, Object>> handleData(Connection connection) throws SQLException;
}
