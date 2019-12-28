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
import java.util.List;

@Service
@Slf4j
public class DiningCodeFoodInfo extends AbstractCommonGetFoodInfoService implements GetFoodInfo {

	@Resource
	private FoodRepository foodRepository;

	private static String fromUrlForm = "https://www.diningcode.com/isearch.php?query=%s";

	private static String queryParam = "%s %s맛집";

	@Override
	public List<Food> getFoodInfoList(FoodTypeCd foodTypeCd) {
		return null;
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
