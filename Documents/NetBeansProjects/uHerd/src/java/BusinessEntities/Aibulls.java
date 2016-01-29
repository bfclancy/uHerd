/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessEntities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "aibulls")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aibulls.findAll", query = "SELECT a FROM Aibulls a"),
    @NamedQuery(name = "Aibulls.findById", query = "SELECT a FROM Aibulls a WHERE a.id = :id"),
    @NamedQuery(name = "Aibulls.findByCode", query = "SELECT a FROM Aibulls a WHERE a.code = :code"),
    @NamedQuery(name = "Aibulls.findByName", query = "SELECT a FROM Aibulls a WHERE a.name = :name"),
    @NamedQuery(name = "Aibulls.findByBreed", query = "SELECT a FROM Aibulls a WHERE a.breed = :breed"),
    @NamedQuery(name = "Aibulls.findByCalvingdifficulty", query = "SELECT a FROM Aibulls a WHERE a.calvingdifficulty = :calvingdifficulty"),
    @NamedQuery(name = "Aibulls.findByAvailability", query = "SELECT a FROM Aibulls a WHERE a.availability = :availability"),
    @NamedQuery(name = "Aibulls.findByPrice", query = "SELECT a FROM Aibulls a WHERE a.price = :price"),
    @NamedQuery(name = "Aibulls.findBySupplier", query = "SELECT a FROM Aibulls a WHERE a.supplier = :supplier")})
public class Aibulls implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Id
    @Basic(optional = false)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "breed")
    private String breed;
    @Basic(optional = false)
    @Column(name = "calvingdifficulty")
    private float calvingdifficulty;
    @Basic(optional = false)
    @Column(name = "availability")
    private String availability;
    @Basic(optional = false)
    @Column(name = "price")
    private float price;
    @Basic(optional = false)
    @Column(name = "supplier")
    private String supplier;

    public Aibulls() {
    }

    public Aibulls(String code) {
        this.code = code;
    }

    public Aibulls(String code, int id, String name, String breed, float calvingdifficulty, String availability, float price, String supplier) {
        this.code = code;
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.calvingdifficulty = calvingdifficulty;
        this.availability = availability;
        this.price = price;
        this.supplier = supplier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public float getCalvingdifficulty() {
        return calvingdifficulty;
    }

    public void setCalvingdifficulty(float calvingdifficulty) {
        this.calvingdifficulty = calvingdifficulty;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aibulls)) {
            return false;
        }
        Aibulls other = (Aibulls) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BusinessEntities.Aibulls[ code=" + code + " ]";
    }
    
}
