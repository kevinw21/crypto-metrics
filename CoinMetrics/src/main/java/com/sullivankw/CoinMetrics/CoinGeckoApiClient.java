package com.sullivankw.CoinMetrics;


import com.sullivankw.CoinMetrics.domain.Coins.*;
import com.sullivankw.CoinMetrics.domain.Events.EventCountries;
import com.sullivankw.CoinMetrics.domain.Events.EventTypes;
import com.sullivankw.CoinMetrics.domain.Events.Events;
import com.sullivankw.CoinMetrics.domain.ExchangeRates.ExchangeRates;
import com.sullivankw.CoinMetrics.domain.Exchanges.ExchangeById;
import com.sullivankw.CoinMetrics.domain.Exchanges.Exchanges;
import com.sullivankw.CoinMetrics.domain.Exchanges.ExchangesList;
import com.sullivankw.CoinMetrics.domain.Exchanges.ExchangesTickersById;
import com.sullivankw.CoinMetrics.domain.Global.Global;
import com.sullivankw.CoinMetrics.domain.Ping;
import com.sullivankw.CoinMetrics.domain.Status.StatusUpdates;
import com.sullivankw.CoinMetrics.dto.gecko.CoinMarkets;
import com.sullivankw.CoinMetrics.dto.gecko.MarketChart;

import java.util.List;
import java.util.Map;

public interface CoinGeckoApiClient {
    Ping ping();

    Map<String, Map<String, Double>> getPrice(String ids, String vsCurrencies);

    Map<String, Map<String, Double>> getPrice(String ids, String vsCurrencies, boolean includeMarketCap, boolean include24hrVol,
                                              boolean include24hrChange, boolean includeLastUpdatedAt);

    Map<String, Map<String, Double>> getTokenPrice(String id, String contractAddress, String vsCurrencies);

    Map<String, Map<String, Double>> getTokenPrice(String id, String contractAddress, String vsCurrencies, boolean includeMarketCap,
                                                   boolean include24hrVol, boolean include24hrChange, boolean includeLastUpdatedAt);

    List<String> getSupportedVsCurrencies();

    List<CoinList> getCoinList();

    List<CoinMarkets> getCoinMarkets(String vsCurrency);

    List<CoinMarkets> getCoinMarkets(int items, int startingPage);

    List<CoinMarkets> getCoinMarkets(String vsCurrency, String ids, String order, Integer perPage, Integer page, boolean sparkline, String priceChangePercentage);

    CoinFullData getCoinById(String id);

    CoinFullData getCoinById(String id, boolean localization, boolean tickers, boolean marketData, boolean communityData, boolean developerData, boolean sparkline);

    CoinTickerById getCoinTickerById(String id);

    CoinTickerById getCoinTickerById(String id, String exchangeIds, Integer page, String order);

    CoinHistoryById getCoinHistoryById(String id, String date);

    CoinHistoryById getCoinHistoryById(String id, String data, boolean localization);

    MarketChart getCoinMarketChartById(String id, String vsCurrency, Integer days, String interval);

    MarketChart getCoinMarketChartRangeById(String id, String vsCurrency, String from, String to);

    StatusUpdates getCoinStatusUpdateById(String id);

    StatusUpdates getCoinStatusUpdateById(String id, Integer perPage, Integer page);

    CoinFullData getCoinInfoByContractAddress(String id, String contractAddress);

    List<Exchanges> getExchanges();

    List<ExchangesList> getExchangesList();

    ExchangeById getExchangesById(String id);

    ExchangesTickersById getExchangesTickersById(String id);

    ExchangesTickersById getExchangesTickersById(String id, String coinIds, Integer page, String order);

    StatusUpdates getExchangesStatusUpdatesById(String id);

    StatusUpdates getExchangesStatusUpdatesById(String id, Integer perPage, Integer page);

    List<List<String>> getExchangesVolumeChart(String id, Integer days);

    StatusUpdates getStatusUpdates();

    StatusUpdates getStatusUpdates(String category, String projectType, Integer perPage, Integer page);

    Events getEvents();

    Events getEvents(String countryCode, String type, Integer page, boolean upcomingEventsOnly, String fromDate, String toDate);

    EventCountries getEventsCountries();

    EventTypes getEventsTypes();

    ExchangeRates getExchangeRates();

    Global getGlobal();
}
