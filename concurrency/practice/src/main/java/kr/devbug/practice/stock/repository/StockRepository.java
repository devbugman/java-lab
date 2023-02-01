package kr.devbug.practice.stock.repository;

import kr.devbug.practice.stock.domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
