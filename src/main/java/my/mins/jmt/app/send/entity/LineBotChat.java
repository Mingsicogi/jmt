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
    private Long id;

    @Column(name = "group_id", unique = true)
    private String groupId;

    @Column(name = "join_ymdt")
    private Date joinYmdt;
}
