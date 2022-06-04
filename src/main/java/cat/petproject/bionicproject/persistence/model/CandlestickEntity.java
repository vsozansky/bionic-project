package cat.petproject.bionicproject.persistence.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "candlestick", schema = "", catalog = "bionic")
public class CandlestickEntity {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Integer id;

    @Basic(optional = false)
    @Column(nullable = false)
    private String symbol;

    @Basic(optional = false)
    @Column(nullable = false)
    private Long openTime;

    @Basic(optional = false)
    @Column(nullable = false)
    private Long closeTime;

    @Basic(optional = false)
    @Column(nullable = false)
    private BigDecimal open;

    @Basic(optional = false)
    @Column(nullable = false)
    private BigDecimal high;

    @Basic(optional = false)
    @Column(nullable = false)
    private BigDecimal low;

    @Basic(optional = false)
    @Column(nullable = false)
    private BigDecimal close;

    @Basic(optional = false)
    @Column(nullable = false)
    private BigDecimal volume;

    public CandlestickEntity() {
    }

    public CandlestickEntity(Integer id, String symbol, Long openTime, Long closeTime, BigDecimal open, BigDecimal high, BigDecimal low, BigDecimal close, BigDecimal volume) {
        this.id = id;
        this.symbol = symbol;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        return "CandlestickEntity{" +
                "id=" + id +
                ", symbol='" + symbol + '\'' +
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
