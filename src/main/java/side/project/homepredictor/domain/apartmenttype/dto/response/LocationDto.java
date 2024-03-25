package side.project.homepredictor.domain.apartmenttype.dto.response;

import lombok.*;
import side.project.homepredictor.domain.apartment.entity.Apartment;
import side.project.homepredictor.domain.apartmenttype.entity.ApartmentType;
import side.project.homepredictor.domain.dealhistory.dto.DealHistoryResponseDto;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class LocationDto {
    private Double latitude;
    private Double longitude;

    public static LocationDto fromEntity(Apartment apartment) {
        return LocationDto.builder()
            .latitude(apartment.getLatitude())
            .longitude(apartment.getLongitude())
            .build();
    }
}
