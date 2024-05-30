package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberResponseDTO;
import umc.spring.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class MemberMissionConverter {

    public static MissionResponseDTO.ChallengeMissionResultDto toChallengeMissionDto(MemberMission memberMission) {
        return MissionResponseDTO.ChallengeMissionResultDto.builder()
                .memberMissionId(memberMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static MemberMission toMemberMission(Member member, Mission mission) {
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .build();
    }

    public static MemberResponseDTO.MemberChallengingMissionDto getMemberChallengingMissionDto(MemberMission memberMission) {
        return MemberResponseDTO.MemberChallengingMissionDto.builder()
                .storeName(memberMission.getMission().getStore().getName())
                .reward(memberMission.getMission().getReward())
                .missionSpec(memberMission.getMission().getMissionSpec())
                .deadLine(memberMission.getMission().getDeadline())
                .status(memberMission.getStatus())
                .build();
    }

    public static MemberResponseDTO.MemberChallengingMissionListDto getMemberChallengingMissionListDto(Page<MemberMission> memberChallengingMissionList) {

        List<MemberResponseDTO.MemberChallengingMissionDto> memberChallengingMissionDtoList = memberChallengingMissionList.stream()
                .map(MemberMissionConverter::getMemberChallengingMissionDto).collect(Collectors.toList());

        return MemberResponseDTO.MemberChallengingMissionListDto.builder()
                .isLast(memberChallengingMissionList.isLast())
                .isFirst(memberChallengingMissionList.isFirst())
                .listSize(memberChallengingMissionDtoList.size())
                .totalPage(memberChallengingMissionList.getTotalPages())
                .totalElements(memberChallengingMissionList.getTotalElements())
                .memberChallengingMissionList(memberChallengingMissionDtoList)
                .build();
    }

    public static MemberResponseDTO.MemberCompleteMissionDto completeMissionDto(MemberMission memberMission) {
        return MemberResponseDTO.MemberCompleteMissionDto.builder()
                .id(memberMission.getId())
                .status(memberMission.getStatus())
                .build();
    }
}
