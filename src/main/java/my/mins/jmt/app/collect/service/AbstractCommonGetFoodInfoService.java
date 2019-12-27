package my.mins.jmt.app.collect.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * 음식 정보 크롤링 공통 서비스
 *
 * @author minssogi
 */
public abstract class AbstractCommonGetFoodInfoService {

	protected Document callPage(String url) throws IOException {
		return Jsoup.connect(url).get();
	}
}
