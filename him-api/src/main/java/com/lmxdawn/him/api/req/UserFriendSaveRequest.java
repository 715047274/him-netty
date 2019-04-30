package com.lmxdawn.him.api.req;

import com.lmxdawn.him.common.req.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * 添加好友
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserFriendSaveRequest extends BaseRequest {

    /**
     * 用户的ID
     */
    @NotNull(message = "参数错误！")
    private Long uid;

    /**
     * 朋友的ID
     */
    @NotNull(message = "参数错误！")
    private Long friendUid;

    /**
     * 朋友的备注
     */
    private String remark;

}
