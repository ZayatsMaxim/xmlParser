package com.zayats.xmlparser.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "touristVouchers", namespace = "vouchers")

public class VoucherWrapper {
    @XmlElements(
            {
                    @XmlElement(name = "tour", namespace = "vouchers", type = Tour.class),
                    @XmlElement(name = "excursion", namespace = "vouchers", type = Excursion.class)
            }
    )

    private final List<Voucher> vouchers = new ArrayList<>();

    public boolean add(Tour tour) {
        return vouchers.add(tour);
    }

    public  List<Voucher> getVouchers(){
        return vouchers;
    }

    public void setVoucher(Voucher voucher, int index) {
        vouchers.set(index, voucher);
    }

}
