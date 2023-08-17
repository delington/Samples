package com.delington.spring_data.repository;

import com.delington.spring_data.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testAddEntity() {
        final var TEST_EMAIL = "sample@website.com";
        final var TEST_NAME = "sample";

        User sampleUser = new User(TEST_NAME, TEST_EMAIL);
        User savedUser = userRepository.save(sampleUser);

        User retrievedUser = userRepository.findById(savedUser.getId()).orElse(null);

        assertNotNull(retrievedUser);
        // Additional assertions to verify entity values
        assertEquals(retrievedUser.getUsername(), TEST_NAME);
        assertEquals(retrievedUser.getEmail(), TEST_EMAIL);
    }
}