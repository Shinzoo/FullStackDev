package shopapplication.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopapplication.project.entities.Shop;
import shopapplication.project.exceptions.ShopNotFoundException;
import shopapplication.project.repository.ShopRepository;

@Service
public class ShopService {
    
    private final ShopRepository shopRepository;

    @Autowired
    public ShopService(ShopRepository shopRepository){
        this.shopRepository = shopRepository;
    }

    public Shop addShop(Shop shop){
        return shopRepository.save(shop);
    }

    public List<Shop> findAllShop(){
        return shopRepository.findAll();
    }

    public Shop updateShop(Shop shop){
        return shopRepository.save(shop);
    }

    public Shop findShopById(Integer id){
        return shopRepository.findShopById(id)
                    .orElseThrow(() -> new ShopNotFoundException("Shop by id" + id + " was not found"));
    }

    public void deleteShop(Integer id){
        shopRepository.deleteShopById(id);
    }
}
