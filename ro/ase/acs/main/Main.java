package ro.ase.acs.main;

import ro.ase.acs.classes.ConsoleWriter;
import ro.ase.acs.classes.CreateTable;
import ro.ase.acs.classes.DropTable;
import ro.ase.acs.classes.InsertData;
import ro.ase.acs.classes.ReadData;
import ro.ase.acs.interfaces.DatabaseSelectHandler;
import ro.ase.acs.interfaces.DatabaseUpdateHandler;
import ro.ase.acs.interfaces.ValuesWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String CONNECTION = "jdbc:sqlite:database.db";
    private static final String INSTANCE_TYPE = "org.sqlite.JDBC";

    public static void main(String[] args) {
        try {
            Class.forName(INSTANCE_TYPE);
            Connection connection = DriverManager.getConnection(CONNECTION);
            connection.setAutoCommit(false);

            DatabaseUpdateHandler dropTable = new DropTable();
            dropTable.handleData(connection);

            DatabaseUpdateHandler createTable = new CreateTable();
            createTable.handleData(connection);

            DatabaseUpdateHandler insertData = new InsertData();
            insertData.handleData(connection);

            DatabaseSelectHandler readData = new ReadData();
            List<Map<String, Object>> list = readData.handleData(connection);

            ValuesWriter consoleWriter = new ConsoleWriter();
            consoleWriter.displaySetResult(list);

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}