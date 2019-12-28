package my.mins.jmt.app.food.service;

import my.mins.jmt.app.food.entity.Food;
import my.mins.jmt.app.common.cd.FoodTypeCd;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.List;

public interface GetFoodInfo {

	/**
	 * 음식 정보 리스트 조회
	 *
	 * @param location
	 * @param foodTypeCd
	 * @return
	 * @throws IOException
	 */
	List<Food> getFoodInfoList(String location, FoodTypeCd foodTypeCd) throws IOException;

	/**
	 * jsoup으로 가져온 페이지내에 음식 정보가 있는 div 를 리턴 (페이지 마다 tag가 다르니 Scrolling target 페이지에 맞춰 재구현 필요)
	 *
	 * @param htmlPage
	 * @return
	 */
	Element getHtmlElementFromSpecificDiv(Document htmlPage);

	/**
	 * 가게 이름을 가져옴(페이지 마다 tag가 다르니 Scrolling target 페이지에 맞춰 재구현 필요)
	 *
	 * @param element
	 * @return
	 */
	String getStoreNm(Element element);

	/**
	 * 가게에서 판매하는 샘플 음식 명(페이지 마다 tag가 다르니 Scrolling target 페이지에 맞춰 재구현 필요)
	 *
	 * @param element
	 * @return
	 */
	String getFoodEx(Element element);

	/**
	 * 평점(페이지 마다 tag가 다르니 Scrolling target 페이지에 맞춰 재구현 필요)
	 *
	 * @param element
	 * @return
	 */
	String getAvgPoint(Element element);

	/**
	 * 주소(페이지 마다 tag가 다르니 Scrolling target 페이지에 맞춰 재구현 필요)
	 *
	 * @param element
	 * @return
	 */
	String getStoreAddr(Element element);
}
