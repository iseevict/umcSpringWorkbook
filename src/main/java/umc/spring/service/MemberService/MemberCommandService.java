package umc.spring.service.MemberService;

import umc.spring.domain.Member;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberRequestDTO;

public interface MemberCommandService {

    public Member joinMember(MemberRequestDTO.MemberJoinDto request);
    public boolean existById(Long id);

    public MemberMission completeMission(Long memberId, Long missionId);
}
