import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class 插入 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //加载驱动  反射
        Class.forName("com.mysql.jdbc.Driver");

        //获取连接
        //需要三个参数  url(协议://地址:端口号:数据库名称)  username password

        String url = "jdbc:mysql://127.0.0.1:3306/jdbc?useUnicode=true&characterEncoding=utf8";
        String userName = "root";
        String password = "root";

        //得到连接
        Connection conn = DriverManager.getConnection(url, userName, password);

        //获取数据库操作对象statement
        Statement statement = conn.createStatement();

        //写sql语句
        String sql = "insert into test values('啦啦啦啦')";

        //执行更改
        int i = statement.executeUpdate(sql);

        if (i != 0){

            System.out.println("成功");

        }else {

            System.out.println("失败");

        }

        //关闭资源  先开启的连接后关闭
        statement.close();
        conn.close();



    }

}
