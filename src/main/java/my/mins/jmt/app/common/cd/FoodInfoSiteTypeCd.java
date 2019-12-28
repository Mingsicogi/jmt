package my.mins.jmt.app.common.cd;

import lombok.AllArgsConstructor;
import lombok.Getter;
import my.mins.jmt.app.common.constants.CommonConstant;
import my.mins.jmt.app.common.constants.FoodConstant;

/**
 * 음식 정보를 가져오는 사이트 정의
 *
 * @author minssogi
 */
@Getter
@AllArgsConstructor
public enum FoodInfoSiteTypeCd {
	DINING_CODE("https://www.diningcode.com", "https://www.diningcode.com/isearch.php?query=%s"),
	MANGO_PLATE("", ""),
	TRIP_ADVISOR("", "");

	private String mainUrl;
	private String searchUrlForm;

	public String getSearchUrl(String location, FoodTypeCd foodType) {
		String queryParam = location + CommonConstant.SPACE + foodType.name() + FoodConstant.GOOD_FOOD_STORE;

		return String.format(this.getSearchUrlForm(), queryParam);
	}
}
