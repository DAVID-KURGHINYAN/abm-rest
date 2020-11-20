package am.abm.abm.models.enities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Translation extends Base{
    private String ru;  //="Русский";
    private String en;  //="English";
    private String arm;   //="Հայերեն";


    @OneToMany(mappedBy = "language")
    private Set<Category> categories;

    public Translation() {
    }

    public String getRu() {
        return ru;
    }

    public void setRu(String ru) {
        this.ru = ru;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getArm() {
        return arm;
    }

    public void setArm(String arm) {
        this.arm = arm;
    }
}
