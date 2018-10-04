package org.sid.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Contact implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    
    private String firstName;
    private String lastName;
    
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    
    private String mail;
    private long phoneNumber;
    private String pictureUrl;

    public Contact() {
    }

    public Contact(String firstName, String lastName, Date birthDate, String mail, long phoneNumber, String pictureUrl) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
        this.pictureUrl = pictureUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
