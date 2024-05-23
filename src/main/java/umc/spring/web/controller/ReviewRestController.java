package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayLoad.ApiResponse;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.service.ReviewService.ReviewCommandService;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/stores/{storeId}/reviews")
    public ApiResponse<ReviewResponseDTO.LeaveReviewResultDto> join(@RequestBody @Valid ReviewRequestDTO.LeaveReviewDto request, @PathVariable Long storeId) {
        request.setStoreId(storeId);
        Review review = reviewCommandService.leaveReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toLeaveReviewResultDTO(review));
    }
}
