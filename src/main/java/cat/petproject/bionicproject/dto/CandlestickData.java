package cat.petproject.bionicproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class CandlestickData {
    @JsonProperty("symbol")
    private String symbol;

    @JsonProperty("openTime")
    private Long openTime;
    @JsonProperty("closeTime")
    private Long closeTime;

    @JsonProperty("open")
    private BigDecimal open;
    @JsonProperty("high")
    private BigDecimal high;
    @JsonProperty("low")
    private BigDecimal low;
    @JsonProperty("close")
    private BigDecimal close;
    @JsonProperty("volume")
    private BigDecimal volume;

    public CandlestickData() {
    }

    public CandlestickData(String symbol, Long openTime, Long closeTime, BigDecimal open, BigDecimal high, BigDecimal low, BigDecimal close, BigDecimal volume) {
        this.symbol = symbol;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Long getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Long openTime) {
        this.openTime = openTime;
    }

    public Long getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Long closeTime) {
        this.closeTime = closeTime;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public void setOpen(BigDecimal open) {
        this.open = open;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public void setLow(BigDecimal low) {
        this.low = low;
    }

    public BigDecimal getClose() {
        return close;
    }

    public void setClose(BigDecimal close) {
        this.close = close;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "candlestickData{" +
                "symbol='" + symbol + '\'' +
                ", openTime=" + openTime +
                ", closeTime=" + closeTime +
                ", open=" + open +
                ", high=" + high +
                ", low=" + low +
                ", close=" + close +
                ", volume=" + volume +
                '}';
    }
}
