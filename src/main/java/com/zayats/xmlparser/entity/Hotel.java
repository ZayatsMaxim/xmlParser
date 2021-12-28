package com.zayats.xmlparser.entity;

import javax.xml.bind.annotation.*;

//@XmlRootElement(name = "hotelCharacteristics", namespace = "vouchers")
@XmlType(name = "hotelCharacteristics", namespace = "vouchers")
@XmlAccessorType(XmlAccessType.FIELD)

public class Hotel{
    @XmlElement(namespace = "vouchers")
    private Integer numberOfStars;
    @XmlElement(namespace = "vouchers")
    private MealPlan mealPlan;
    @XmlElement(namespace = "vouchers")
    private Integer roomType;
    @XmlElement(namespace = "vouchers")
    private boolean hasTelevision;
    @XmlElement(namespace = "vouchers")
    private boolean hasConditioner;

    public Hotel(){

    }

    public Hotel(Integer numberOfStars, MealPlan mealPlan, Integer roomType, boolean hasTelevision, boolean hasConditioner) {
        this.numberOfStars = numberOfStars;
        this.mealPlan = mealPlan;
        this.roomType = roomType;
        this.hasTelevision = hasTelevision;
        this.hasConditioner = hasConditioner;
    }

    public Integer getNumberOfStars() {
        return numberOfStars;
    }

    public MealPlan getMealPlan() {
        return mealPlan;
    }

    public Integer getRoomType() {
        return roomType;
    }

    public boolean isHasTelevision() {
        return hasTelevision;
    }

    public boolean isHasConditioner() {
        return hasConditioner;
    }

    public void setNumberOfStars(Integer numberOfStars) {
        this.numberOfStars = numberOfStars;
    }

    public void setMealPlan(MealPlan mealPlan) {
        this.mealPlan = mealPlan;
    }

    public void setRoomType(Integer roomType) {
        this.roomType = roomType;
    }

    public void setHasTelevision(boolean hasTelevision) {
        this.hasTelevision = hasTelevision;
    }

    public void setHasConditioner(boolean hasConditioner) {
        this.hasConditioner = hasConditioner;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Hotel hotel = (Hotel) o;
        return numberOfStars.equals(hotel.getNumberOfStars()) &&
                mealPlan.equals(hotel.getMealPlan()) &&
                roomType.equals(hotel.getRoomType()) &&
                hasTelevision == hotel.hasTelevision &&
                hasConditioner == hotel.hasConditioner;
    }

    @Override
    public int hashCode(){
        final int prime = 21;
        int hashResult = 2;

        hashResult = hashResult * prime + numberOfStars;
        hashResult = hashResult * prime + mealPlan.hashCode();
        hashResult = hashResult * prime + roomType;
        hashResult = hashResult * prime + (hasTelevision ? 1 : 0);
        hashResult = hashResult * prime + (hasConditioner ? 1 : 0);
        return hashResult;
    }

    @Override
    public String toString() {
        return "hotelCharacteristics{" +
                "numberOfStars = " + numberOfStars +
                ", mealPlan = " + mealPlan +
                ", roomType = " + roomType +
                ", hasTelevision = " + hasTelevision +
                ", hasConditioner = " + hasConditioner +
                '}';
    }
}
