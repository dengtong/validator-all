package com.godlike.validator.oss.service.person.impl;

import com.godlike.validator.oss.exception.InternalServerErrorException;
import com.godlike.validator.oss.manager.user.UserManagerV1;
import com.godlike.validator.oss.service.person.UserServiceV1;
import com.godlike.validator.oss.vo.person.UserQueryV1;
import com.godlike.validator.oss.vo.person.UserVoV1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Service
public class UserServiceV1Impl implements UserServiceV1 {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceV1Impl.class);
    @Resource
    private UserManagerV1 userManagerV1;

    public List<UserVoV1> list(@Valid UserQueryV1 listUserQuery) throws InternalServerErrorException {
        return userManagerV1.list(listUserQuery);
    }

    public UserVoV1 get(long id) {
        UserVoV1 userVo = new UserVoV1();
        userVo.setPhone("18511223366");
        userVo.setName("tom");
        userVo.setId(String.valueOf(id));
        userVo.setIdNumber("162747189504150445");
        userVo.setDelete(false);
        userVo.setNickName("cat");
        userVo.setSex("man");
        userVo.setProfilePhoto("image");
        return userVo;
    }
}
