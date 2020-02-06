package my.mins.jmt.app.recommend.service.impl;

import com.linecorp.bot.model.message.FlexMessage;
import com.linecorp.bot.model.message.flex.container.FlexContainer;
import my.mins.jmt.app.common.cd.FoodTypeCd;
import my.mins.jmt.app.food.entity.Food;
import my.mins.jmt.app.food.service.impl.DiningCodeFoodInfo;
import my.mins.jmt.app.recommend.service.RecommendService;
import my.mins.jmt.app.send.dto.MessageDTO;
import my.mins.jmt.app.send.entity.LineBotChat;
import my.mins.jmt.app.send.service.impl.LineBotChatRepository;
import my.mins.jmt.app.send.service.impl.SendLineMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class RecommendServiceImpl implements RecommendService {

	@Autowired
	private DiningCodeFoodInfo diningCodeFoodInfo;

	@Autowired
	private SendLineMessage sendLineMessage;

	@Autowired
	private LineBotChatRepository lineBotChatRepository;

	/**
	 * 12시 25분이 되면 맛집 리스트 추천
	 *
	 * @throws IOException
	 */
	@Scheduled(cron = "0 25 12 * * *")
	public void lunchRecommend() throws IOException {
		List<LineBotChat> allGroupList = lineBotChatRepository.findAll();

		List<Food> foodInfoList = diningCodeFoodInfo.getFoodInfoList("신논현역", FoodTypeCd.WESTERN);
		StringBuilder foodInfoMessage = new StringBuilder();

		foodInfoList.forEach(food -> foodInfoMessage.append(food.toString())); // get food info

		allGroupList.forEach(group -> sendLineMessage.send(new MessageDTO.Plain(group.getSendTargetId(), foodInfoMessage.toString())));
	}

//	private FlexMessage convertMessageFromObject(String messageNotifyTitle, Food food) {
//		return FlexMessage.builder()
//				.altText(messageNotifyTitle)
//				.contents(new FlexContainer())
//				.build();
//	}
}
