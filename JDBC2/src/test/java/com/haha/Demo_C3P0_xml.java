package com.haha;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.SQLException;

/**
 * @author : zengkai
 * @email:598421227@qq.com
 * @desc:
 * @datetime:2022/3/8 10:34
 */
public class Demo_C3P0_xml {

    public static void main(String[] args) throws SQLException {

        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        System.out.println(dataSource.getConnection());

    }

}
