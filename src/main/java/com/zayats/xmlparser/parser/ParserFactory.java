package com.zayats.xmlparser.parser;

import com.zayats.xmlparser.exceptions.ParserFactoryException;

public class ParserFactory {
    public ParserFactory() {
    }

    static Parser getParser(ParserType parserType) throws ParserFactoryException {
        switch(parserType){
            case JAXB:
                return new JaxbParser();
            case DOM:
                return new DomParser();
            case SAX:
                return new SaxParser();
            default:
                throw new ParserFactoryException("ParserType was not recognized!");
        }
    }
}
