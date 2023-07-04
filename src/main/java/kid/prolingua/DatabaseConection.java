package kid.prolingua;

import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseConection {

    public Connection databaseLink;

    public Connection getConnection() {
        String databaseName = "base_datos";
        String databaseUser = "root";
        String databasePassword = "1115736mama";
        String url = "jdbc:mysql://localhost/" + databaseName;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return databaseLink;

    }
}
