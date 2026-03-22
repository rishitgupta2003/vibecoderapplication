package dev.rishit.vibecoder.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Plan {

    Long id;
    String name;

    String stripePriceId;
    Integer maxProject;
    Integer maxTokenPerDay;
    Integer maxPreviews; //Max Number of previews allowed per plan
    Boolean unlimitedAi; //Unlimited Access to LLM, Ignore maxTokensPerDay if true

    Boolean active;

}