package com.zayats.xmlparser.test;

import com.zayats.xmlparser.entity.*;
import com.zayats.xmlparser.exceptions.ParserException;
import com.zayats.xmlparser.parser.DomParser;
import com.zayats.xmlparser.parser.JaxbParser;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class JaxbParserTest {
    private static final String XML_PATH = "src/main/resources/vouchers.xml";
    private static final String XSD_PATH = "src/main/resources/vouchers.xsd";

    @Test
    public void testParseShouldReturnVouchersList() throws ParserException {
        //given
        Hotel firstTourHotel = new Hotel(4, MealPlan.HB, 3, true, true);
        Hotel secondTourHotel = new Hotel(3, MealPlan.BB, 2, false, true);
        List<Voucher> validVoucherList = Arrays.asList(
                new Tour(1, "Holiday Tour", "Zimbabwe", "Airplane", 1800, 14, firstTourHotel),
                new Tour(2, "Last-minute Tour", "Papua New Guinea", "Airplane", 900, 7, secondTourHotel),
                new Excursion(3, "Excursion", "Estonia", "Bus", 400, "Tallinn")
        );
       JaxbParser parser = new JaxbParser();

        //when
        List<Voucher> actualList = parser.parse(XML_PATH);

        //then
        Assert.assertEquals(validVoucherList, actualList);
    }
}
