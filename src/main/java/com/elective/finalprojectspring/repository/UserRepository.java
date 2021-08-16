package com.elective.finalprojectspring.repository;

import com.elective.finalprojectspring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
