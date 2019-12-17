package my.mins.jmt.common.service;

import my.mins.jmt.common.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Integer> {
}
