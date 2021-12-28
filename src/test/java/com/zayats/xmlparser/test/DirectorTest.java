package com.zayats.xmlparser.test;

import com.zayats.xmlparser.director.Director;
import com.zayats.xmlparser.entity.*;
import com.zayats.xmlparser.exceptions.DirectorException;
import com.zayats.xmlparser.exceptions.ParserException;
import com.zayats.xmlparser.exceptions.ValidatorException;
import com.zayats.xmlparser.parser.Parser;
import com.zayats.xmlparser.validation.XmlValidator;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;


public class DirectorTest {
    private static final String XML_PATH = "src/main/resources/vouchers.xml";
    private static final String XSD_PATH = "src/main/resources/vouchers.xsd";
    private static final String INVALID_XML_PATH = "src/main/resources/invalidVouchers.xml";
    private static final Hotel FIRST_TOUR_HOTEL = new Hotel(4, MealPlan.HB, 3, true, true);
    private static final Hotel SECOND_TOUR_HOTEL = new Hotel(3, MealPlan.BB, 2, false, true);
    private static final List<Voucher> VALID_VOUCHERS_LIST = Arrays.asList(
            new Tour(1, "Holiday Tour", "Zimbabwe", "Airplane", 1800, 14, FIRST_TOUR_HOTEL),
            new Tour(2, "Last-minute Tour", "Papua New Guinea", "Airplane", 900, 7, SECOND_TOUR_HOTEL),
            new Excursion(3, "Excursion", "Estonia", "Bus", 400, "Tallinn")
    );

    @Test
    public void testParseShouldReturnVouchersListWhenXmlIsValid() throws ParserException, DirectorException, ValidatorException {
        //given
        XmlValidator xmlValidator = Mockito.mock(XmlValidator.class);
        Mockito.when(xmlValidator.validate(XML_PATH, XSD_PATH)).thenReturn(true);
        Parser parser = Mockito.mock(Parser.class);
        Mockito.when(parser.parse(XML_PATH)).thenReturn(VALID_VOUCHERS_LIST);
        Director director = new Director(parser, xmlValidator);

        //when
        List<Voucher> actualList = director.parse(XML_PATH, XSD_PATH);
        //then
        Assert.assertEquals(VALID_VOUCHERS_LIST, actualList);
    }

    @Test
    public void testParseShouldReturnVouchersListWhenXmlIsNotValid() throws ParserException, DirectorException, ValidatorException {
        //given
        XmlValidator xmlValidator = Mockito.mock(XmlValidator.class);
        Mockito.when(xmlValidator.validate(INVALID_XML_PATH, XSD_PATH)).thenReturn(false);
        Parser parser = Mockito.mock(Parser.class);
        Mockito.when(parser.parse(INVALID_XML_PATH)).thenReturn(VALID_VOUCHERS_LIST);
        Director director = new Director(parser, xmlValidator);

        //when
        List<Voucher> actualList = director.parse(INVALID_XML_PATH, XSD_PATH);
        //then
        Assert.assertEquals(VALID_VOUCHERS_LIST, actualList);
    }
}
