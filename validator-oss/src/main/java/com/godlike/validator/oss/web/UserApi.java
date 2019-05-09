package com.godlike.validator.oss.web;

import com.fasterxml.jackson.annotation.JsonView;
import com.godlike.validator.oss.service.UserService;
import com.godlike.validator.oss.vo.UserQuery;
import com.godlike.validator.oss.vo.UserVo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;


@RequestMapping("/v1/user")
@CrossOrigin
@RestController
public class UserApi {
    @Resource
    private UserService userService;

    @GetMapping
    @JsonView({UserVo.listUserVoView.class})
    @ResponseStatus(HttpStatus.OK)
    public List<UserVo> listUser(@Valid UserQuery userQuery, @PageableDefault Pageable pageable) {
        return userService.listUser(userQuery);
    }

    @GetMapping("/{id}")
    @JsonView({UserVo.getUserVoView.class})
    @ResponseStatus(HttpStatus.OK)
    public UserVo getUser(@PathVariable long id) {
        return userService.getUser(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserVo createUser(@Validated({UserVo.UserVoCreateGroup.class}) @RequestBody UserVo userVo) {
        return userVo;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public UserVo updateUser(@Validated({UserVo.UserVoUpdateGroup.class}) @RequestBody UserVo userVo) {
        return userVo;

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {

    }
}
