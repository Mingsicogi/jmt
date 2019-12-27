package my.mins.jmt.app.collect.service.impl;

import lombok.extern.slf4j.Slf4j;
import my.mins.jmt.app.collect.entity.Food;
import my.mins.jmt.app.collect.service.AbstractCommonGetFoodInfoService;
import my.mins.jmt.app.collect.service.GetFoodInfo;
import my.mins.jmt.app.collect.service.repository.FoodRepository;
import my.mins.jmt.app.common.cd.FoodTypeCd;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

@Service
@Slf4j
public class DiningCodeFoodInfo extends AbstractCommonGetFoodInfoService implements GetFoodInfo {

	@Resource
	private FoodRepository foodRepository;

	private static String fromUrlForm = "https://www.diningcode.com/isearch.php?query=%s";

	private static String queryParam = "%s %s맛집";

	/**
	 * 다이닝코드에서 음식 정보를 가져옴
	 *
	 * @param location
	 * @param foodTypeCd
	 * @return
	 */
	@Override
	public Food getInfo(String location, FoodTypeCd foodTypeCd) {

		// make url
		String url = String.format(fromUrlForm, String.format(queryParam, location, foodTypeCd.getKrNm()));

		Food dbInfo = null;
		try {
			// curl get and return html code
			Document htmlPage = callPage(url);

			// jsoup parsing
			Element div_normal = htmlPage.getElementById("div_normal");
			Elements liList = div_normal.getElementsByTag("li");

			for (Element element : liList) {
				String storeNm = element.getElementsByClass("btxt").text();
				String foodEx = element.getElementsByClass("stxt").text();
				String storeAddr = element.getElementsByClass("ctxt").text();
				String storePoint = element.getElementsByClass("point").text();

				// set data into Food entity
				Food food = new Food();
				food.setStoreNm(storeNm);
				food.setTypeCd(foodTypeCd);
				food.setFoodEx(foodEx);
				food.setAvgPoint(storePoint);
				food.setStoreAddr(storeAddr);

				dbInfo = foodRepository.save(food);

				log.info("################## {}, {}, {}, {} \n", storeNm, foodEx, storeAddr, storePoint);
			}

		} catch (IOException e) {
			log.error("ERROR Message : {}", e.getMessage(), e);
		}

		return dbInfo;
	}
}
