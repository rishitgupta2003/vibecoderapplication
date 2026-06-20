package dev.rishit.vibecoder.enums;

import lombok.Getter;

@Getter
public enum ModelType {

    CLAUDE_SONNET_4_5("claude-sonnet-4-5@20250929"),
    GPT_5_1_CODEX("gpt-5.1-codex-mini-2025-11-13");

    private final String modelName;

    ModelType(String modelName) {
        this.modelName = modelName;
    }
}
