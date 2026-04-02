package dev.rishit.vibecoder.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "users")
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(unique = true)
    String email;

    String passwordHash;


    String avatarUrl = "https://static.vecteezy.com/system/resources/previews/026/434/409/non_2x/default-avatar-profile-icon-social-media-user-photo-vector.jpg";

    @ToString.Exclude
    Instant createdAt;
    @ToString.Exclude
    Instant updatedAt;
    @ToString.Exclude
    Instant deletedAt;


}

