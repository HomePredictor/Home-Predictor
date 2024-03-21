package side.project.homepredictor.domain.apartmenttype.dto.response;

import lombok.*;
import side.project.homepredictor.domain.apartmenttype.entity.ApartmentType;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class ApartmentTypeResponseDto {
    private Long apartmentId;
    private Integer size;
    private Long predictedPrice;

    public static ApartmentTypeResponseDto fromEntity(ApartmentType apartmentType) {
        return ApartmentTypeResponseDto.builder()
            .apartmentId(apartmentType.getApartment().getId())
            .size(apartmentType.getSize())
            .predictedPrice(apartmentType.getPredictedPrice1())
            .build();
    }
}
