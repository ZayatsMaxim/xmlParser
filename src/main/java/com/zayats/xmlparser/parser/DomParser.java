package com.zayats.xmlparser.parser;

import com.zayats.xmlparser.entity.*;
import com.zayats.xmlparser.exceptions.ParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomParser implements Parser{
    private static final Logger LOGGER = LogManager.getLogger(DomParser.class);

    @Override
    public List<Voucher> parse(String filePath) throws ParserException {
        LOGGER.info("Started parsing info from " + filePath);
        try{
            List<Voucher> voucherList = new ArrayList<>();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(filePath);
            Element root = document.getDocumentElement();
            NodeList vouchersNodeList = root.getChildNodes();
            Element currentElement;
            for (int i = 0; i < vouchersNodeList.getLength(); i++) {
                if (vouchersNodeList.item(i).getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }
                currentElement = (Element) vouchersNodeList.item(i);
                if (currentElement.getTagName().equals("tour")) {
                    voucherList.add(buildTour((Element) vouchersNodeList.item(i)));
                } else if (currentElement.getTagName().equals("excursion")) {
                    voucherList.add(buildExcursion((Element) vouchersNodeList.item(i)));
                }
            }
            return voucherList;
        }
        catch (ParserConfigurationException | IOException | SAXException e) {
            throw new ParserException(e);
        }
    }

    private void buildVoucherFields(Element voucherElement, Voucher generatedVoucher){
        String idLine = voucherElement.getAttribute("id");
        int id = Integer.parseInt(idLine);
        generatedVoucher.setId(id);

        String tourType = getElementTextContent(voucherElement, "tourType");
        generatedVoucher.setTourType(tourType);

        String country = getElementTextContent(voucherElement, "country");
        generatedVoucher.setCountry(country);

        String transport = getElementTextContent(voucherElement, "transport");
        generatedVoucher.setTransport(transport);

        String costLine = getElementTextContent(voucherElement, "cost");
        Integer cost = Integer.parseInt(costLine);
        generatedVoucher.setCost(cost);
    }

    private Tour buildTour(Element tourElement){
        LOGGER.info("Building a tour element");
        Tour generatedTour = new Tour();
        Hotel genTourHotelCharacteristics = new Hotel();
        NodeList hotelNodes = tourElement.getElementsByTagName("hotelCharacteristics");
        Element hotelNode = (Element) hotelNodes.item(0);

        String numberOfDaysLine = getElementTextContent(hotelNode, "numberOfDays");
        Integer numberOfDays = Integer.parseInt(numberOfDaysLine);
        generatedTour.setNumberOfDays(numberOfDays);

        buildVoucherFields(tourElement, generatedTour);

        String numberOfStarsLine = getElementTextContent(hotelNode, "numberOfStars");
        Integer numberOfStars = Integer.parseInt(numberOfStarsLine);
        genTourHotelCharacteristics.setNumberOfStars(numberOfStars);

        String mealPlanLine = getElementTextContent(hotelNode, "mealPlan");
        MealPlan mealPlan = MealPlan.valueOf(mealPlanLine);
        genTourHotelCharacteristics.setMealPlan(mealPlan);

        String roomTypeLine = getElementTextContent(hotelNode, "roomType");
        Integer roomType = Integer.parseInt(roomTypeLine);
        genTourHotelCharacteristics.setRoomType(roomType);

        String hasTelevisionLine = getElementTextContent(hotelNode, "hasTelevision");
        boolean hasTelevision = Boolean.parseBoolean(hasTelevisionLine);
        genTourHotelCharacteristics.setHasTelevision(hasTelevision);

        String hasConditionerLine = getElementTextContent(hotelNode, "hasConditioner");
        boolean hasConditioner = Boolean.parseBoolean(hasConditionerLine);
        genTourHotelCharacteristics.setHasConditioner(hasConditioner);

        generatedTour.setHotelCharacteristics(genTourHotelCharacteristics);
        return generatedTour;
    }

    private Excursion buildExcursion(Element excursionElement){
        LOGGER.info("Building a excursion element");
        Excursion generatedExcursion = new Excursion();
        buildVoucherFields(excursionElement, generatedExcursion);

        String city = getElementTextContent(excursionElement, "city");
        generatedExcursion.setCity(city);
        return generatedExcursion;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        return node.getTextContent();
    }
}
