package com.zayats.xmlparser.parser;

import com.zayats.xmlparser.entity.Excursion;
import com.zayats.xmlparser.entity.Hotel;
import com.zayats.xmlparser.entity.Tour;
import com.zayats.xmlparser.entity.Voucher;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class VoucherHandler extends DefaultHandler {
    private List<Voucher> vouchers;
    private StringBuilder bufferedString;
    private Tour bufferedTour;
    private Excursion bufferedExcursion;
    private Hotel bufferedHotel;
    private Voucher currentVoucher;

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
    }

    @Override
    public void startElement(String uri, String localName, String elementName, Attributes attributes){
        switch(elementName){
            case "touristVouchers":
                List<Voucher> vouchers = new ArrayList<>();
                break;
            case "tour":
                bufferedTour = new Tour();
                parseAttributes(bufferedTour, attributes);
                currentVoucher = bufferedTour;
                break;
            case "excursion" :
                bufferedExcursion = new Excursion();
                parseAttributes(bufferedExcursion, attributes);
                currentVoucher = bufferedExcursion;
                break;
            default:
                if(elementName.equals("tourType") ||
                        elementName.equals("country") ||
                        elementName.equals("numberOfDays") ||
                        elementName.equals("transport") ||
                        elementName.equals("tourType") ||
                        elementName.equals("cost")
                ){
                    bufferedString = new StringBuilder();
                }
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String elementName) throws SAXException{
        switch (elementName){
            case "tour":
                vouchers.add(bufferedTour);
                break;
            case "excursion":
                vouchers.add(bufferedExcursion);
                break;
            case "tourType":
                String tourType = bufferedString.toString();
                currentVoucher.setTourType(tourType);
                break;
            case "country":
                String country = bufferedString.toString();
                currentVoucher.setCountry(country);
                break;
            case "numberOfDays":
                String numberOfDaysInString = bufferedString.toString();
                Integer numberOfDays = Integer.parseInt(numberOfDaysInString);
                bufferedTour.setNumberOfDays(numberOfDays);
                break;
            case "transport":
                String transport = bufferedString.toString();
                currentVoucher.setTransport(transport);
                break;
            case "cost":
                String costInString = bufferedString.toString();
                Integer cost = Integer.parseInt(costInString);
                currentVoucher.setCost(cost);
                break;
        }
    }

    @Override
    public void characters(char[] characters, int start, int length) throws SAXException{
        if (bufferedString == null) {
            bufferedString = new StringBuilder();
        } else {
            bufferedString.append(characters, start, length);
        }
    }

    private void parseAttributes(Voucher destination, Attributes attributes){
        for (int i = 0; i < attributes.getLength(); i++) {
            String readId = attributes.getValue(i);
            int id = Integer.parseInt(readId);
            destination.setId(id);
        }
    }

    List<Voucher> getVouchers(){
        return vouchers;
    }
}
