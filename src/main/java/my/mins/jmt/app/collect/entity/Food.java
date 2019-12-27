package my.mins.jmt.app.collect.entity;

import lombok.Getter;
import lombok.Setter;
import my.mins.jmt.app.common.cd.FoodTypeCd;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Food {

	@Id
	@GeneratedValue
	private Long id;

	@Enumerated
	@Column(name = "type_cd")
	private FoodTypeCd typeCd;

	@Column(name = "store_nm")
	private String storeNm;

	@Column(name = "store_phone_nm")
	private String storePhoneNm;

	@Column(name = "avg_price")
	private String avgPrice;

	@Column(name = "store_addr")
	private String storeAddr;
}
