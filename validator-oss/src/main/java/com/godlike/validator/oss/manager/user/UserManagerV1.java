package com.godlike.validator.oss.manager.user;

import com.godlike.validator.oss.exception.InternalServerErrorException;
import com.godlike.validator.oss.vo.person.UserQueryV1;
import com.godlike.validator.oss.vo.person.UserVoV1;

import javax.validation.Valid;
import java.util.List;

public interface UserManagerV1 {
    List<UserVoV1> list(@Valid UserQueryV1 listUserQuery) throws InternalServerErrorException;
}
