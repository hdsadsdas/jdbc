package 封装.dao.impl;

import 封装.dao.UserDao;
import 封装.entity.User;
import 封装.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {


    @Override
    public int addUser(String username, String password) throws SQLException {

        Connection conn = DbUtil.getConn();

        PreparedStatement preparedStatement = conn.prepareStatement(
                "insert into user(username,password) value (?,?)");

        preparedStatement.setString(1,username);

        preparedStatement.setString(2,password);

        int i = preparedStatement.executeUpdate();

        DbUtil.clossAll(null,conn,preparedStatement);

        return i;
    }

    @Override
    public int deleteUser(String username) throws SQLException {

        Connection conn = DbUtil.getConn();

        PreparedStatement preparedStatement = conn.prepareStatement(
                "delete  from user where username = ? ");

        preparedStatement.setString(1,username);

        int i = preparedStatement.executeUpdate();

        DbUtil.clossAll(null,conn,preparedStatement);
        return i;
    }

    @Override
    public int updateUser(String username, String password) throws SQLException {

        Connection conn = DbUtil.getConn();

        PreparedStatement preparedStatement = conn.prepareStatement(
                "update user set password = ? where username = ?");

        preparedStatement.setString(1,password);

        preparedStatement.setString(2,username);

        int i = preparedStatement.executeUpdate();

        DbUtil.clossAll(null,conn,preparedStatement);

        return i;
    }

    @Override
    public User selectUser(User user) throws SQLException {

        Connection conn = DbUtil.getConn();

        PreparedStatement preparedStatement = conn.prepareStatement(
                "select * from user where username = ?");

        preparedStatement.setString(1,user.getUsername());

        ResultSet resultSet = preparedStatement.executeQuery();

        User u = new User();

        while (resultSet.next()){

            u.setUsername(resultSet.getString("username"));

            u.setPassword(resultSet.getString("password"));

        }

        DbUtil.clossAll(resultSet,conn,preparedStatement);

        return u;
    }
}
