package cat.petproject.bionicproject.service;

import cat.petproject.bionicproject.dto.CandlestickData;
import cat.petproject.bionicproject.dto.TickerPrice;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@RestController
public class RestConsumer {

    RestTemplate restTemplate;

    public RestConsumer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping(value = "/ticker")
    public TickerPrice[] getTickerPriceList() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        return restTemplate.exchange("https://api.binance.com/api/v3/ticker/price", HttpMethod.GET, entity, TickerPrice[].class).getBody();
    }

    @GetMapping(value = "/candlestick")
    public CandlestickData[] getCandlestickDataList() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        return restTemplate.exchange("https://api.binance.com/api/v3/klines", HttpMethod.GET, entity, CandlestickData[].class).getBody();
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
