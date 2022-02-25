package 封装.service;

import 封装.entity.User;

import java.sql.SQLException;

public interface UserService {

    boolean userLogin(User user) throws SQLException;

    boolean userRegister(User user) throws SQLException;

    boolean userCancellation(User user) throws SQLException;

    boolean userChangePassword(User user) throws SQLException;

}
