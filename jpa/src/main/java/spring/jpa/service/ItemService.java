package spring.jpa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import spring.jpa.domain.item.Item;
import spring.jpa.repository.ItmeRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {
    
    private final ItmeRepository itmeRepository;

    @Transactional
    public void saveItem(Item item){
        itmeRepository.save(item);
    }

    public List<Item> findItems(){
        return itmeRepository.findAll();
    }

    public Item findOne(Long ItemId){
        return itmeRepository.findOne(ItemId);
    }
}
