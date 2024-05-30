package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.enums.MissionStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MemberResponseDTO {

    @Builder @Getter @NoArgsConstructor @AllArgsConstructor
    public static class MemberJoinResultDto {
        Long memberId;
        LocalDateTime createdAt;
    }

    @Builder @Getter @NoArgsConstructor @AllArgsConstructor
    public static class MemberChallengingMissionListDto {
        List<MemberChallengingMissionDto> memberChallengingMissionList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder @Getter @NoArgsConstructor @AllArgsConstructor
    public static class MemberChallengingMissionDto {
        String storeName;
        Integer reward;
        String missionSpec;
        LocalDate deadLine;
        MissionStatus status;
    }
}
