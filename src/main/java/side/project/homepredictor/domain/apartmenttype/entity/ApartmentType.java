package side.project.homepredictor.domain.apartmenttype.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import side.project.homepredictor.domain.apartment.entity.Apartment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Transient
    private Map<String, Double> dealHistoryMap = new HashMap<>();

    public void updateDealHistory(Map<String, Double> map) {
        this.dealHistoryMap = map;
    }
}
