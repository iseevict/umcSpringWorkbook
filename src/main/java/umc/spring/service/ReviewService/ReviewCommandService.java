package umc.spring.service.ReviewService;

import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {

    public Review leaveReview(ReviewRequestDTO.LeaveReviewDto request);
}
