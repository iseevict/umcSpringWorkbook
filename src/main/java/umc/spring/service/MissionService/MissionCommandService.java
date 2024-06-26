package umc.spring.service.MissionService;

import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MissionRequestDTO;

public interface MissionCommandService {
    public Mission createMission(MissionRequestDTO.CreateMissionDto request, Long storeId);
    public MemberMission challengeMission(MissionRequestDTO.ChallengeMissionDto request, Long missionId);
}
