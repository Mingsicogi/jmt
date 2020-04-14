package my.mins.jmt.app.food.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import my.mins.jmt.app.common.cd.FoodTypeCd;
import my.mins.jmt.app.review.entity.Review;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 음식정보 관련 엔티티 정의
 *
 * @author 전민석
 */
@Entity
@Table
@Getter
@Setter
@ToString
public class Food {

	@Id
	@GeneratedValue
	@Column(name = "food_id")
	private Long id;

	@Enumerated
	private FoodTypeCd foodTypeCd;

	private String name;

	@OneToMany(mappedBy = "foodId", fetch = FetchType.LAZY)
	private List<Review> reviews = new ArrayList<>();
}
