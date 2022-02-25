package 封装.util;

import java.sql.*;

public class DbUtil {

    static {

        try {//加载驱动  反射 运行一次

            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConn(){

        //获取连接
        //需要三个参数  url(协议://地址:端口号:数据库名称)  username password

        String url = "jdbc:mysql://127.0.0.1:3306/jdbc?useUnicode=true&characterEncoding=utf8";
        String userName = "root";
        String password = "root";


        Connection connection = null;
        //得到连接
        try {
            connection = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;

    }


    public static void clossAll(ResultSet resultSet, Connection connection, PreparedStatement preparedStatement){

        if (resultSet != null){

            try {

                resultSet.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        if (preparedStatement != null){

            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        if (connection != null){

            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }


}
