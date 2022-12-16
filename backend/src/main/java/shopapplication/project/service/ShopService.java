package shopapplication.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopapplication.project.entities.Shop;
import shopapplication.project.exceptions.BoutiqueNotFoundException;
import shopapplication.project.repository.ShopRepository;

@Service
public class ShopService {
    
    ShopRepository shopRepository;

    // public List<Shop> findByName(String name){
    //     return shopRepository.findByName(name).get(); 
    // }
    public Shop getShopById(int id){
        return shopRepository.findById(id).orElseThrow(() -> new BoutiqueNotFoundException("Boutique avec id "+id+" n'a pas été trouvée"));  
    }

    public void saveOrUpdate(Shop shop)   
    {  
        shopRepository.save(shop);  
    }  

    public void delete(int id)   
    {  
        shopRepository.deleteById(id);  
    }  
}
