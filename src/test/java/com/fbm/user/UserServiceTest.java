package com.fbm.user;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fbm.common.handler.BusinessException;
import com.fbm.user.model.User;
import com.fbm.user.repository.UserRepository;
import com.fbm.user.service.impl.UserServiceImpl;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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
        Long id = 1L;
        User expectedUser = new User(id, "Jose", "Santos", "jose@exemplo.com", "123456");
        when(userRepository.findById(id)).thenReturn(Optional.of(expectedUser));

        User actualUser = userService.findById(id);

        assertNotNull(actualUser, "User should be found");
        assertEquals(id, actualUser.getId(), "ID should match");
        assertEquals("Jose", actualUser.getFirstName(), "First name should match");
        assertEquals("Santos", actualUser.getLastName(), "Last name should match");
        assertEquals("jose@exemplo.com", actualUser.getEmail(), "Email should match");
        assertEquals("123456", actualUser.getPassword(), "Password should match");
    }

    @Test
    void searchUserByIdNotFound() {
        Long invalidId = 999L;
        when(userRepository.findById(invalidId)).thenReturn(Optional.empty());

        assertThrows(
                BusinessException.class,
                () -> {
                    userService.findById(invalidId);
                },
                "Should throw BusinessException when ID is not found");
    }

    @Test
    void updateUser() {
        Long id = 1L;
        User existingUser = new User(id, "Jose", "Santos", "jose@exemplo.com", "123456");
        User updatedUser = new User(id, "Maria", "Santos", "jose@exemplo.com", "123456");
        when(userRepository.findById(id)).thenReturn(Optional.of(existingUser));
        when(userRepository.save(any(User.class))).thenReturn(updatedUser);

        userService.update(id, updatedUser);

        verify(userRepository).save(updatedUser);
        User savedUser = userRepository.save(updatedUser);
        when(userRepository.findById(id)).thenReturn(Optional.of(updatedUser));
        User foundUser = userService.findById(id);
        assertEquals("Maria", foundUser.getFirstName(), "First name should be updated");
        assertEquals("Santos", foundUser.getLastName(), "Last name should remain unchanged");
        assertEquals("jose@exemplo.com", foundUser.getEmail(), "Email should remain unchanged");
        assertEquals("123456", foundUser.getPassword(), "Password should remain unchanged");
    }

    @Test
    void updateUserWithInvalidId() {
        Long invalidId = 999L;
        User updatedUser = new User(invalidId, "Maria", "Santos", "jose@exemplo.com", "123456");
        when(userRepository.findById(invalidId)).thenReturn(Optional.empty());

        assertThrows(
                BusinessException.class,
                () -> {
                    userService.update(invalidId, updatedUser);
                },
                "Should throw BusinessException when ID is not found");
    }

}
