package side.project.homepredictor.domain.apartmenttype.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import side.project.homepredictor.domain.apartment.entity.Apartment;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ApartmentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;
    private Integer size;
    private Long predictedPrice1;
    private Long predictedPrice2;
    private Long predictedPrice3;
}
