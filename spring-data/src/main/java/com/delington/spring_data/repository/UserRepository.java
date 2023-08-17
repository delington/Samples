package com.delington.spring_data.repository;

import com.delington.spring_data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
