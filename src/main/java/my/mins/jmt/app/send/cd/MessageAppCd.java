package my.mins.jmt.app.send.cd;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * message app type
 *
 * @author minssogi
 */
@AllArgsConstructor
@Getter
public enum MessageAppCd {
	KAKAO(false, "", ""),
	LINE(true, "https://api.line.me", "/v2/bot/message/push");

	private boolean isUse;
	private String apiUrl;
	private String pushMessageUri;

	public String getPushMessageUrl() {
		return this.apiUrl + this.pushMessageUri;
	}
}