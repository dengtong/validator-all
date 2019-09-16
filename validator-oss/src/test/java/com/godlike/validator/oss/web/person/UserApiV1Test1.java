package com.godlike.validator.oss.web.person;

import com.godlike.validator.oss.exception.InternalServerErrorException;
import com.godlike.validator.oss.service.person.UserServiceV1;
import com.godlike.validator.oss.vo.person.UserQueryV1;
import com.godlike.validator.oss.vo.person.UserVoV1;
import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.MockitoAnnotations.initMocks;

public class UserApiV1Test1 {
    @Mock
    UserServiceV1 userServiceV1;
    private UserApiV1 userApiV1;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        userApiV1 = new UserApiV1(userServiceV1);
    }

    @Test
    public void list() {

        UserQueryV1 userQueryV1 = new UserQueryV1();
        userQueryV1.setPhone("18501995564");
        Pageable pageable = PageRequest.of(0, 10);
        try {
            List<UserVoV1> userVoList = new ArrayList<>();
            BDDMockito.given(userServiceV1.list(userQueryV1)).willReturn(userVoList);
            userApiV1.list(userQueryV1, pageable);
        } catch (InternalServerErrorException e) {
            e.printStackTrace();
        }
    }
}