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

    RestTemplate restTemplate;

    public RestConsumer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public HttpHeaders getHttpHeaders(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        //httpHeaders.set("Accept", "application/json");
        //httpHeaders.add("user-agent", "Mozilla/5.0 Firefox/26.0");
        //httpHeaders.add("Host", "localhost");
        return httpHeaders;
    }

    @GetMapping(value = "/ticker")
    public TickerPrice[] getTickerPriceList() {
        //String resourceUrl = "https://api.binance.com/api/v3/ticker/price";
        String resourceUrl = "https://api.binance.com/api/v3/ticker/price?symbols=[\"BTCUSDT\",\"ETHUSDT\",\"XRPUSDT\"]";
        HttpHeaders httpHeaders = getHttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        return restTemplate.exchange(resourceUrl, HttpMethod.GET, entity, TickerPrice[].class).getBody() ;
    }

    @GetMapping(value = "/candlestick")
    //public CandlestickData[] getCandlestickDataList() {
    public List<CandlestickData> getCandlestickDataList() {
        //https://api.binance.com/api/v3/klines?symbol=ETHBTC&interval=1d&limit=1
        //[[1653004800000,"0.06661000","0.06760000","0.06648400","0.06749100","68734.52060000",1653091199999,"4609.71059174",83268,"34649.27850000","2323.90049805","0"]]

        String[] symbols = {"ETHBTC", "ETHUSDT", "XRPUSDT"};
        String resourceUrl = "https://api.binance.com/api/v3/klines";
        List<CandlestickData> candlestickDatas = new ArrayList<>();

        HttpHeaders httpHeaders = getHttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        String getParameters;
        List<List> resultList;
        List result;
        for (String symbol : symbols) {
            getParameters = "?symbol=" + symbol + "&interval=1d&limit=1";
            resultList = restTemplate.exchange(resourceUrl + getParameters, HttpMethod.GET, entity, ArrayList.class).getBody();
            if (resultList != null) {
                for (int i = 0; i < resultList.size(); i++) {
                    result = (List) resultList.get(i);
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
        //return (CandlestickData[]) candlestickDatas.toArray();
        return candlestickDatas;
    }

    /*
    @PostMapping(value = "/posts")
    public String createPost(@RequestBody TickerPrice post) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<TickerPrice> entity = new HttpEntity<TickerPrice>(post, httpHeaders);
        return restTemplate.exchange("https://jsonplaceholder.typicode.com/posts", HttpMethod.POST, entity, String.class).getBody();

    }

    @PutMapping(value = "/posts/{id}")
    public String updatePost(@PathVariable("id") int id, @RequestBody TickerPrice post) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<TickerPrice> entity = new HttpEntity<>(post, httpHeaders);
        return restTemplate.exchange("https://jsonplaceholder.typicode.com/posts/" + id, HttpMethod.PUT, entity, String.class).getBody();
    }

    @DeleteMapping(value = "/posts/{id}")
    public String deletePost(@PathVariable("id") int id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        return restTemplate.exchange("https://jsonplaceholder.typicode.com/posts/" + id, HttpMethod.DELETE, entity, String.class).getBody();
    }

    */

}
