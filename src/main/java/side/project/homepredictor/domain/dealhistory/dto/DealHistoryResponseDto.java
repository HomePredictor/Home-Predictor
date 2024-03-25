package side.project.homepredictor.domain.dealhistory.dto;

import lombok.*;
import side.project.homepredictor.domain.apartmenttype.entity.ApartmentType;

import java.util.Map;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class DealHistoryResponseDto {
    private Map<String, Double> dealHistoryMap;

    public static DealHistoryResponseDto fromEntity(ApartmentType apartmentType) {
        return DealHistoryResponseDto.builder()
            .dealHistoryMap(apartmentType.getDealHistoryMap())
            .build();
    }
}
