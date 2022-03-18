package book_web_demo_springboot.demo.service;

import book_web_demo_springboot.demo.common.Result;
import book_web_demo_springboot.demo.entity.Login;
import book_web_demo_springboot.demo.entity.Userinfo;

public interface UserService {
    Result<?> getUserByNameAndPwd(String name, String pwd);
    Result<?> getUserById(Integer id);
    Result<?> getAll();
    Result<?> insertUser(Login login);
    Result<?> updateUser(Userinfo userinfo);
    Result<?> delUserById(Integer uid);
    Result<?> freezeUser(Integer uid);
}
