package book_web_demo_springboot.demo.controller;

import book_web_demo_springboot.demo.common.Result;
import book_web_demo_springboot.demo.entity.Login;
import book_web_demo_springboot.demo.entity.Userinfo;
import book_web_demo_springboot.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public Result login(@RequestBody Login login) {
        Result<?> nameAndPwd = userService.getUserByNameAndPwd(login.getUsername(), login.getPassword());
        return nameAndPwd;
    }
    @PostMapping("/register")
    public Result register(@RequestBody Login login) {
        Result<?> result = userService.insertUser(login);
        return result;
    }

    @PutMapping("/update")
    public Result updateUser(@RequestBody Userinfo userinfo) {
        Result<?> result = userService.updateUser(userinfo);
        return result;
    }

    @GetMapping("/get/uid/{uid}")
    public Result getUser(@PathVariable("uid") Integer uid) {
        Result<?> getUserById = userService.getUserById(uid);
        return getUserById;
    }

    @GetMapping("/get/all")
    public Result getAll() {
        Result<?> all = userService.getAll();
        return all;
    }
    /*    待加入验证机制      */
    @DeleteMapping("/del/{uid}")
    public Result delUserById(@PathVariable("uid")Integer uid) {
        Result<?> delUserById = userService.delUserById(uid);
        return delUserById;
    }

    @PutMapping("/del/uid/{uid}")
    public Result freezeUserById(@PathVariable("uid")Integer uid) {
        Result<?> delUserById = userService.freezeUser(uid);
        return delUserById;
    }
}
