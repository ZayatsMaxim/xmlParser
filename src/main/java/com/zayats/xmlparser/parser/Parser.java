package com.zayats.xmlparser.parser;

import com.zayats.xmlparser.entity.Voucher;
import com.zayats.xmlparser.exceptions.ParserException;

import java.util.List;

public interface Parser {
    List<Voucher> parse(String filePath) throws ParserException;
}
