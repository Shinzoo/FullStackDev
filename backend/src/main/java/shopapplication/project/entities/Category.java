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
    private String name;

    public Category(int categoryId, String name){
        this.id = categoryId;
        this.name = name;
    }

    public int getCategoryId() {
        return id;
    }

    public void setCategoryId(int categoryId) {
        this.id = categoryId;
    }
    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

}
