package shopapplication.project.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Shop implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false , updatable = false)
    private int id;
    private String name;
    private Date dateOuverture;
    private boolean conge;
     
    public Shop(){
        super();
     }

    public Shop(int shopId, String name, Date dateOuverture, boolean conge)
    {
        this.id = shopId;
        this.name = name;
        this.dateOuverture = dateOuverture;
        this.conge = conge;
    }

    public int getShopId() {
        return this.id;
    }
    public void setShopId(int shopId) {
        this.id = shopId;
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
