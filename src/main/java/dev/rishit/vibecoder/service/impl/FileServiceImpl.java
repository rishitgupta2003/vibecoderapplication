package dev.rishit.vibecoder.service.impl;

import dev.rishit.vibecoder.dto.project.FileContentResponse;
import dev.rishit.vibecoder.dto.project.FileNode;
import dev.rishit.vibecoder.service.FileService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Override
    @PreAuthorize(
            "@security.canViewProject(#projectId)"
    )
    public List<FileNode> getFileTree(Long projectId, Long userId) {
        return List.of();
    }

    @Override
    @PreAuthorize(
            "@security.canViewProject(#projectId)"
    )
    public FileContentResponse getFileContent(Long projectId, String path, Long userId) {
        return null;
    }
}
