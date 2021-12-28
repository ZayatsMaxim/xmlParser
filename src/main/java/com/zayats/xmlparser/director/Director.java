package com.zayats.xmlparser.director;

import com.zayats.xmlparser.entity.Voucher;
import com.zayats.xmlparser.exceptions.DirectorException;
import com.zayats.xmlparser.parser.Parser;
import com.zayats.xmlparser.validation.XmlValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Director {
    private static final Logger LOGGER = LogManager.getLogger(Director.class);

    private final Parser parser;
    private final XmlValidator validator;

    public Director(Parser parser, XmlValidator xmlValidator) {
        this.parser = parser;
        this.validator = xmlValidator;
    }

    public List<Voucher> parse(String xmlPath, String xsdPath) throws DirectorException {
        LOGGER.info("Parsing info from " + xmlPath + " has been started, xml schema: " + xsdPath);
        try {
            if (!validator.validate(xmlPath, xsdPath)) {
                throw new DirectorException("The XML file is not valid!");
            }
            return parser.parse(xmlPath);
        } catch (Exception e) {
            throw new DirectorException(e);
        }
    }
}
