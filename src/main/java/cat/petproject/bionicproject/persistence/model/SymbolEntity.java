package cat.petproject.bionicproject.persistence.model;

import javax.persistence.*;

@Entity
@Table(name = "symbol", schema = "", catalog = "bionic")
public class SymbolEntity {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Integer id;

    @Basic(optional = false)
    @Column(nullable = false)
    private String symbol;


    public SymbolEntity() {
    }

    public SymbolEntity(Integer id, String symbol) {
        this.id = id;
        this.symbol = symbol;
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


    @Override
    public String toString() {
        return "SymbolEntity{" +
                "id=" + id +
                ", symbol='" + symbol +
                '}';
    }
}
