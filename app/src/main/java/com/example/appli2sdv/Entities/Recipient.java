package com.example.appli2sdv.Entities;

import java.util.List;

//quand il se connecte pour la premiere fois il s'inscrit et ca se mets dans le path USERS de la firebase
//ensuite de la firebase on recoit les donnes de l'user grace a son numero de telephone a chque fois quil se connecte
public class Recipient
{
    String name;
    Double adress_destinataire_lattitude;
    Double adress_destinataire_longitude;
    String phone;
    String mail;
    List<Recipient> friends;
    //constructors

    public Recipient()
    {
        name="NO";
    }

    //getter and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAdress_destinataire_lattitude() {
        return adress_destinataire_lattitude;
    }

    public void setAdress_destinataire_lattitude(Double adress_destinataire_lattitude) {
        this.adress_destinataire_lattitude = adress_destinataire_lattitude;
    }

    public Double getAdress_destinataire_longitude() {
        return adress_destinataire_longitude;
    }

    public void setAdress_destinataire_longitude(Double adress_destinataire_longitude) {
        this.adress_destinataire_longitude = adress_destinataire_longitude;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
