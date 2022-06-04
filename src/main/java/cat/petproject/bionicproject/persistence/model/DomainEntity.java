package cat.petproject.bionicproject.persistence.model;

import javax.persistence.*;

@Entity
@Table(name = "domain", schema = "", catalog = "bionic")
public class DomainEntity {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Integer id;

    @Basic(optional = false)
    @Column(nullable = false)
    private String domain;


    public DomainEntity() {
    }

    public DomainEntity(Integer id, String domain) {
        this.id = id;
        this.domain = domain;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDomain() {
        return domain;
    }

    public void setSDomain(String domain) {
        this.domain = domain;
    }


    @Override
    public String toString() {
        return "DomainEntity{" +
                "id=" + id +
                ", domain='" + domain +
                '}';
    }
}
