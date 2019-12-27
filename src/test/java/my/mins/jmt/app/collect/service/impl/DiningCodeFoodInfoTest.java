package my.mins.jmt.app.collect.service.impl;

import my.mins.jmt.app.collect.entity.Food;
import my.mins.jmt.app.collect.service.repository.FoodRepository;
import my.mins.jmt.app.common.cd.FoodTypeCd;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiningCodeFoodInfoTest {

	@Autowired
	private DiningCodeFoodInfo diningCodeFoodInfo;

	@Resource
	private FoodRepository foodRepository;

	private String location;

	private FoodTypeCd foodTypeCd;

	@Test
	public void getInfo() {

		GIVE : {
			location = "신논현역";
			foodTypeCd = FoodTypeCd.WESTERN;
		}

		Food foodInfo = diningCodeFoodInfo.getInfo(location, foodTypeCd);
		assertThat(foodInfo).isNotNull();
	}

	@Test
	public void saveTest(){
		List<Food> all = foodRepository.findAll();

		all.forEach(System.out::println);
	}
}