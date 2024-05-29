package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {

    public static ReviewResponseDTO.LeaveReviewResultDto toLeaveReviewResultDTO (Review review) {
        return ReviewResponseDTO.LeaveReviewResultDto.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review leaveReview(ReviewRequestDTO.LeaveReviewDto request) {
        return Review.builder()
                .title(request.getTitle())
                .body(request.getBody())
                .score(request.getScore())
                .store(null)
                .member(null)
                .build();
    }

    public static ReviewResponseDTO.ReviewPreviewDto reviewPreviewDto(Review review) {
        return ReviewResponseDTO.ReviewPreviewDto.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }

    public static ReviewResponseDTO.ReviewPreviewListDto reviewPreviewListDto(Page<Review> reviewList) {

        List<ReviewResponseDTO.ReviewPreviewDto> reviewPreviewDtoList = reviewList.stream()
                .map(ReviewConverter::reviewPreviewDto).collect(Collectors.toList());

        return ReviewResponseDTO.ReviewPreviewListDto.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreviewDtoList.size())
                .reviewList(reviewPreviewDtoList)
                .build();
    }
}
