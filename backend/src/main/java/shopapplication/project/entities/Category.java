package shopapplication.project.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false , updatable = false)
    private int id;
    private String productId;
    private String name;

    public Category(){
        super();
     }

    public Category(int categoryId, String productId, String name){
        this.id = categoryId;
        this.productId = productId;
        this.name = name;
    }

    public int getCategoryId() {
        return this.id;
    }

    public void setCategoryId(int categoryId) {
        this.id = categoryId;
    }

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

}
