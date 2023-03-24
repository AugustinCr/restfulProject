package com.example.restfulProject.Model;

import jakarta.persistence.*;
@Entity
public class Card {
    @Id
    private long userID;
    @Column
    private long cardnumber;
    @Column
    private String expirationdate;
    @Column
    private String securitycode;

    public Card() {}
    public Card(long cardnumber, String expirationdate, String securitycode, long userID) {
        this.cardnumber = cardnumber;
        this.expirationdate = expirationdate;
        this.securitycode = securitycode;
        this.userID = userID;
    }

    public long getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(long cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getExpirationdate() {
        return expirationdate;
    }

    public void setExpirationdate(String expirationdate) {
        this.expirationdate = expirationdate;
    }

    public String getSecuritycode() {
        return securitycode;
    }

    public void setSecuritycode(String securitycode) {
        this.securitycode = securitycode;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }
}
