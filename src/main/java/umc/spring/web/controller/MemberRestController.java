package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayLoad.ApiResponse;
import umc.spring.converter.MemberConverter;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MemberService.MemberCommandService;
import umc.spring.service.MemberService.MemberQueryService;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.MemberResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.MemberJoinResultDto> join(@RequestBody @Valid MemberRequestDTO.MemberJoinDto request) {
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @GetMapping("/{memberId}/missions")
    public ApiResponse<MemberResponseDTO.MemberChallengingMissionListDto> getMemberChallengingMissionList(@PathVariable("memberId") Long memberId, @RequestParam("page") Integer page) {

        Page<MemberMission> memberChallengingMissionList = memberQueryService.getMemberChallengingMissionList(memberId, page);
        return ApiResponse.onSuccess(MemberMissionConverter.getMemberChallengingMissionListDto(memberChallengingMissionList));
    }
}
