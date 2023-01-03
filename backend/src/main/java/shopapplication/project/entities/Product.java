package shopapplication.project.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false , updatable = false)
    private int id;
    private String shopId;
    private String name;
    private Double price;

    public Product(){
        super();
     }

    public Product(int productId, String shopId, String name, Double price){
        this.id = productId;
        this.shopId = shopId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() {
        return this.id;
    }

    public void setProductId(int productId) {
        this.id = productId;
    }

    public String getShopId() {
        return this.shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Double getPrice(){
        return this.price;
    }

    public void setPrice(Double price){
        this.price = price;
    }
}
