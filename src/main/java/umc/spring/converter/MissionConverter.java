package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class MissionConverter {

    public static MissionResponseDTO.CreateMissionResultDto toCreateMissionDto(Mission mission) {
        return MissionResponseDTO.CreateMissionResultDto.builder()
                .missionId(mission.getId())
                .createdAt(mission.getCreatedAt())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.CreateMissionDto request) {
        LocalDate deadline = LocalDate.now().plusDays(7);

        return Mission.builder()
                .reward(request.getReward())
                .deadline(deadline)
                .missionSpec(request.getMissionSpec())
                .store(null)
                .memberMissionList(new ArrayList<>())
                .build();
    }
}
