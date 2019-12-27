package my.mins.jmt.app.collect.service.impl;

import lombok.extern.slf4j.Slf4j;
import my.mins.jmt.app.collect.entity.Food;
import my.mins.jmt.app.collect.service.AbstractCommonGetFoodInfoService;
import my.mins.jmt.app.collect.service.GetFoodInfo;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class DiningCodeFoodInfo extends AbstractCommonGetFoodInfoService implements GetFoodInfo {

	/**
	 * 다이닝코드에서 음식 정보를 가져옴
	 *
	 * @param fromUrl
	 * @return
	 */
	@Override
	public Food getInfo(String fromUrl, String queryParam) {

		// make url
		String url = String.format(fromUrl, queryParam);

		try {
			// curl get and return html code
			Document htmlPage = callPage(url);
			Element div_normal = htmlPage.getElementById("div_normal");
			Elements liList = div_normal.getElementsByTag("li");
//			liList.
			for (Element element : liList) {
				String storeNm = element.getElementsByClass("btxt").text();
				String storeType = element.getElementsByClass("stxt").text();
				String storeAddr = element.getElementsByClass("ctxt").text();
				String storePoint = element.getElementsByClass("point").text();
				log.info("################## {}, {}, {}, {} \n", storeNm, storeType, storeAddr, storePoint);
			}

		} catch (IOException e){
			log.error("ERROR Message : {}", e.getMessage(), e);
		}

		// jsoup parsing

		// set data into Food entity


		return null;
	}
}
