package side.project.homepredictor.domain.dealhistory.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import side.project.homepredictor.domain.apartmenttype.entity.ApartmentType;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class DealHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apartment_type_id")
    private ApartmentType apartmentType;
    private LocalDate dealDate;
    private Long dealPrice;
}
