package com.godlike.validator.oss.service.person.impl;

import com.godlike.validator.oss.exception.InternalServerErrorException;
import com.godlike.validator.oss.service.person.UserServiceV1;
import com.godlike.validator.oss.vo.person.UserQueryV1;
import com.godlike.validator.oss.vo.person.UserVoV1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceV1Impl implements UserServiceV1 {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceV1Impl.class);

    public List<UserVoV1> list(@Valid UserQueryV1 listUserQuery) throws InternalServerErrorException {
        UserVoV1 userVo = new UserVoV1();
        userVo.setPhone(listUserQuery.getPhone());
        userVo.setName("tom");
        userVo.setId("123456789");
        userVo.setIdNumber("162747189504150445");
        userVo.setDelete(false);
        userVo.setNickName("cat");
        userVo.setSex("man");
        userVo.setProfilePhoto("image");
        List<UserVoV1> userVoList = new ArrayList<>();
        userVoList.add(userVo);
        try {
            long a = Long.valueOf("abc");
        } catch (Exception e) {
            LOGGER.error("{}", e.getStackTrace());
            throw new InternalServerErrorException("转换错误", e.getCause(), "500001");
        }

        return userVoList;
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
