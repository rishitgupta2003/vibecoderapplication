package dev.rishit.vibecoder.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;


@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class User {
    @Id
    Long id;

    @Column(unique = true)
    String email;

    String passwordHash;

    String avatarUrl;
    Instant createdAt;
    Instant updatedAt;

    Instant deletedAt;
}
