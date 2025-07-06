package com.fbm.user;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.fbm.user.model.User;
import com.fbm.user.repository.UserRepository;
import com.fbm.user.service.impl.UserServiceImpl;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void searchAllUsers() {
        User user1 = new User(1L, "Jose", "Santos", "jose@exemplo.com", "123456");
        User user2 = new User(2L, "Maria", "Santos", "jose@exemplo.com", "123456");
        List<User> expectedUsers = Arrays.asList(user1, user2);

        when(userRepository.findAll()).thenReturn(expectedUsers);
        List<User> actualUsers = userService.getAll();

        assertNotNull(actualUsers, "The returned list of users should not be null.");
        assertEquals(
                expectedUsers.size(),
                actualUsers.size(),
                "The size of the returned list should match the expected size.");
        assertEquals(expectedUsers, actualUsers, "The returned users should match the expected users.");
    }

    @Test
    void searchUserById() {
        User user1 = new User(1234567890123L, "Jose", "Santos", "jose@exemplo.com", "123456");
        assertEquals(1234567890123L, user1.getId());
    }

    @Test
    void searchWrongUserById() {
        User user1 = new User(1234567890123L, "Jose", "Santos", "jose@exemplo.com", "123456");
        assertNotEquals(27, user1.getId());
    }
}
