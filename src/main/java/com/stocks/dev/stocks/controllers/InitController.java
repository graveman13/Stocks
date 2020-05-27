package com.stocks.dev.stocks.controllers;

import com.stocks.dev.stocks.util.ExchangeSymbolUtil;
import com.stocks.dev.stocks.util.PublishableTokenUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import pl.zankowski.iextrading4j.api.refdata.v1.ExchangeSymbol;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
public class InitController {
    private Logger logger = LogManager.getLogger(InitController.class);
    @Value("${data.input.url}")
    private String inputData;
    @Autowired
    private PublishableTokenUtil publishableTokenUtil;
    @Autowired
    private ExchangeSymbolUtil exchangeSymbolUtil;
    private List<ExchangeSymbol> exchangeSymbolList;

    @PostConstruct
    public void init() {
        logger.info("Start read input data from url :");
        String token = publishableTokenUtil.getPublichableTokenByUrl(inputData);
        exchangeSymbolList = exchangeSymbolUtil.getExchangeSymbolByToken(token);
        logger.info("End read input data from url.");
    }

    public List<ExchangeSymbol> getExchangeSymbolList() {
        return exchangeSymbolList;
    }
}
