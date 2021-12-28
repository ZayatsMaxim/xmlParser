package com.zayats.xmlparser.entity;

import javax.xml.bind.annotation.*;
@XmlRootElement(name = "touristVouchers", namespace = "vouchers")
@XmlSeeAlso({Tour.class, Excursion.class})
@XmlAccessorType(XmlAccessType.FIELD)

public class Voucher {
        @XmlAttribute(required = true)
        private int id;
        @XmlAttribute
        private String tourType;
        @XmlAttribute
        private String country;
        @XmlAttribute
        private String transport;
        @XmlAttribute
        private Integer cost;

        public  Voucher(){
        }
        public Voucher(int id, String tourType, String country, String transport, Integer cost) {
                this.id = id;
                this.tourType = tourType;
                this.country = country;
                this.transport = transport;
                this.cost = cost;
        }

        public int getId() {
                return id;
        }

        public String getTourType() {
                return tourType;
        }

        public String getCountry() {
                return country;
        }

        public String getTransport() {
                return transport;
        }

        public Integer getCost() {
                return cost;
        }

        public void setId(int id) {
                this.id = id;
        }

        public void setTourType(String tourType) {
                this.tourType = tourType;
        }

        public void setCountry(String country) {
                this.country = country;
        }

        public void setTransport(String transport) {
                this.transport = transport;
        }

        public void setCost(Integer cost) {
                this.cost = cost;
        }

        @Override
        public boolean equals(Object o){
                if (this == o) {
                        return true;
                }
                if (o == null || getClass() != o.getClass()) {
                        return false;
                }
                Voucher voucher = (Voucher) o;
                return id == voucher.id
                        && tourType.equals(voucher.getTourType())
                        && tourType.equals(voucher.getTourType())
                        && country.equals(voucher.getCountry())
                        && transport.equals(voucher.getTransport())
                        && cost.equals(voucher.getCost());
        }

        @Override
        public int hashCode(){
                final int prime = 21;
                int hashResult = 2;

                hashResult = hashResult * prime + id;
                hashResult = hashResult * prime + ((tourType == null) ? 0 : tourType.hashCode());
                hashResult = hashResult * prime + ((country == null) ? 0 : country.hashCode());
                hashResult = hashResult * prime + ((transport == null) ? 0 : transport.hashCode());
                hashResult = hashResult * prime + ((cost == null) ? 0 : cost.hashCode());

                return hashResult;
        }

        @Override
        public String toString(){
                return "Voucher{" +
                        "id = " + id +
                        ", tourType= " + tourType +
                        ", country= " + country +
                        ", transport= " + transport +
                        ", cost= " + cost +
                        '}';
        }
}
