package shopapplication.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import shopapplication.project.entities.Shop;
import shopapplication.project.repository.ShopRepository;
import shopapplication.project.service.ShopService;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    ShopRepository shopRepository;
    ShopService shopService;
    @GetMapping("shop/{id}")
    private Shop getShop(@PathVariable("id") int id){
       /*/ Optional<Shop> shopData = shopRepository.findById(id);

        if (shopData.isPresent()) {
          return new ResponseEntity<>(shopData.get(), HttpStatus.OK);
        } else {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }*/

        return shopService.getShopById(id);
    }
}
