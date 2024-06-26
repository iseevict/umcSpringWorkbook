package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayLoad.ApiResponse;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.service.MissionService.MissionQueryService;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
public class MissionRestController {

    private final MissionCommandService missionCommandService;
    private final MissionQueryService missionQueryService;

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

    @GetMapping("/stores/{storeId}/missions")
    public ApiResponse<MissionResponseDTO.storeMissionPreviewListDto> getStoreMissionPreviewList(@PathVariable("storeId") Long storeId, @RequestParam("page") Integer page) {
        Page<Mission> storeMissionPreviewList = missionQueryService.getStoreMissionPreviewList(storeId, page);

        return ApiResponse.onSuccess(MissionConverter.storeMissionPreviewListDto(storeMissionPreviewList));
    }
}
