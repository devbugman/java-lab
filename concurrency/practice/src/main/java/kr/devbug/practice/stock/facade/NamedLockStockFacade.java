package kr.devbug.practice.stock.facade;

import kr.devbug.practice.stock.repository.LockRepository;
import kr.devbug.practice.stock.service.StockService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class NamedLockStockFacade {
    //h2는 지원 x? mysql은 되네
    private final LockRepository lockRepository;
    private final StockService stockService;

    public NamedLockStockFacade(final LockRepository lockRepository, final StockService stockService) {
        this.lockRepository = lockRepository;
        this.stockService = stockService;
    }

    @Transactional
    public void decrease(Long id, Long quantity) {
        try {
            lockRepository.getLock(id.toString());
            stockService.decrease(id, quantity);
        } finally {
            // 락의 해제
            lockRepository.releaseLock(id.toString());
        }
    }
}
