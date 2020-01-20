package my.mins.jmt.app.send.dto;

import com.linecorp.bot.model.message.FlexMessage;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import my.mins.jmt.app.send.vo.MessageCommonVO;


/**
 * line message type에 따라 Object의 type이 다르기 때문에 공통부분을 상속받아서 사용함.
 *
 * @author minssogi
 */
public class MessageDTO {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Plain extends MessageCommonVO {
        public Plain(String to, String message) {
            super(to, message);
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Flex extends MessageCommonVO{
        public Flex(String to, FlexMessage message) {
            super(to, message);
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Bubble extends MessageCommonVO{
        private String altText;

        public Bubble(String to, Bubble bubble){
            super(to, bubble);
        }
    }

}


