package dev.rishit.vibecoder.entity;


import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter

public class ProjectFile {

    Long id;
    Project project;

    String path;
    String minioObjectKey;

    Instant createdAt;
    Instant updatedAt;

    User createdBy;
    User updatedBy;

}
