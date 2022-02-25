package 封装.test;

import 封装.entity.User;
import 封装.service.UserService;
import 封装.service.impl.UserServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws SQLException {

        UserService userService = new UserServiceImpl();
        boolean sw = true;

        while (sw){

            User user = new User();

            System.out.println("欢迎来到洗脚城");
            System.out.println("1.登入");
            System.out.println("2.注册");
            System.out.println("3.改密码");
            System.out.println("4.注销");
            System.out.println("5.退出");

            Scanner scanner = new Scanner(System.in);
            int choose = scanner.nextInt();



            switch (choose){

                case 1 :
                    System.out.println("请输入用户名");
                    String name = scanner.next();
                    System.out.println("请输入密码");
                    String pass = scanner.next();

                    user.setUsername(name);
                    user.setPassword(pass);

                    userService.userLogin(user);

                    break;

                case 2 :
                    System.out.println("请输入用户名");
                    String name1 = scanner.next();
                    System.out.println("请输入密码");
                    String pass1 = scanner.next();

                    user.setUsername(name1);
                    user.setPassword(pass1);

                    userService.userRegister(user);

                    break;
                case 3:
                    System.out.println("请输入用户名");
                    String name2 = scanner.next();
                    System.out.println("请输入密码");
                    String pass2 = scanner.next();

                    user.setUsername(name2);
                    user.setPassword(pass2);

                    userService.userChangePassword(user);

                    break;
                case 4:
                    System.out.println("请输入用户名");
                    String name3 = scanner.next();

                    user.setUsername(name3);
                    user.setPassword(null);

                    userService.userCancellation(user);

                    break;

                default:
                    System.out.println("退出");
                    sw = false;

            }

        }

    }

}
