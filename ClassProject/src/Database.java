import java.sql.*;

public class Database {
    private Connection conn;

    private PreparedStatement pstmt;

    private DatabaseMetaData dbm;

    private ResultSet rs;
    Database(String tableName, String[] columnNames, Object[] values){
        if(this.ConnectToDatabase()){
            System.out.println("the connection is valid");
            this.getTables();

            if(this.TableExistence(tableName)){
                this.getColumns(tableName);
                this.getData(tableName);
                this.WriteDatabase(tableName, columnNames, values);
                this.getData(tableName);
            }else{
                System.out.println("the table doesn't exist");
            }
            this.CloseConnection();
        }else{
            System.out.println("the connection is invalid");
        }
    }

    public boolean TableExistence(String tableName){
        try {
            rs = conn.getMetaData().getTables(null, null, tableName, null);
            return rs.next();
        }catch(Exception E1){
            System.out.println("an error occurred while getting the table " + E1);
        }
        return false;
    }
    // this will assure that the database is connected
    public boolean ConnectToDatabase(){
        try {
            // this will establish the connection to the database.
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/StudentSystem";// pass the database name after 3306/
            String user = "root";
            String password = "M6a2r7k5";
            conn = DriverManager.getConnection(url, user, password);

            // this will check the connection if it is valid. we pass an integer to specify the time to wait for a response.
            return conn.isValid(5);
        }catch(Exception E1){
            System.out.println("an error has occurred at " + E1);
        }
        return false;
    }

    public void WriteDatabase(String tableName, String[] columnNames, Object[] values){
        try{
            // Building the SQL statement
            StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append("INSERT INTO ").append(tableName).append(" (");
            for (int i = 0; i < columnNames.length; i++) {
                sqlBuilder.append(columnNames[i]);
                if (i < columnNames.length - 1) {
                    sqlBuilder.append(", ");
                }
            }
            sqlBuilder.append(") VALUES (");
            for (int i = 0; i < values.length; i++) {
                sqlBuilder.append("?");
                if (i < values.length - 1) {
                    sqlBuilder.append(", ");
                }
            }
            sqlBuilder.append(")");
            String sql = sqlBuilder.toString();

            // Inserting data into the table
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < values.length; i++) {
                pstmt.setObject(i + 1, values[i]);
            }
            int rows = pstmt.executeUpdate();
            System.out.println(rows + " row(s) inserted.");

        }catch(Exception E1){
            System.out.println("an error occurred when creating a table " + E1);
        }
    }
    
    public void CloseConnection(){
        try{
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }catch(Exception e1){
            System.out.println("an error occurred while closing the Connection" + e1);
        }
    }

    public void getTables(){
        try{
            // creates a connection to the databaseMataData .
            dbm = conn.getMetaData();

            // this specifies the type of info we want to get. which in our case is Tables.
            String[] types = {"TABLE"};

            /*
            the dbm.getTables will get the tables according to the specifications.
            the conn.getCatalog() will tell the program to get the tables from the database specified.
            the wildcard (%) tells the database to get all the tables.
            and the types tells the database to get the tables since it's what we had specified.
            */
            rs = dbm.getTables(conn.getCatalog(), null, "%", types);
            System.out.println("List of tables:");

            // this will move the cursor to the next piece of data.
            while (rs.next()) {
                // this will get the TABLE_NAME and print it out.
                System.out.println(rs.getString("TABLE_NAME"));
            }
            rs.close();
        } catch (Exception e1) {
            System.out.println("an error occurred while getting the tables " + e1);
        }
    }

    public void getColumns(String table){
        try{
            dbm = conn.getMetaData();
            rs = dbm.getColumns(conn.getCatalog(), null, table, null);
            System.out.println("the list of columns are: ");
            while(rs.next()){
                System.out.println(rs.getString("COLUMN_NAME"));
            }
        }catch(Exception E1){
            System.out.println("an error occurred while getting the columns " + E1);
        }
    }

    public void getData(String table){
        try{
            String sql = "SELECT * FROM " + table;
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (rs.next()) {
                // Retrieving values from the current row dynamically
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    Object value = rs.getObject(i);
                    System.out.println(columnName + ": " + value);
                }
            }
            rs.close();
        }catch(Exception e1){
            System.out.println("an error occurred when getting data from a table");
        }
    }
}
