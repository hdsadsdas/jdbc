package 封装.dao;

import 封装.entity.User;

import java.sql.SQLException;

public interface UserDao {

    int addUser(String username,String password) throws SQLException;

    int deleteUser(String username) throws SQLException;

    int updateUser(String username,String password) throws SQLException;

    User selectUser(User user) throws SQLException;

}
