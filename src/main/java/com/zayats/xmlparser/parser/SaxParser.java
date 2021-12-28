package com.zayats.xmlparser.parser;

import com.zayats.xmlparser.entity.Voucher;
import com.zayats.xmlparser.exceptions.ParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

public class SaxParser implements Parser{
    private static final Logger LOGGER = LogManager.getLogger(SaxParser.class);

    @Override
    public List<Voucher> parse(String filePath) throws ParserException {
        LOGGER.info("Parsing info from " + filePath);
        SAXParserFactory factory = SAXParserFactory.newInstance();
        VoucherHandler handler = new VoucherHandler();
        try{
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(filePath, handler);
            return handler.getVouchers();
        }
        catch (ParserConfigurationException | IOException | SAXException e){
            throw new ParserException(e);
        }
    }
}
