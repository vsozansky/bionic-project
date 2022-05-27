package cat.petproject.bionicproject.service;

import cat.petproject.bionicproject.dto.CandlestickData;
import cat.petproject.bionicproject.dto.TickerPrice;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class RestConsumer {

    private static final String[] resourceUrls = {"https://api.binance.com", "https://api1.binance.com", "https://api2.binance.com", "https://api3.binance.com"};
    private static final String[] symbols = {"ETHBTC", "ETHUSDT", "XRPUSDT"};
    private static final String tickerApiUrl = String.format("/api/v3/ticker/price?symbols=%s", arraySymbolsToString());
    private static final String candlestickApiUrl = "/api/v3/klines?symbol=%s&interval=1d&limit=1";


    RestTemplate restTemplate;

    public RestConsumer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private static String arraySymbolsToString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        if (symbols.length > 0) {
            stringBuilder.append("\"");
            stringBuilder.append(symbols[0]);
            stringBuilder.append("\"");
            for (int i = 1; i < symbols.length; i++) {
                stringBuilder.append(",\"");
                stringBuilder.append(symbols[i]);
                stringBuilder.append("\"");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public HttpHeaders getHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return httpHeaders;
    }

    @GetMapping(value = "/ticker")
    public TickerPrice[] getTickerPriceList() {
        HttpHeaders httpHeaders = getHttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        ResponseEntity<TickerPrice[]> responseEntity;
        for (String resourceUrl : resourceUrls) {
            responseEntity = restTemplate.exchange(resourceUrl + tickerApiUrl, HttpMethod.GET, entity, TickerPrice[].class);
            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                return responseEntity.getBody();
            }
        }
        return new TickerPrice[0];
    }

    @SuppressWarnings("squid:S3740")
    @GetMapping(value = "/candlestick")
    public List<CandlestickData> getCandlestickDataList() {
    /*
    @GetMapping(value = "/candlestick/{symbol}")
    public List<CandlestickData> getCandlestickDataList(@PathVariable("symbol") String symbol) {
    */
        List<CandlestickData> candlestickDatas = new ArrayList<>();
        HttpHeaders httpHeaders = getHttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        String candlestickApi;
        ResponseEntity<ArrayList> responseEntity = null;
        List<List> resultList;
        List result;

        for (String symbol : symbols) {
            candlestickApi = String.format(candlestickApiUrl, symbol);
            responseEntity = null;
            for (String resourceUrl : resourceUrls) {
                responseEntity = restTemplate.exchange(resourceUrl + candlestickApi, HttpMethod.GET, entity, ArrayList.class);
                if (responseEntity.getStatusCode() == HttpStatus.OK) {
                    break;
                }
            }
            if (responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK) {
                resultList = responseEntity.getBody();
                for (int i = 0; i < resultList.size(); i++) {
                    result = resultList.get(i);
                    candlestickDatas.add(new CandlestickData(
                            symbol
                            , (Long) result.get(0) //Long openTime
                            , (Long) result.get(6) //Long closeTime
                            , new BigDecimal((String) result.get(1)) //BigDecimal open
                            , new BigDecimal((String) result.get(2)) //BigDecimal high
                            , new BigDecimal((String) result.get(3)) //BigDecimal low
                            , new BigDecimal((String) result.get(4)) //BigDecimal close
                            , new BigDecimal((String) result.get(5)) //BigDecimal volume
                    ));
                }
            }
        }
        return candlestickDatas;
    }

}
