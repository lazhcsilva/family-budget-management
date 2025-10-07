package com.fbm.user;

import static org.junit.jupiter.api.Assertions.*;

import com.fbm.user.model.User;
import org.junit.jupiter.api.Test;

public class UserModelTest {

    @Test
    void createNewUserWithAllParameters() {
        Long expectedId = 1L;
        String expectedFirstName = "Arthur";
        String expectedLastName = "Morgan";
        String expectedEmail = "arthur@example.com";
        String expectedPassword = "123456";

        User user = new User(expectedId, expectedFirstName, expectedLastName, expectedEmail, expectedPassword);

        assertNotNull(user, "User should not be null");
        assertEquals(expectedId, user.getId(), "ID should match");
        assertEquals(expectedFirstName, user.getFirstName(), "First name should match");
        assertEquals(expectedLastName, user.getLastName(), "Last name should match");
        assertEquals(expectedEmail, user.getEmail(), "Email should match");
        assertEquals(expectedPassword, user.getPassword(), "Password should match");
    }

    @Test
    void createNewUserWithNullFirstName() {
        // Arrange & Act & Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new User(1L, null, "Morgan", "arthur@example.com", "123456");
                },
                "Should throw IllegalArgumentException when firstName is null");
    }

    @Test
    void createNewUserWithEmptyFirstName() {
        // Arrange & Act & Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new User(1L, "", "Morgan", "arthur@example.com", "123456");
                },
                "Should throw IllegalArgumentException when firstName is empty");
    }

    @Test
    void createNewUserWithNullLastName() {
        // Arrange & Act & Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new User(1L, "Arthur", null, "arthur@example.com", "123456");
                },
                "Should throw IllegalArgumentException when lastName is null");
    }

    @Test
    void createNewUserWithEmptyLastName() {
        // Arrange & Act & Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new User(1L, "Arthur", "", "arthur@example.com", "123456");
                },
                "Should throw IllegalArgumentException when lastName is empty");
    }

    @Test
    void createNewUserWithNullEmail() {
        // Arrange & Act & Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new User(1L, "Arthur", "Morgan", null, "123456");
                },
                "Should throw IllegalArgumentException when email is null");
    }

    @Test
    void createNewUserWithEmptyEmail() {
        // Arrange & Act & Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new User(1L, "Arthur", "Morgan", "", "123456");
                },
                "Should throw IllegalArgumentException when email is empty");
    }

    @Test
    void createNewUserWithNullPassword() {
        // Arrange & Act & Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new User(1L, "Arthur", "Morgan", "arthur@example.com", null);
                },
                "Should throw IllegalArgumentException when password is null");
    }

    @Test
    void createNewUserWithEmptyPassword() {
        // Arrange & Act & Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new User(1L, "Arthur", "Morgan", "arthur@example.com", "");
                },
                "Should throw IllegalArgumentException when password is empty");
    }

    @Test
    void createNewUserWithNullId() {
        // Arrange & Act & Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new User(null, "Arthur", "Morgan", "arthur@example.com", "123456");
                },
                "Should throw IllegalArgumentException when ID is null");
    }
}
