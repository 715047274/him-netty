package com.lmxdawn.him.common.entity.user;

import lombok.Data;

import java.util.Date;

/**
 * table:user  
 */
@Data
public class User {

	/**
 	* 用户id
 	*/
	private Long uid;
	/**
 	* 用户密码
 	*/
	private String pwd;
	/**
 	* 用户昵称
 	*/
	private String name;
	/**
 	* 用户头像
 	*/
	private String avatar;
	/**
 	* 创建时间
 	*/
	private Date createTime;
	/**
 	* 更新时间
 	*/
	private Date modifiedTime;

}
