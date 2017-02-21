import java.sql.*;
//import com.mysql.jdbc.Driver;

/**
 * Created by tuchang on 20/02/2017.
 */
public class DatabaseOpen
{
    static String driver = "com.mysql.jdbc.Driver";
    //static String url = "jdbc:mysql://127.0.0.1:3360/JDBCTest";
    static String url = "jdbc:mysql://127.0.0.1:3306/JDBCTest";
    //static String url = "jdbc:mysql://localhost:3360/JDBCTest";

    //static String url = "jdbc:mysql://localhost:3360/test";
    //root@127.0.0.1:3306
    //jdbc:mysql://127.0.0.1:3306/?user=root

    static String user = "root";
    static String pwd = "fortest";
    static String sql = null;



    static Connection conn = null;
    static Statement st = null;
    static ResultSet rs = null;

    public void init()
    {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pwd);


            sql = "desc student_information";
            //sql = "select * from student_information";
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            //System.out.println(rs);
            while (rs.next()) {
                //System.out.println(rs.getMetaData().getString(1));
                System.out.println(rs.getString(1));
                //System.out.println(rs.getString(0)+"!");
                //System.out.println(rs.getString(2)+"!");
            }





            rs.close();
            st.close();
            conn.close();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args)
    {
        new DatabaseOpen().init();
    }
}
