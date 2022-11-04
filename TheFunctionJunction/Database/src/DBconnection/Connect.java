package DBconnection;

import java.sql.*;

public class Connect {
    public static final String user="root";
    public static final String pass="12345";
    public static final String url="jdbc:mysql://localhost:3306/choselater";
    public static Connection con=null;

    public static Connection createConnection() {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection(url,user,pass);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return con;
    }
    public static void closeConnection(){
        if(con!=null){
            try{
                con.close();
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}
