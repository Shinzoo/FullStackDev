package shopapplication.project.entities;

import javax.persistence.*;

@Entity
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int categoryId;
    @Column
    private String name;

    public Category(int categoryId, String name){
        this.categoryId = categoryId;
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

}
