package shopapplication.project;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shopapplication.project.entities.Shop;
import shopapplication.project.service.ShopService;

@RestController
@RequestMapping("/shop")
public class ShopController {
    private final ShopService shopService;

    public ShopController(ShopService shopService){
        this.shopService = shopService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Shop>> getAllShop(){
        List<Shop> shop = shopService.findAllShop();
        return new ResponseEntity<>(shop, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Shop> getShopById(@PathVariable("id") Integer id){
        Shop shop = shopService.findShopById(id);
        return new ResponseEntity<>(shop, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Shop> addShop(@RequestBody Shop shop){
        Shop newShop = shopService.addShop(shop);
        return new ResponseEntity<>(newShop, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Shop> updateShop(@RequestBody Shop shop){
        Shop updateShop = shopService.updateShop(shop);
        return new ResponseEntity<>(updateShop, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteShop(@PathVariable("id") Integer id){
        shopService.deleteShop(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
