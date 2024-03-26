package side.project.homepredictor.domain.apartment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Transient
    private String apartmentName;
    private String address;
    private Double latitude;
    private Double longitude;

    public void updateApartmentName(String name) {
        this.apartmentName = name;
    }
}
