package com.lmxdawn.him.api.service.user;

import com.lmxdawn.him.api.vo.res.UserInfoListResVO;
import com.lmxdawn.him.common.entity.user.User;

import java.util.List;

public interface UserService {

    User findByUid(Long uid);

    List<UserInfoListResVO> listByUidIn(List<Long> uids);

    boolean insertUser(User user);

    boolean updateUser(User user);

    boolean deleteByUid(Long uid);

}
