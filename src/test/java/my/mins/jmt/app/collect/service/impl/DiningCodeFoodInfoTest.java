package my.mins.jmt.app.collect.service.impl;

import my.mins.jmt.app.collect.entity.Food;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiningCodeFoodInfoTest {

	@Autowired
	private DiningCodeFoodInfo diningCodeFoodInfo;

	private String fromUrlForm = "https://www.diningcode.com/isearch.php?query=%s";

	private String queryParam = "신논현역 점심맛집";

	@Test
	public void getInfo() {
		Food foodInfo = diningCodeFoodInfo.getInfo(fromUrlForm, queryParam);
		assertThat(foodInfo).isNotNull();
	}
}