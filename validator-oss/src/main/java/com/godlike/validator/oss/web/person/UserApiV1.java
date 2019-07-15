package com.godlike.validator.oss.web.person;

import com.fasterxml.jackson.annotation.JsonView;
import com.godlike.validator.oss.exception.InternalServerErrorException;
import com.godlike.validator.oss.service.person.UserServiceV1;
import com.godlike.validator.oss.vo.person.UserQueryV1;
import com.godlike.validator.oss.vo.person.UserVoV1;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;


@RequestMapping("/user/v1")
@CrossOrigin
@RestController
public class UserApiV1 {
    @Resource
    private UserServiceV1 userServiceV1;

    @GetMapping
    @JsonView({UserVoV1.ListView.class})
    @ResponseStatus(HttpStatus.OK)
    public List<UserVoV1> list(@Valid UserQueryV1 userQuery, @PageableDefault Pageable pageable) throws InternalServerErrorException {
        return userServiceV1.list(userQuery);
    }

    @GetMapping("/{id}")
    @JsonView({UserVoV1.GetView.class})
    @ResponseStatus(HttpStatus.OK)
    public UserVoV1 get(@PathVariable long id) {
        return userServiceV1.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserVoV1 create(@Validated({UserVoV1.CreateGroup.class}) @RequestBody UserVoV1 userVo) {
        return userVo;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserVoV1 update(@PathVariable long id, @Validated({UserVoV1.UpdateGroup.class}) @RequestBody UserVoV1 userVo) {
        return userVo;

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {

    }
}
