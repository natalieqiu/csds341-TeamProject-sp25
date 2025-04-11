// Dianne Foreback
//
// This code file makes a SQL Connection and runs a SQL Query returning the results
//
// Edit the connectionUrl in the line below that currently reads "jdbc:sqlserver://cxp-sql-02\\abc123;" and replace
// abc123 with your network id and the server "cxp-sql-02" with the server you were given in an email from the TA.
// The server for Fall 2023 is either cxp-sql-02 or cxp-sql-03
//
//
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLExecQuery {

    // Connect to your database.
    // Replace server name, username, and password with your credentials
    public static void main(String[] args) {
        String connectionUrl = 
           "jdbc:sqlserver://CXP-SQL-03\\mxb1089;"
                + "database=university;"
                + "user=dbuser;"
                // "password=password"
                + "password=csds341143sdsc;"
                // + "password=scsd341143dscs;"
                + "encrypt=true;"
                + "trustServerCertificate=true;"
                + "loginTimeout=15;";

        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(connectionUrl);
                Statement statement = connection.createStatement();) {
            System.out.println("Got into the connection");
            // Create and execute a SELECT SQL statement.
            String selectSql = "SELECT top 100 ID, Name, Dept_Name from Instructor";
            resultSet = statement.executeQuery(selectSql);
            // Print results from select statement
            while (resultSet.next()) {
                System.out.println(resultSet.getString(2) + " " + resultSet.getString(3));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}