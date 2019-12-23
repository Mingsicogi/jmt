package my.mins.jmt.app.common.cd;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 음식 type
 *
 * @author minssogi
 */
@AllArgsConstructor
@Getter
public enum FoodTypeCd {
	KOREA("한식"),
	CHINA("중식"),
	WESTERN("양식"),
	JAPAN("일식")
	;

	private String krNm;
}
