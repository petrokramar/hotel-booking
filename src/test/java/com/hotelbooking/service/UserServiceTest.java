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
        Authority roleOne = new Authority();
        roleOne.setId(ROLE_ONE_ID);
        roleOne.setAuthority("ROLE_ADMIN");
        roleOne.setUsername("user1");
        rolesUserOne.add(roleOne);
        User userOne = new User();
        userOne.setFirstName("First name user 1");
        userOne.setLastName("Last name user 1");
        userOne.setUsername("user1");
        userOne.setPassword("password1");
        userOne.setRoles(rolesUserOne);
        userOne.setEnabled(true);
        expectedUsers.add(userOne);

        Set<Authority> rolesUserTwo = new HashSet<>();
        Authority roleTwo = new Authority();
        roleTwo.setId(ROLE_TWO_ID);
        roleTwo.setAuthority("ROLE_USER");
        roleTwo.setUsername("user2");
        rolesUserTwo.add(roleTwo);
        User userTwo = new User();
        userTwo.setFirstName("First name user 2");
        userTwo.setLastName("Last name user 2");
        userTwo.setUsername("user2");
        userTwo.setPassword("password2");
        userTwo.setRoles(rolesUserTwo);
        userTwo.setEnabled(true);
        expectedUsers.add(userTwo);

        Set<Authority> rolesUserThree = new HashSet<>();
        Authority roleThree = new Authority();
        roleThree.setId(ROLE_THREE_ID);
        roleThree.setAuthority("ROLE_USER");
        roleThree.setUsername("user3");
        rolesUserThree.add(roleThree);
        User userThree = new User();
        userThree.setFirstName("First name user 3");
        userThree.setLastName("Last name user 3");
        userThree.setUsername("user3");
        userThree.setPassword("password3");
        userThree.setRoles(rolesUserThree);
        userThree.setEnabled(false);
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
        Authority roleOne = new Authority();
        roleOne.setId(ROLE_ONE_ID);
        roleOne.setAuthority("ROLE_ADMIN");
        roleOne.setUsername("user1");
        roles.add(roleOne);
        Authority roleTwo = new Authority();
        roleTwo.setId(ROLE_TWO_ID);
        roleTwo.setAuthority("ROLE_USER");
        roleTwo.setUsername("user1");
        roles.add(roleTwo);
        User expectedUser = new User();
        expectedUser.setFirstName("First name user 1");
        expectedUser.setLastName("Last name user 1");
        expectedUser.setUsername("user1");
        expectedUser.setPassword("password1");
        expectedUser.setRoles(roles);
        expectedUser.setEnabled(true);
        given(userRepository.findOne("user1")).willReturn(expectedUser);

        //when
        User actualUser = userService.getUser("user1");

        //then
        assertEquals(expectedUser, actualUser);
        verify(userRepository).findOne("user1");
        verifyNoMoreInteractions(userRepository);
    }
}