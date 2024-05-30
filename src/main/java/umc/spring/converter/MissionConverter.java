package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public static MissionResponseDTO.storeMissionPreviewDto storeMissionPreviewDto(Mission mission) {
        return MissionResponseDTO.storeMissionPreviewDto.builder()
                .reward(mission.getReward())
                .deadLine(mission.getDeadline())
                .missionSpec(mission.getMissionSpec())
                .build();
    }

    public static MissionResponseDTO.storeMissionPreviewListDto storeMissionPreviewListDto(Page<Mission> storeMissionPreviewList) {

        List<MissionResponseDTO.storeMissionPreviewDto> storeMissionPreviewDtoList = storeMissionPreviewList.stream()
                .map(MissionConverter::storeMissionPreviewDto).collect(Collectors.toList());

        return MissionResponseDTO.storeMissionPreviewListDto.builder()
                .isLast(storeMissionPreviewList.isLast())
                .isFirst(storeMissionPreviewList.isFirst())
                .listSize(storeMissionPreviewDtoList.size())
                .totalElements(storeMissionPreviewList.getTotalElements())
                .totalPage(storeMissionPreviewList.getTotalPages())
                .storeMissionPreviewList(storeMissionPreviewDtoList)
                .build();
    }
}
