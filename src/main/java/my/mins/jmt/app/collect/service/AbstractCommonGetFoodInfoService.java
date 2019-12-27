package my.mins.jmt.app.collect.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public abstract class AbstractCommonGetFoodInfoService {

	public Document callPage(String url) throws IOException {
		return Jsoup.connect(url).get();
	}
}
