package com.lmxdawn.him.api.res;

import lombok.Data;

import java.util.Date;

/**
 * 用户信息
 */
@Data
public class UserInfoResponse {

    /**
     * 用户id
     */
    private Long uid;
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

}
