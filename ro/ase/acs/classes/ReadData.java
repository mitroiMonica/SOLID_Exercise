package ro.ase.acs.classes;

import ro.ase.acs.enums.TableSQL;
import ro.ase.acs.interfaces.DatabaseSelectHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ReadData implements DatabaseSelectHandler {
    @Override
    public List<Map<String, Object>> handleData(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(TableSQL.SELECT_ALL.getCommand());
        List<Map<String, Object>> list = new ArrayList<>();
        while (rs.next()) {
            Map<String, Object> map = new LinkedHashMap<>();
            int id = rs.getInt(1);
            map.put("id", id);
            String name = rs.getString(2);
            map.put("name", name);
            String address = rs.getString(3);
            map.put("address", address);
            double salary = rs.getDouble(4);
            map.put("salary", salary);
            list.add(map);
        }
        rs.close();
        statement.close();
        return list;
    }
}
