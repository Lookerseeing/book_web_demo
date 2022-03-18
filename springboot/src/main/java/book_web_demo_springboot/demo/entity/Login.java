package book_web_demo_springboot.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("userinfo")
@Data
public class Login {
    @TableId(value = "uid",type = IdType.AUTO)
    private Integer uid;
    private String username;
    private String password;
    private String nickname;
    private Integer rid;
    private String tel;
}
