package am.abm.abm.models.enities;

import javax.persistence.GeneratedValue;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Base {

    @javax.persistence.Id
    @GeneratedValue
    private Long Id;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
}
