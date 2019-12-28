package my.mins.jmt.app.collect.service;

import my.mins.jmt.app.collect.entity.Food;
import my.mins.jmt.app.common.cd.FoodTypeCd;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.List;

public interface GetFoodInfo {

	List<Food> getFoodInfoList(FoodTypeCd foodTypeCd);

	Element getHtmlElementFromSpecificDiv(Document htmlPage);

	String getStoreNm(Element element);

	String getFoodEx(Element element);

	String getAvgPoint(Element element);

	String getStoreAddr(Element element);
}
