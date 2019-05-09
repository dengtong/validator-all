package com.godlike.validator.oss.service.person.impl;

import com.godlike.validator.oss.service.person.UserServiceV1;
import com.godlike.validator.oss.vo.person.UserQueryV1;
import com.godlike.validator.oss.vo.person.UserVoV1;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceV1Impl implements UserServiceV1 {
    public List<UserVoV1> list(@Valid UserQueryV1 listUserQuery) {
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
