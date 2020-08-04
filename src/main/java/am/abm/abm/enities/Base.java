package am.abm.abm.enities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Base {

    @javax.persistence.Id
    @GeneratedValue
    private Long Id;
}
