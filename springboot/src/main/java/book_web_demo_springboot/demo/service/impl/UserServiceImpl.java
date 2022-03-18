package book_web_demo_springboot.demo.service.impl;

import book_web_demo_springboot.demo.common.Code;
import book_web_demo_springboot.demo.common.Result;
import book_web_demo_springboot.demo.entity.Login;
import book_web_demo_springboot.demo.entity.Userinfo;
import book_web_demo_springboot.demo.mapper.LoginMapper;
import book_web_demo_springboot.demo.mapper.UserinfoMapper;
import book_web_demo_springboot.demo.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    /**
     * 登录映射
     */
    @Resource
    private LoginMapper loginMapper;
    /**
     * 用户信息映射
     */
    @Resource
    private UserinfoMapper userinfoMapper;

    /**
     * 根据用户名和密码获取登录信息
     * @param name 用户名
     * @param pwd   密码
     * @return
     */
    @Override
    public Result<?> getUserByNameAndPwd(String name, String pwd) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username", name);
        queryWrapper.eq("password", pwd);
        Result result = new Result(Code.GET_ERROR);
        try {
            Login login = loginMapper.selectOne(queryWrapper);
            if (login != null &&login.getRid()>0) {
                result.setCode(Code.GET_OK);
                result.setData(login);
                result.setMessage("login succeed!");
            }else {
                result.setMessage("The user is block!");
            }
        } catch (Exception e) {
            result.setMessage(e.getMessage());
        }
        return result;

    }

    /**
     * 根据主键id获取用户信息
     * @param uid 表id
     * @return
     */
    @Override
    public Result<?> getUserById(Integer uid) {
        int get=0;
        Result result=new Result(Code.GET_ERROR);
        try {
            Userinfo userinfo = userinfoMapper.selectById(uid);
            result.setCode(Code.GET_OK);
            result.setData(userinfo);
            result.setMessage("get userinfo ok!");
        }catch (Exception e){
            result.setMessage(e.getMessage());
        }
        return result;
    }

    /**
     * 新增一条用户登录信息，只包括登录信息；账号和密码(非空列为数据库默认)
     * @param login 用户登录信息
     * @return
     */
    @Override
    public Result<?> insertUser(Login login) {
        int insert = 0;
        Result result = new Result(Code.SAVE_ERROR);
        try {
            insert = loginMapper.insert(login);
            if (insert >= 1) {
                result.setCode(Code.SAVE_OK);
                result.setMessage("insert one user ok!");
            }
        } catch (Exception e) {
            result.setCode(Code.SAVE_ERROR);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    /**
     * 获取所有用户信息
     * @return
     */
    @Override
    public Result<?> getAll() {
        Result result = new Result(Code.GET_ERROR);
        try {
            List<Userinfo> userinfos = userinfoMapper.selectList(new QueryWrapper<>());
            if (userinfos != null) {
                result.setCode(Code.GET_OK);
                result.setData(userinfos);
                result.setMessage("get all user info ok!");
                return result;
            }else {
                result.setMessage("no data in DB");
            }
        }catch (Exception e){
            result.setMessage(e.getMessage());
            return result;
        }
        return result;
    }

    /**
     * 根据用户信息修改数据库用户信息
     * @param userinfo
     * @return
     */
    @Override
    public Result<?> updateUser(Userinfo userinfo) {
//        UpdateWrapper updateWrapper=new UpdateWrapper();
//        updateWrapper.
        int update=0;
        Result<?> result=new Result<>(Code.UPDATE_ERROR);
        try{
            update = userinfoMapper.updateById(userinfo);
            if (update>0){
                result.setCode(Code.UPDATE_OK);
                result.setMessage("update uid = "+userinfo.getUid()+" info ok!");
                return result;
            }else {
                result.setMessage("not found user!");
            }
        }catch (Exception e){
            result.setMessage(e.getMessage());
            return result;
        }
        return result;
    }

    /**
     * 根据id删除用户，并不推荐使用，建议把用户冻结，保留用户信息
     * @param uid
     * @return
     */
    @Override
    public Result<?> delUserById(Integer uid) {
        int update=0;
        Result<?> result=new Result<>(Code.DELETE_ERROR);
        try{
            update = userinfoMapper.deleteById(uid);
            if (update>0){
                result.setCode(Code.DELETE_OK);
                result.setMessage("delete uid = "+uid+" info ok!");
                return result;
            }else {
                result.setMessage("not found id ="+uid+" !");
            }
        }catch (Exception e){
            result.setMessage(e.getMessage());
            return result;
        }
        return result;
    }

    /**
     * 冻结用户
     * @param uid
     * @return
     */
    @Override
    public Result<?> freezeUser(Integer uid) {
        int update=0;
        Result<?> result=new Result<>(Code.DELETE_ERROR);
        UpdateWrapper updateWrapper=new UpdateWrapper();
        updateWrapper.set("rid",0);
        updateWrapper.eq("uid",uid);
        try{
            update = userinfoMapper.update(null,updateWrapper);
            if (update>0){
                result.setCode(Code.DELETE_OK);
                result.setMessage("freeze uid = "+uid+"  ok!");
                return result;
            }else {
                result.setMessage("not found id = "+uid+" !");
            }
        }catch (Exception e){
            result.setMessage(e.getMessage());
            return result;
        }
        return result;
    }


}
