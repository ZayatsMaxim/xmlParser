package com.zayats.xmlparser.test;

import com.zayats.xmlparser.exceptions.ValidatorException;
import com.zayats.xmlparser.validation.XmlValidator;
import org.junit.Assert;
import org.junit.Test;

public class XmlValidationTest {
    @Test
    public void testValidateShouldReturnTrueIfXmlValid() throws ValidatorException{
        //given
        XmlValidator validator = new XmlValidator();
        String validXml = "src/main/resources/vouchers.xml";
        String xsdSchema = "src/main/resources/vouchers.xsd";

        //when
        boolean actualXmlIsValid = validator.validate(validXml, xsdSchema);

        //then
        Assert.assertTrue(actualXmlIsValid);
    }
}
