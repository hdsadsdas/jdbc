package com.haha;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * @author : zengkai
 * @email:598421227@qq.com
 * @desc:
 * @datetime:2022/3/8 11:07
 */
public class DbUtils {

    private static DruidDataSource ds;

    static {

        Properties properties = new Properties();

        try {

            properties.load(DbUtils.class.getClassLoader().getResourceAsStream("database.properties"));

            ds = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);



        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

}
