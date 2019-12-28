package my.mins.jmt.app.food.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import my.mins.jmt.app.common.cd.FoodTypeCd;

import javax.persistence.*;

@Entity
@Table(name = "food")
@Getter
@Setter
@ToString
public class Food {

	@Id
	@GeneratedValue
	private Long id;

	@Enumerated
	@Column(name = "food_type_cd")
	private FoodTypeCd foodTypeCd;

	@Column(name = "store_nm")
	private String storeNm;

	@Column(name = "food_example")
	private String foodEx;

	@Column(name = "avg_point")
	private Integer avgPoint;

	@Column(name = "store_addr")
	private String storeAddr;
}