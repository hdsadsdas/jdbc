import java.sql.*;
import java.util.Scanner;

public class 登入 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Scanner scanner = new Scanner(System.in);

        //用户输入的
        String name = scanner.next();
        String pass = scanner.next();

        //数据库查询到的 存储
        String un = null;
        String pw = null;

        //加载驱动  反射
        Class.forName("com.mysql.jdbc.Driver");

        //获取连接
        //需要三个参数  url(协议://地址:端口号:数据库名称)  username password

        String url = "jdbc:mysql://127.0.0.1:3306/jdbc?useUnicode=true&characterEncoding=utf8";
        String userName = "root";
        String password = "root";

        //得到连接
        Connection conn = DriverManager.getConnection(url, userName, password);

        String sql = "select username,password from user where username = ? ";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        //处理占位符
        preparedStatement.setString(1,name);

        //执行sql语句
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){

            un = resultSet.getString("username");
            pw = resultSet.getString("password");

        }

        if (un.equals(name)&&pw.equals(pass)){

            System.out.println("登入成功");

        }else {

            System.out.println("登入失败");

        }

        resultSet.close();
        preparedStatement.close();
        conn.close();


    }

}
