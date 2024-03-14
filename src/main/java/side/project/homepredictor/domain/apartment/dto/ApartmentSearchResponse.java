package side.project.homepredictor.domain.apartment.dto;

import lombok.Builder;
import side.project.homepredictor.domain.apartment.entity.Apartment;

@Builder
public record ApartmentSearchResponse(
    Long id,
    String address
) {
    public static ApartmentSearchResponse from(Apartment apartment) {
        return ApartmentSearchResponse.builder()
            .id(apartment.getId())
            .address(apartment.getAddress())
            .build();
    }
}
