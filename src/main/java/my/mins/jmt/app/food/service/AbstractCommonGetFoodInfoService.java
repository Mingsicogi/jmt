package my.mins.jmt.app.food.service;

import my.mins.jmt.app.food.entity.Food;
import my.mins.jmt.app.common.cd.FoodTypeCd;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 음식 정보 크롤링 공통 서비스
 *
 * @author minssogi
 */
public abstract class AbstractCommonGetFoodInfoService implements GetFoodInfo {

	protected Document callPage(String url) throws IOException {
		return Jsoup.connect(url).get();
	}

	protected List<Food> getInfoListFromFoodHomePage(FoodTypeCd foodTypeCd, Elements elements) {

		List<Food> foodInfoList = new ArrayList<>();

		elements.forEach(element -> {

			// set data into Food entity
			Food food = new Food();
			food.setStoreNm(this.getStoreNm(element));
			food.setTypeCd(foodTypeCd);
			food.setFoodEx(this.getFoodEx(element));
			food.setAvgPoint(this.getAvgPoint(element));
			food.setStoreAddr(this.getStoreAddr(element));

			foodInfoList.add(food);

		});

		return foodInfoList;
	}
}
