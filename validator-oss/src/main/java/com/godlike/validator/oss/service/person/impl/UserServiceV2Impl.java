package com.godlike.validator.oss.service.person.impl;

import com.godlike.validator.oss.service.person.UserServiceV2;
import com.godlike.validator.oss.vo.person.UserQueryV2;
import com.godlike.validator.oss.vo.person.UserVoV2;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceV2Impl implements UserServiceV2 {
    public List<UserVoV2> list(@Valid UserQueryV2 listUserQuery) {
        UserVoV2 userVo = new UserVoV2();
        userVo.setPhone(listUserQuery.getPhone());
        userVo.setName("tom");
        userVo.setId("123456789");
        userVo.setIdNumber("162747189504150445");
        userVo.setDelete(false);
        userVo.setNickName("cat");
        userVo.setSex("man");
        userVo.setProfilePhoto("image");
        List<UserVoV2> userVoList = new ArrayList<>();
        userVoList.add(userVo);
        return userVoList;
    }

}
