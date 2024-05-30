package umc.spring.service.MemberService;

import org.springframework.data.domain.Page;
import umc.spring.domain.mapping.MemberMission;

public interface MemberQueryService {

    Page<MemberMission> getMemberChallengingMissionList(Long memberId, Integer page);
}
