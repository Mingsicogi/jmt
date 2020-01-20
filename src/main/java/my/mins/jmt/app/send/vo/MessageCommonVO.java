package my.mins.jmt.app.send.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MessageCommonVO {
    private String to;
    private Object message;
    private Boolean notificationDisabled;

    public MessageCommonVO(String to, Object message) {
        this.to = to;
        this.message = message;
    }
}
