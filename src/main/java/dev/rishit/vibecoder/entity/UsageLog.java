package dev.rishit.vibecoder.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UsageLog {

    Long id;
    User user;
    Project project;

    Integer tokenUsed;
    Integer durationMs;

    // JSON {model_used, prompt_used}
    String metadata;

    Instant createdAt;

}
