package reusableComponents;

import java.util.HashMap;
import java.sql.*;

public class DB_Operations {

    //synchronized is the capability to control teh access of multiple threads to any shared resource
    public synchronized HashMap<String, String> getSqlResultInMap(String sql) {
        HashMap<String, String> data_map = new HashMap<>();

        //https://www.youtube.com/watch?v=7rgVF9x_HIk&list=PL5fOKT7XR42OgLXmX8wYYhB7L0sN-uqpR&index=16

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/qdpm_qa?serverTimezone=UTC","root","");

            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            ResultSetMetaData md = rs.getMetaData();

            while (rs.next()) {
                for (int i = 1; i <= md.getColumnCount(); i++) {
                    data_map.put(md.getColumnName(i), rs.getString(i));
                }
            }
            System.out.println(data_map);
            con.close();
        }catch(Exception e){ System.out.println(e);}
        return data_map;
    }
}
