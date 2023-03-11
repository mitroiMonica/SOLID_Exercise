package ro.ase.acs.classes;

import ro.ase.acs.interfaces.DataBaseHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadData implements DataBaseHandler {
    @Override
    public void handleData(Connection connection) throws SQLException {
        String sqlSelect = "SELECT * FROM employees";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sqlSelect);
        while (rs.next()) {
            int id = rs.getInt("id");
            System.out.println("id: " + id);
            String name = rs.getString(2);
            System.out.println("name: " + name);
            String address = rs.getString("address");
            System.out.println("address: " + address);
            double salary = rs.getDouble("salary");
            System.out.println("salary: " + salary);
        }
        rs.close();
        statement.close();
    }
}
