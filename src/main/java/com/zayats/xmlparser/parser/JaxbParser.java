package com.zayats.xmlparser.parser;

import com.zayats.xmlparser.entity.Voucher;
import com.zayats.xmlparser.entity.VoucherWrapper;
import com.zayats.xmlparser.exceptions.ParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class JaxbParser implements Parser{
    private static final Logger LOGGER = LogManager.getLogger(JaxbParser.class);

    @Override
    public List<Voucher> parse(String filePath) throws ParserException {
        LOGGER.info("Parsing info from " + filePath);
        try{
            JAXBContext jc = JAXBContext.newInstance(VoucherWrapper.class);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader(filePath);
            VoucherWrapper voucherWrapper = (VoucherWrapper) u.unmarshal(reader);
            return voucherWrapper.getVouchers();
        }
        catch (JAXBException | FileNotFoundException e) {
            throw new ParserException(e);
        }
    }
}
