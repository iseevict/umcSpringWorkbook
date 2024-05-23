package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDateTime;

public class MissionRequestDTO {

    @Getter
    public static class CreateMissionDto {
        @NotNull
        Integer reward;
        @NotNull
        String missionSpec;
    }
}
