package dev.rishit.vibecoder.repository;

import dev.rishit.vibecoder.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
