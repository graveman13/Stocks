package com.stocks.dev.stocks.util;

import org.jvnet.hk2.annotations.Service;
import org.springframework.stereotype.Component;
import pl.zankowski.iextrading4j.api.refdata.v1.ExchangeSymbol;
import pl.zankowski.iextrading4j.client.IEXCloudClient;
import pl.zankowski.iextrading4j.client.IEXCloudTokenBuilder;
import pl.zankowski.iextrading4j.client.IEXTradingApiVersion;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.SymbolsRequestBuilder;

import java.util.List;

@Component
public class ExchangeSymbolUtil {
    public List<ExchangeSymbol> getExchangeSymbolByToken(String token) {
        IEXCloudClient cloudClient = IEXTradingClient.create(IEXTradingApiVersion.IEX_CLOUD_V1_SANDBOX,
                new IEXCloudTokenBuilder()
                        .withPublishableToken(token)
                        .build());
        return cloudClient.executeRequest(new SymbolsRequestBuilder().build());
    }
}
