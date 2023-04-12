package kr.devbug.practice.stock.facade;

import java.util.concurrent.TimeUnit;
import kr.devbug.practice.stock.service.StockService;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

@Component
public class RedissonLockStockFacade {

    // 구현이 복잡하고, 별도의 라이브러리를 사용해야 함
    private final RedissonClient redissonClient;
    private final StockService stockService;

    public RedissonLockStockFacade(final RedissonClient redissonClient,
        final StockService stockService) {
        this.redissonClient = redissonClient;
        this.stockService = stockService;
    }

    public void decrease(Long key, Long quantity) {
        final RLock lock = redissonClient.getLock(key.toString());

        try {
            final boolean available = lock.tryLock(5, 1, TimeUnit.SECONDS);

            if (!available) {
                System.out.println("lock 획득 실패 @!");
                return;
            }
            stockService.decrease(key, quantity);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
