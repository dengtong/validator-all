package com.godlike.validator.oss.service.person;

import com.godlike.validator.oss.vo.person.UserQueryV2;
import com.godlike.validator.oss.vo.person.UserVoV2;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public interface UserServiceV2 {
    List<UserVoV2> list(@Valid UserQueryV2 listUserQuery);
}
