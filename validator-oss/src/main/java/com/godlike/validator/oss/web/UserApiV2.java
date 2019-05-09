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


@RequestMapping("/user/v2")
@CrossOrigin
@RestController
public class UserApiV2 {
    @Resource
    private UserService userService;

    @GetMapping
    @JsonView({UserVo.ListViewV1.class})
    @ResponseStatus(HttpStatus.OK)
    public List<UserVo> list(@Valid UserQuery userQuery, @PageableDefault Pageable pageable) {
        return userService.list(userQuery);
    }

    @GetMapping("/{id}")
    @JsonView({UserVo.GetViewV1.class})
    @ResponseStatus(HttpStatus.OK)
    public UserVo get(@PathVariable long id) {
        return userService.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserVo create(@Validated({UserVo.CreateGroupV1.class}) @RequestBody UserVo userVo) {
        return userVo;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserVo update(@PathVariable long id, @Validated({UserVo.UpdateGroupV1.class}) @RequestBody UserVo userVo) {
        return userVo;

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {

    }
}
