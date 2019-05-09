package com.godlike.validator.oss.web.person;

import com.fasterxml.jackson.annotation.JsonView;
import com.godlike.validator.oss.service.person.UserServiceV2;
import com.godlike.validator.oss.vo.person.UserQueryV2;
import com.godlike.validator.oss.vo.person.UserVoV2;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;


@RequestMapping("/user/v2")
@CrossOrigin
@RestController
public class UserApiV2 {
    @Resource
    private UserServiceV2 userServiceV2;

    @GetMapping
    @JsonView({UserVoV2.ListView.class})
    @ResponseStatus(HttpStatus.OK)
    public List<UserVoV2> list(@Valid UserQueryV2 userQuery, @PageableDefault Pageable pageable) {
        return userServiceV2.list(userQuery);
    }
}
