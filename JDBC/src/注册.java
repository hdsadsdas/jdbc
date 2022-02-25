import java.sql.*;
import java.util.Scanner;

public class 注册 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Scanner scanner = new Scanner(System.in);

        //用户输入的
        String name = scanner.next();
        String pass = scanner.next();

        //加载驱动  反射
        Class.forName("com.mysql.jdbc.Driver");

        //获取连接
        //需要三个参数  url(协议://地址:端口号:数据库名称)  username password

        String url = "jdbc:mysql://127.0.0.1:3306/jdbc?useUnicode=true&characterEncoding=utf8";
        String userName = "root";
        String password = "root";

        //得到连接
        Connection conn = DriverManager.getConnection(url, userName, password);

        String sql = "insert into user values(?,?)";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        //setString(第几个问号.值)
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,pass);

        //执行sql语句
        int i = preparedStatement.executeUpdate();

        if (i != 0){

            System.out.println("成功");

        }else {

            System.out.println("失败");

        }

        preparedStatement.close();
        conn.close();

    }
}
