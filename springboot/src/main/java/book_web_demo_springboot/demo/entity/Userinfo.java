package book_web_demo_springboot.demo.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.util.Date;

/**
 * @Description  
 * @Author  LookerSeeing
 * @Date 2022-03-18 
 */

@TableName("userinfo" )
@Data
public class Userinfo  implements Serializable {

	private static final long serialVersionUID =  7708036286496842913L;

	/**
	 * 用户id
	 */
	@TableId(value = "uid",type = IdType.AUTO)
	private Long uid;

	/**
	 * 登录名
	 */
	private String username;

	/**
	 * 用户名称
	 */
	private String nickname;

	/**
	 * 登陆密码
	 */
	private String password;

	/**
	 * 角色id
	 */
	private Integer rid;

	/**
	 * 电话
	 */
	private String tel;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 性别
	 */
	private String sex;

	/**
	 * 学校
	 */
	private String school;

	/**
	 * 注册时间
	 */
	private Date createtime;

	/**
	 * 签名
	 */
	private String sign;

	/**
	 * 用户图片路径
	 */
	private String uimageurl;

}
