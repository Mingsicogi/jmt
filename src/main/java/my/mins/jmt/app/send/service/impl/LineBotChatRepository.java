package my.mins.jmt.app.send.service.impl;

import my.mins.jmt.app.send.entity.LineBotChat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LineBotChatRepository extends JpaRepository<LineBotChat, Long> {

    int removeByGroupId(String groupId);

//    int deleteByGroupId(String groupId);
}
