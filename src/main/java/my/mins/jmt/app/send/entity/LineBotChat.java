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
@Table(
    name = "line_bot",
    uniqueConstraints = @UniqueConstraint(columnNames = {
        "send_target_id", "send_target_alias"
    })
)
public class LineBotChat {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "send_target_id", unique = true)
    private String sendTargetId;

    @Column(name = "send_target_alias", unique = true)
    private String sendTargetAlias;

    @Column(name = "join_ymdt")
    private Date joinYmdt;
}
