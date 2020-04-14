package my.mins.jmt.app.review.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import my.mins.jmt.app.food.entity.Food;

import javax.persistence.*;

@Entity
@Table
@Getter
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue
    private Long id;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;
}
