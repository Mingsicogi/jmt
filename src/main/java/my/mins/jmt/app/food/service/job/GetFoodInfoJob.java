package my.mins.jmt.app.food.service.job;

import my.mins.jmt.app.food.service.impl.DiningCodeFoodInfo;
import my.mins.jmt.app.food.service.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GetFoodInfoJob {

	@Autowired
	private DiningCodeFoodInfo diningCodeFoodInfo;

	@Resource
	private FoodRepository foodRepository;


	public void getInfoFromDiningCode(){

	}
}
