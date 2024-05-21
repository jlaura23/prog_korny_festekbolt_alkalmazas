package festekbolt;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class FestekEntity {

    @Id
    private Long id;
    private String nev;
    private String szin;

    public FestekEntity() {}

    public FestekEntity(Long id, String nev, String szin) {
        this.id = id;
        this.nev = nev;
        this.szin = szin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getSzin() {
        return szin;
    }

    public void setSzin(String szin) {
        this.szin = szin;
    }
}
