package my.mins.jmt.app.food.service.impl;

import lombok.extern.slf4j.Slf4j;
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

	private static String fromUrlForm = "https://www.diningcode.com/isearch.php?query=%s";

	private static String queryParam = "%s %s맛집";

	@Override
	public List<Food> getFoodInfoList(String location, FoodTypeCd foodTypeCd) throws IOException {

		// make url
		String url = String.format(fromUrlForm, String.format(queryParam, location, foodTypeCd.getKrNm()));

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
		return element.getElementsByClass("btxt").text();
	}

	@Override
	public String getFoodEx(Element element) {
		return element.getElementsByClass("stxt").text();
	}

	@Override
	public String getAvgPoint(Element element) {
		return element.getElementsByClass("point").text();
	}

	@Override
	public String getStoreAddr(Element element) {
		return element.getElementsByClass("ctxt").text();
	}
}
