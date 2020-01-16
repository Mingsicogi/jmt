package my.mins.jmt.app.send.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
@ToString
@Table(name = "line_bot")
public class LineBotChat {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "group_id")
    private String groupId;

    @Column(name = "join_ymdt")
    private Date joinYmdt;
}
