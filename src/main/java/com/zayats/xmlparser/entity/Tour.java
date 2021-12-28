package com.zayats.xmlparser.entity;

import javax.xml.bind.annotation.*;

//@XmlRootElement(name = "tour", namespace = "vouchers")
@XmlType(name = "tour", namespace = "vouchers")
@XmlAccessorType(XmlAccessType.FIELD)

public class Tour extends Voucher{
    @XmlElement(namespace = "vouchers")
    private Integer numberOfDays;
    @XmlElement(namespace = "vouchers")
    private Hotel hotelCharacteristics;

    public Tour(){
    }

    /*public Tour(Tour tour){
        this(tour.getId(), tour.getTourType(), tour.getCountry(), tour.getTransport(), tour.getNumberOfDays(), new Hotel(tour.getHotelCharacteristics()));
    }*/

    public Tour(int id, String tourType, String country, String transport, Integer cost, Integer numberOfDays, Hotel hotelCharacteristics) {
        super(id, tourType, country, transport, cost);
        this.numberOfDays = numberOfDays;
        this.hotelCharacteristics = hotelCharacteristics;
    }

    public Integer getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(Integer numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public void setHotelCharacteristics(Hotel hotelCharacteristics) {
        this.hotelCharacteristics = hotelCharacteristics;
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
        Tour tour = (Tour) o;
        return numberOfDays.equals(tour.getNumberOfDays()) &&
                hotelCharacteristics == tour.hotelCharacteristics;
    }

    @Override
    public int hashCode(){
        final int prime = 21;
        int hashResult = 2;

        hashResult = hashResult * prime + super.hashCode();
        hashResult = hashResult * prime + hotelCharacteristics.hashCode();
        hashResult = hashResult * prime + numberOfDays;
        return hashResult;
    }

    @Override
    public String toString(){
        return super.toString() + "Tour{" + "numberOfDays= " + numberOfDays + " ,hotelCharacteristics= " + hotelCharacteristics + '}';
    }
}
