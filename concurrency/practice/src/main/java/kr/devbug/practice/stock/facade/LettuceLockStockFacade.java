package kr.devbug.practice.stock.facade;

import kr.devbug.practice.stock.repository.RedisRepository;
import kr.devbug.practice.stock.service.StockService;
import org.springframework.stereotype.Component;

@Component
public class LettuceLockStockFacade {

    private final RedisRepository redisRepository;
    private final StockService stockService;

    public LettuceLockStockFacade(final RedisRepository redisRepository,
        final StockService stockService) {
        this.redisRepository = redisRepository;
        this.stockService = stockService;
    }

    public void decrease(Long id, Long quantity) throws InterruptedException {
        while (!redisRepository.lock(id)) {
            Thread.sleep(100);
        }

        try {
            stockService.decrease(id, quantity);
        } finally {
            redisRepository.unLock(id);
        }
    }
}
