package com.godlike.validator.oss.service;

import com.godlike.validator.oss.vo.UserQuery;
import com.godlike.validator.oss.vo.UserVo;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    public List<UserVo> list(@Valid UserQuery listUserQuery) {
        UserVo userVo = new UserVo();
        userVo.setPhone(listUserQuery.getPhone());
        userVo.setName("tom");
        userVo.setId("123456789");
        userVo.setIdNumber("162747189504150445");
        userVo.setDelete(false);
        userVo.setNickName("cat");
        userVo.setSex("man");
        userVo.setProfilePhoto("image");
        List<UserVo> userVoList = new ArrayList<>();
        userVoList.add(userVo);
        return userVoList;
    }

    public UserVo get(long id) {
        UserVo userVo = new UserVo();
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
