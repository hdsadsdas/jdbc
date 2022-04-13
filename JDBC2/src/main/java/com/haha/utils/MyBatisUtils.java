package com.haha.utils;/*
 * @author : zengkai
 * @email:598421227@qq.com
 * @desc:
 * @datetime:2021/12/9 9:32
 */

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtils {

private static SqlSessionFactory factory = null;

static{
/*重点*/
    /*重点*/
        /*重点*/
    /*   这个是从 target/Classes  后面开始找
    * */
String config ="mybatis.xml";

    try {
        InputStream in = Resources.getResourceAsStream(config);

        factory = new SqlSessionFactoryBuilder().build(in);

    } catch (IOException e) {
        e.printStackTrace();
    }
}


public static SqlSession getSqlSession(){

        SqlSession sqlSession = null;
        if (factory != null){

        sqlSession = factory.openSession();

        }

        return sqlSession;

}


}
