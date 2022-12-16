package shopapplication.project.entities;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Shop")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int shopId;
    @Column
    private String name;
    @Column
    private Date dateOuverture;
    @Column
    private boolean conge;
     

    public Shop(int shopId, String name, Date dateOuverture, boolean conge)
    {
        this.shopId = shopId;
        this.name = name;
        this.dateOuverture = dateOuverture;
        this.conge = conge;
    }

    public int getShopId() {
        return shopId;
    }
    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name ){
        this.name = name;
    }

    public Date getDateOuverture(){
        return this.dateOuverture;
    }

    public void setDateOuverture(Date dateOuverture ){
        this.dateOuverture = dateOuverture;
    }

    public Boolean getConge(){
        return this.conge;
    }

    public void setConge(Boolean conge ){
        this.conge =conge;
    }

}
