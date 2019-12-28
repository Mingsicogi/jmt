package my.mins.jmt.app.collect.service;

import my.mins.jmt.app.collect.entity.Food;
import my.mins.jmt.app.common.cd.FoodTypeCd;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 음식 정보 크롤링 공통 서비스
 *
 * @author minssogi
 */
public abstract class AbstractCommonGetFoodInfoService {

	protected Document callPage(String url) throws IOException {
		return Jsoup.connect(url).get();
	}

	protected List<Food> getInfoListFromFoodHomePage(GetFoodInfo getFoodInfo, FoodTypeCd foodTypeCd, Elements elements) {

		List<Food> foodInfoList = new ArrayList<>();

		elements.forEach(element -> {
			// set data into Food entity
			Food food = new Food();
			food.setStoreNm(getFoodInfo.getStoreNm(element));
			food.setTypeCd(foodTypeCd);
			food.setFoodEx(getFoodInfo.getFoodEx(element));
			food.setAvgPoint(getFoodInfo.getAvgPoint(element));
			food.setStoreAddr(getFoodInfo.getStoreAddr(element));

			foodInfoList.add(food);

		});

		return foodInfoList;
	}
}
