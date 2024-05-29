package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import umc.spring.domain.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@DynamicUpdate
@DynamicInsert
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String body;

    @Column(nullable = false)
    private Float score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    // 연관관계 편의 메서드
    public void setStore(Store store) { // 리뷰 추가하면서 가게 score 까지 업데이트
        if (this.store != null) {
            this.store.getReviewList().remove(this);
        }
        this.store = store;
        int reviewSize = store.getReviewList().size();
        float totalScore = store.getScore() * reviewSize;
        float updateScore = (totalScore + this.score) / (reviewSize + 1);
        store.updateScore(updateScore);
        store.getReviewList().add(this);
    }

    public void setMember(Member member) {
        if (this.member != null) {
            this.member.getReviewList().remove(this);
        }
        this.member = member;
        member.getReviewList().add(this);
    }
}
