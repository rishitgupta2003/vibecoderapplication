package dev.rishit.vibecoder.service;

import dev.rishit.vibecoder.dto.project.FileContentResponse;
import dev.rishit.vibecoder.dto.project.FileNode;

import java.util.List;

public interface FileService {
    List<FileNode> getFileTree(Long projectId, Long userId);

    FileContentResponse getFileContent(Long projectId, String path, Long userId);
}
