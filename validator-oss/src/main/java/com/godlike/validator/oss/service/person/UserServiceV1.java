package com.godlike.validator.oss.service.person;

import com.godlike.validator.oss.vo.person.UserQueryV1;
import com.godlike.validator.oss.vo.person.UserVoV1;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public interface UserServiceV1 {
    List<UserVoV1> list(@Valid UserQueryV1 listUserQuery);

    UserVoV1 get(long id);
}
