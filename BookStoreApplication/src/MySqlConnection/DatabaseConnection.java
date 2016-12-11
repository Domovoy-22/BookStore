
package MySqlConnection;

import java.sql.*;

public class DatabaseConnection {
    private Connection connection = null;
    private Statement statement;
    private PreparedStatement preparedStatement;
    
    public DatabaseConnection() {
        try {
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://LINA;databaseName=Book_shop;";
        connection = DriverManager.getConnection(url, "sa", "210733");
        System.out.println("Connected");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public Connection ConnectDb(){
        return connection;
    }
    
    public ResultSet select(String fields, String table, String condition) throws SQLException {
        String query = "SELECT " + fields + " FROM " + table;
        if (condition != null) {
            query += " WHERE " + condition;
        }
        statement = connection.createStatement();
        return statement.executeQuery(query);
    }
    
    public ResultSet customSelect(String query) throws SQLException {
        statement = connection.createStatement();
        return statement.executeQuery(query);
    }
    
    public void insert(String tableAndFields, String values) throws SQLException {
        String query = "INSERT INTO " + tableAndFields + " VALUES (" + values + ")";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
    }
      public void insertIgnore(String tableAndFields, String values,String field) throws SQLException {
        String query = "INSERT IGNORE INTO " + tableAndFields + " VALUES (" + values + ")" + " ON DUPLICATE KEY UPDATE " + field;
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
    }
    
    public void update(String table, String values, String condition) throws SQLException {
        String query = "UPDATE " + table + " SET " + values + " WHERE " + condition;
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
    }
    
    public void delete(String table, String condition) throws SQLException {
        String query = "DELETE FROM " + table + " WHERE " + condition;
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.execute();
    }
}
