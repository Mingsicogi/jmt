package my.mins.jmt.app.food.service.impl;

import lombok.extern.slf4j.Slf4j;
import my.mins.jmt.app.common.cd.FoodInfoSiteTypeCd;
import my.mins.jmt.app.food.entity.Food;
import my.mins.jmt.app.food.service.AbstractCommonGetFoodInfoService;
import my.mins.jmt.app.common.cd.FoodTypeCd;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * 다이닝 코드를 크롤링해서 음식 정보를 가져오는 서비스 구현
 *
 * @author minssogi
 */
@Service
@Slf4j
public class DiningCodeFoodInfo extends AbstractCommonGetFoodInfoService {

	/**
	 * 다이닝 코드 음식정보 리스트 조회
	 *
	 * @param location
	 * @param foodTypeCd
	 * @return
	 * @throws IOException
	 */
	@Override
	public List<Food> getFoodInfoList(String location, FoodTypeCd foodTypeCd) throws IOException {

		// make url
		String url = FoodInfoSiteTypeCd.DINING_CODE.getGetSearchUrlFunction().apply(location, foodTypeCd);

		// get html page
		Document document = super.callPage(url);

		// get specific div
		Element htmlElementFromSpecificDiv = this.getHtmlElementFromSpecificDiv(document);

		// get food list element
		Elements foodListElements = htmlElementFromSpecificDiv.getElementsByTag("li");

		return super.getInfoListFromFoodHomePage(foodTypeCd, foodListElements);
	}

	@Override
	public Element getHtmlElementFromSpecificDiv(Document htmlPage) {
		return htmlPage.getElementById("div_normal");
	}

	@Override
	public String getStoreNm(Element element) {
		String storeNm = element.getElementsByClass("btxt").text();

		// '1. 쉑쉑 버거' 이런식의 데이터가 파싱되기 때문에 데이터 정제가 필요함.
		storeNm = storeNm.split(". ")[1];

		return storeNm;
	}

	@Override
	public String getFoodEx(Element element) {
		return element.getElementsByClass("stxt").text();
	}

	@Override
	public Integer getAvgPoint(Element element) {

		// '70점' 이런식의 데이터가 파싱되기 때문에 '점'을 제거함.
		String pointStr = element.getElementsByClass("point").text().replace("점", "");

		return Integer.parseInt(pointStr);
	}

	@Override
	public String getStoreAddr(Element element) {
		return element.getElementsByClass("ctxt").text();
	}
}
