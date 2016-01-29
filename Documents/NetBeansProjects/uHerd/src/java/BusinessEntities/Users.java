/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessEntities;

import IBusinessEntities.IUsers;
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
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByFirstName", query = "SELECT u FROM Users u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "Users.findBySurname", query = "SELECT u FROM Users u WHERE u.surname = :surname"),
    @NamedQuery(name = "Users.findByAddress", query = "SELECT u FROM Users u WHERE u.address = :address"),
    @NamedQuery(name = "Users.findByCounty", query = "SELECT u FROM Users u WHERE u.county = :county"),
    @NamedQuery(name = "Users.findByHerdNumber", query = "SELECT u FROM Users u WHERE u.herdNumber = :herdNumber"),
    @NamedQuery(name = "Users.findByPac", query = "SELECT u FROM Users u WHERE u.pac = :pac"),
    @NamedQuery(name = "Users.findByUserName", query = "SELECT u FROM Users u WHERE u.userName = :userName"),
    @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email"),
    @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password")})
public class Users implements IUsers {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "firstName")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "surname")
    private String surname;
    @Basic(optional = false)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @Column(name = "county")
    private String county;
    @Id
    @Basic(optional = false)
    @Column(name = "herdNumber")
    private String herdNumber;
    @Basic(optional = false)
    @Column(name = "PAC")
    private String pac;
    @Basic(optional = false)
    @Column(name = "userName")
    private String userName;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;

    public Users() {
    }

    public Users(String herdNumber) {
        this.herdNumber = herdNumber;
    }

    public Users(String herdNumber, String firstName, String surname, String address, String county, String pac, String userName, String email, String password) {
        this.herdNumber = herdNumber;
        this.firstName = firstName;
        this.surname = surname;
        this.address = address;
        this.county = county;
        this.pac = pac;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getCounty() {
        return county;
    }

    @Override
    public void setCounty(String county) {
        this.county = county;
    }

    @Override
    public String getHerdNumber() {
        return herdNumber;
    }

    @Override
    public void setHerdNumber(String herdNumber) {
        this.herdNumber = herdNumber;
    }

    @Override
    public String getPac() {
        return pac;
    }

    @Override
    public void setPac(String pac) {
        this.pac = pac;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (herdNumber != null ? herdNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.herdNumber == null && other.herdNumber != null) || (this.herdNumber != null && !this.herdNumber.equals(other.herdNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BusinessEntities.Users[ herdNumber=" + herdNumber + " ]";
    }
    
}
