package my.mins.jmt.app.food.service.job;

import my.mins.jmt.app.food.service.impl.DiningCodeFoodInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetFoodInfoJob {

	@Autowired
	private DiningCodeFoodInfo diningCodeFoodInfo;

	public void getInfoFromDiningCode(){

	}
}
