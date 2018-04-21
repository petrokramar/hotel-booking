package com.hotelbooking.service;

import com.hotelbooking.entity.Authority;
import com.hotelbooking.entity.User;
import com.hotelbooking.repository.UserRepository;
import com.hotelbooking.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class UserServiceTest {

    private final int ROLE_ONE_ID = 1;
    private final int ROLE_TWO_ID = 2;
    private final int ROLE_THREE_ID = 3;
    private final boolean USER_ENABLED = true;
    private final boolean USER_NOT_ENABLED = false;
    private UserRepository userRepository;
    private UserService userService;

    @Before
    public void setUp() {
        userRepository = mock(UserRepository.class);
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    public void getAllUsers() {

        // given
        List<User> expectedUsers = new ArrayList<>();

        Set<Authority> rolesUserOne = new HashSet<>();
        Authority roleOne = new Authority(ROLE_ONE_ID, "userOne", "ROLE_ADMIN");
        rolesUserOne.add(roleOne);
        User userOne = new User("userOne", "password userOne", USER_ENABLED,
                "First name userOne","Last name userOne", rolesUserOne);
        expectedUsers.add(userOne);

        Set<Authority> rolesUserTwo = new HashSet<>();
        Authority roleTwo = new Authority(ROLE_TWO_ID, "userTwo", "ROLE_USER");
        rolesUserTwo.add(roleTwo);
        User userTwo = new User("userTwo", "password userTwo", USER_ENABLED,
                "First name userTwo","Last name userTwo", rolesUserTwo);
        expectedUsers.add(userTwo);

        Set<Authority> rolesUserThree = new HashSet<>();
        Authority roleThree = new Authority(ROLE_THREE_ID, "userThree", "ROLE_USER");
        rolesUserThree.add(roleThree);
        User userThree = new User("userThree", "password userThree", USER_NOT_ENABLED,
                "First name userThree","Last name userThree", rolesUserThree);
        expectedUsers.add(userThree);

        given(userRepository.findAll()).willReturn(expectedUsers);

        //when
        List<User> actualUsers = userService.getAllUsers();

        //then
        assertEquals(expectedUsers, actualUsers);
        verify(userRepository).findAll();
        verifyNoMoreInteractions(userRepository);
    }

    @Test
    public void getUser() {

        // given
        Set<Authority> roles = new HashSet<>();
        Authority roleOne = new Authority(ROLE_ONE_ID, "username", "ROLE_ADMIN");
        roles.add(roleOne);
        Authority roleTwo = new Authority(ROLE_ONE_ID, "username", "ROLE_USER");
        roles.add(roleTwo);
        User expectedUser = new User("username", "password", USER_ENABLED,
                "First name","Last name", roles);
        given(userRepository.findOne("user1")).willReturn(expectedUser);

        //when
        User actualUser = userService.getUser("user1");

        //then
        assertEquals(expectedUser, actualUser);
        verify(userRepository).findOne("user1");
        verifyNoMoreInteractions(userRepository);
    }
}