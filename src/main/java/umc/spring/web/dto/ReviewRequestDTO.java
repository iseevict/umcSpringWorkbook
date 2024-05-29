package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

public class ReviewRequestDTO {

    @Getter
    public static class LeaveReviewDto {
        @Size(max = 500)
        String body;
        @NotNull
        String title;
        @NotNull
        Float score;
        @Setter // 이렇게 해도 되나..??
        Long storeId;
        @NotNull
        Long memberId;

    }
}
