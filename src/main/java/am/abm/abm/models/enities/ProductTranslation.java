package am.abm.abm.models.enities;

import am.abm.abm.models.enums.Language;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductTranslation extends Base {
    @Enumerated(EnumType.ORDINAL)
    private Language language;

    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    Product product;

    @Lob
    @Basic
    @Nationalized
    private String description;

    @Lob
    @Basic
    @Nationalized
    private String productName;
}
