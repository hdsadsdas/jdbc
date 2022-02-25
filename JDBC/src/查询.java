import java.sql.*;

public class 查询 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://127.0.0.1:3306/jdbc?useUnicode=true&characterEncoding=utf8";
        String userName = "root";
        String password = "root";

        Connection conn = DriverManager.getConnection(url,userName,password);

        Statement statement = conn.createStatement();

        String sql = "select * from test";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){

            String name = resultSet.getString("name");
            System.out.println(name);

        }

        statement.close();
        conn.close();


    }
}
