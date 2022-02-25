package 封装.service.impl;

import 封装.dao.UserDao;
import 封装.dao.impl.UserDaoImpl;
import 封装.entity.User;
import 封装.service.UserService;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    @Override
    public boolean userLogin(User user) throws SQLException {
        User user1 = userDao.selectUser(user);
        if (user1 == null){

            System.out.println("用户名不存在");

            return false;
        }else {

            if (user.getPassword().equals(user1.getPassword())){

                System.out.println("登入成功");

                return true;

            }else {

                System.out.println("密码错误");

                return false;

            }

        }

    }

    @Override
    public boolean userRegister(User user) throws SQLException {

        User user1 = userDao.selectUser(user);

        if (user1 != null){

            System.out.println("用户已经存在");

            return false;

        }else {

            int i = userDao.addUser(user.getUsername(),user.getPassword());

            if (i == 0 ){

                System.out.println("注册失败");
                return false;

            }else{

                System.out.println("注册成功");
                return true;

            }


        }
    }

    @Override
    public boolean userCancellation(User user) throws SQLException {

        User user1 = userDao.selectUser(user);
        if (user1 == null){

            System.out.println("用户名不存在");

            return false;
        }else {

            int i = userDao.deleteUser(user.getUsername());

            if (i == 0 ){

                System.out.println("删除失败");
                return false;

            }else{

                System.out.println("删除成功");
                return true;

            }


        }


    }

    @Override
    public boolean userChangePassword(User user) throws SQLException {

        User user1 = userDao.selectUser(user);
        if (user1 == null){

            System.out.println("用户名不存在");

            return false;
        }else {

            int i = userDao.updateUser(user.getUsername(), user.getPassword());

            if (i == 0 ){

                System.out.println("更改失败");
                return false;

            }else{

                System.out.println("更改成功");
                return true;

            }

        }
    }
}
