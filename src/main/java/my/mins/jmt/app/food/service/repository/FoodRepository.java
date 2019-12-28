package my.mins.jmt.app.food.service.repository;

import my.mins.jmt.app.food.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
