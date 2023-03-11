package ro.ase.acs.main;

import ro.ase.acs.classes.CreateTable;
import ro.ase.acs.classes.DropTable;
import ro.ase.acs.classes.InsertData;
import ro.ase.acs.classes.ReadData;
import ro.ase.acs.interfaces.DataBaseHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            connection.setAutoCommit(false);

            DataBaseHandler dropTable = new DropTable();
            dropTable.handleData(connection);

            DataBaseHandler createTable = new CreateTable();
            createTable.handleData(connection);

            DataBaseHandler insertData = new InsertData();
            insertData.handleData(connection);

            DataBaseHandler readData = new ReadData();
            readData.handleData(connection);

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}