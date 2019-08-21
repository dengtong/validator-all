package com.godlike.validator.oss.manager.user.impl;

import com.godlike.validator.oss.cache.operator.ListCacheOperator;
import com.godlike.validator.oss.enums.cache.CacheTimeoutEnum;
import com.godlike.validator.oss.exception.InternalServerErrorException;
import com.godlike.validator.oss.manager.user.UserManagerV1;
import com.godlike.validator.oss.vo.person.UserQueryV1;
import com.godlike.validator.oss.vo.person.UserVoV1;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserManagerV1Impl implements UserManagerV1 {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserManagerV1Impl.class);
    @Resource
    private ListCacheOperator<UserVoV1> userVoV1ListCacheOperator;

    @Override
    public List<UserVoV1> list(@Valid UserQueryV1 listUserQuery) throws InternalServerErrorException {
        List<UserVoV1> userVoList = new ArrayList<>();
        List<Object> keySuffixes = new ArrayList<>();
        keySuffixes.add("users");
        userVoList = userVoV1ListCacheOperator.getAll(keySuffixes);
        if (CollectionUtils.isEmpty(userVoList)) {
            synchronized (this) {
                userVoList = userVoV1ListCacheOperator.getAll(keySuffixes);
                if (CollectionUtils.isEmpty(userVoList)) {
                    UserVoV1 userVo = new UserVoV1();
                    userVo.setPhone(listUserQuery.getPhone());
                    userVo.setName("tom");
                    userVo.setId("123456789");
                    userVo.setIdNumber("162747189504150445");
                    userVo.setDelete(false);
                    userVo.setNickName("cat");
                    userVo.setSex("man");
                    userVo.setProfilePhoto("image");

                    userVoList.add(userVo);
//        try {
//            long a = Long.valueOf("abc");
//        } catch (Exception e) {
//            LOGGER.error("{}", e.getStackTrace());
//            throw new InternalServerErrorException("转换错误", e.getCause(), "500001");
//        }
                }
            }
            userVoV1ListCacheOperator.rightPushAll(keySuffixes, userVoList, CacheTimeoutEnum.HOURS_1, true);
        }


        return userVoList;
    }
}
