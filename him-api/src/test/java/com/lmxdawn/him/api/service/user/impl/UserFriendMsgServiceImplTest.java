package com.lmxdawn.him.api.service.user.impl;

import com.lmxdawn.him.api.BaseApplicationTest;
import com.lmxdawn.him.api.service.user.UserFriendMsgService;
import com.lmxdawn.him.common.entity.user.UserFriendMsg;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;

public class UserFriendMsgServiceImplTest extends BaseApplicationTest {

    @Resource
    private UserFriendMsgService userFriendMsgService;

    @Test
    public void listByLastMsgId() {

    }

    @Test
    public void insertUserOfflineMsg() {

        UserFriendMsg userFriendMsg = new UserFriendMsg();
        userFriendMsg.setReceiverUid(1L);
        userFriendMsg.setSenderUid(2L);
        userFriendMsg.setMsgType(0);
        userFriendMsg.setMsgContent("ssssss");

        boolean b = userFriendMsgService.insertUserFriendMsg(userFriendMsg);

        assertNotNull(userFriendMsg.getMsgId());

    }
}
