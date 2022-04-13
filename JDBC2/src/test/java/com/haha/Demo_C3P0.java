package com.haha;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.SQLException;

/**
 * @author : zengkai
 * @email:598421227@qq.com
 * @desc:
 * @datetime:2022/3/8 9:35
 */
public class Demo_C3P0 {

    public static void main(String[] args) throws PropertyVetoException, SQLException {

        //C3P0的核心
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        //注册驱动
        dataSource.setDriverClass("com.mysql.jdbc.Driver");

        //url
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/hospital");

        //用户名
        dataSource.setUser("root");

        //密码
        dataSource.setPassword("root");

        //初始化连接数
        dataSource.setInitialPoolSize(5);

        //最大连接数
        dataSource.setMaxPoolSize(10);

        //最小连接数
        dataSource.setMinPoolSize(5);

        //每次创建的连接数
        dataSource.setAcquireIncrement(5);

        //设置连接时间 毫秒为单位
        dataSource.setCheckoutTimeout(3000);

        //获取数据库连接
        System.out.println(dataSource.getConnection());


    }


}
