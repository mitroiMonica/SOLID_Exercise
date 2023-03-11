package ro.ase.acs.enums;

public enum TableSQL {
    DROP_TABLE("DROP TABLE IF EXISTS tableName"),
    SELECT_ALL("SELECT * FROM tableName"),
    CREATE_TABLE("CREATE TABLE tableName(id INTEGER PRIMARY KEY,"
            + "name TEXT, address TEXT, salary REAL)"),
    INSERT_DATA("INSERT INTO tableName VALUES(1, 'Popescu Ion', 'Bucharest', 4000)"),
    INSERT_DATA_WITH_PARAMS("INSERT INTO tableName VALUES (?,?,?,?)");

    private final String COMMAND;

    private TableSQL(String command) {
        String TABLE_NAME = "employees";
        this.COMMAND = command.replace("tableName", TABLE_NAME);
    }

    public String getCommand() {
        return this.COMMAND;
    }
}
