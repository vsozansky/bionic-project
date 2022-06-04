package cat.petproject.bionicproject.persistence.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ticker", schema = "", catalog = "bionic")
public class TickerEntity {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Integer id;

    @Basic(optional = false)
    @Column(nullable = false)
    private String symbol;

    @Basic(optional = false)
    @Column(nullable = false)
    private BigDecimal price;

    public TickerEntity() {
    }

    public TickerEntity(Integer id, String symbol, BigDecimal price) {
        this.id = id;
        this.symbol = symbol;
        this.price = price;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "TickerEntity{" +
                "id=" + id +
                ", symbol='" + symbol + '\'' +
                ", price=" + price +
                '}';
    }
}
