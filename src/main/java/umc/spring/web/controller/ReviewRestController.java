package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayLoad.ApiResponse;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.service.ReviewService.ReviewCommandService;
import umc.spring.service.ReviewService.ReviewQueryService;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;
    private final ReviewQueryService reviewQueryService;

    @PostMapping("/stores/{storeId}/reviews")
    public ApiResponse<ReviewResponseDTO.LeaveReviewResultDto> join(@RequestBody @Valid ReviewRequestDTO.LeaveReviewDto request, @PathVariable Long storeId) {
        request.setStoreId(storeId);
        Review review = reviewCommandService.leaveReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toLeaveReviewResultDTO(review));
    }

    @GetMapping("/stores/{storeId}/reviews")
    public ApiResponse<ReviewResponseDTO.ReviewPreviewListDto> getReviewList(@PathVariable("storeId") Long storeId, @RequestParam("page") Integer page) {
        Page<Review> reviewList = reviewQueryService.getReviewList(storeId, page);

        return ApiResponse.onSuccess(ReviewConverter.reviewPreviewListDto(reviewList));
    }
}
