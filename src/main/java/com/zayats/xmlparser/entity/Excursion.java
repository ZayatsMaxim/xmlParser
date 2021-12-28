package com.zayats.xmlparser.entity;

import javax.xml.bind.annotation.*;

//@XmlRootElement(name = "tour", namespace = "vouchers")
@XmlType(name = "tour", namespace = "vouchers")
@XmlAccessorType(XmlAccessType.FIELD)

public class Excursion extends Voucher{
    @XmlElement
    private String city;

    public Excursion() {
    }

    public Excursion(String city) {
        this.city = city;
    }

    public Excursion(int id, String tourType, String country, String transport, Integer cost, String city) {
        super(id, tourType, country, transport, cost);
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Excursion excursion = (Excursion) o;
        return city.equals(excursion.getCity());
    }

    @Override
    public int hashCode(){
        final int prime = 21;
        int hashResult = 2;

        hashResult = hashResult * prime + super.hashCode();
        hashResult = hashResult * prime + city.hashCode();
        return hashResult;
    }

    @Override
    public String toString(){
        return super.toString() + "Excursion{" + "city= " + city + '}';
    }
}
