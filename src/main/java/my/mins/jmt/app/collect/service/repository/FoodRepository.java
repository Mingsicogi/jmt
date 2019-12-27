package my.mins.jmt.app.collect.service.repository;

import my.mins.jmt.app.collect.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
