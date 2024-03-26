package side.project.homepredictor.domain.apartmenttype.dto.response;

import lombok.*;
import side.project.homepredictor.domain.apartment.entity.Apartment;
import side.project.homepredictor.domain.apartmenttype.entity.ApartmentType;
import side.project.homepredictor.domain.dealhistory.dto.DealHistoryResponseDto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class LocationDto {
    private String apartmentName;
    private String address;
    private Double latitude;
    private Double longitude;

    public static LocationDto fromEntity(Apartment apartment) {
        return LocationDto.builder()
            .apartmentName(apartment.getApartmentName())
            .address(apartment.getAddress())
            .latitude(apartment.getLatitude())
            .longitude(apartment.getLongitude())
            .build();
    }
}
