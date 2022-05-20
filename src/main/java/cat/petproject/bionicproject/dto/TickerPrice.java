package cat.petproject.bionicproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class TickerPrice {
    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("price")
    private BigDecimal price;

    public TickerPrice() {
    }

    public TickerPrice(String symbol, BigDecimal price) {
        this.symbol = symbol;
        this.price = price;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "tickerPrice{" +
                "symbol='" + symbol + '\'' +
                ", price=" + price +
                '}';
    }

}
