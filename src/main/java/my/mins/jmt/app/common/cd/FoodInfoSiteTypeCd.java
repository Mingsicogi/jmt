package my.mins.jmt.app.common.cd;

import lombok.AllArgsConstructor;
import lombok.Getter;
import my.mins.jmt.app.common.constants.CommonConstant;
import my.mins.jmt.app.common.constants.FoodConstant;

import java.util.function.BiFunction;

/**
 * 음식 정보를 가져오는 사이트 정의
 *
 * @author minssogi
 */
@Getter
@AllArgsConstructor
public enum FoodInfoSiteTypeCd {
	DINING_CODE("https://www.diningcode.com",
		"https://www.diningcode.com/isearch.php?query=%s",
		(location, foodType) -> String.format(FoodInfoSiteTypeCd.DINING_CODE.getSearchUrlForm(), location + CommonConstant.SPACE + foodType.name() + FoodConstant.GOOD_FOOD_STORE)
	),

	MANGO_PLATE("https://www.mangoplate.com",
		"https://www.mangoplate.com/search/%s",
		(location, foodType) -> String.format(FoodInfoSiteTypeCd.DINING_CODE.getSearchUrlForm(), location + CommonConstant.DASH + foodType.name())
	),

	TRIP_ADVISOR("",
		"",
		(location, foodType) -> location + foodType.getKrNm()
	);

	private String mainUrl;
	private String searchUrlForm;
	private BiFunction<String, FoodTypeCd, String> getSearchUrlFunction;
}
