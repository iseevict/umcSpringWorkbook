package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayLoad.ApiResponse;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/stores/{storeId}/missions")
    public ApiResponse<MissionResponseDTO.CreateMissionResultDto> create(@RequestBody MissionRequestDTO.CreateMissionDto request, @PathVariable Long storeId) {
        Mission mission = missionCommandService.createMission(request, storeId);
        return ApiResponse.onSuccess(MissionConverter.toCreateMissionDto(mission));
    }

    @PostMapping("/missions/{missionId}")
    public ApiResponse<MissionResponseDTO.ChallengeMissionResultDto> challenge(@RequestBody MissionRequestDTO.ChallengeMissionDto request, @PathVariable Long missionId) {
        MemberMission memberMission = missionCommandService.challengeMission(request, missionId);
        return ApiResponse.onSuccess(MemberMissionConverter.toChallengeMissionDto(memberMission));
    }
}
