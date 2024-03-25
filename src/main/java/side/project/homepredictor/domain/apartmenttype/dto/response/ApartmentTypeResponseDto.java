package side.project.homepredictor.domain.apartmenttype.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import side.project.homepredictor.domain.apartmenttype.entity.ApartmentType;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static java.lang.Math.max;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class ApartmentTypeResponseDto {
    private Long apartmentTypeId;
    private Integer size;
    private Long predictedPrice1;
    private Long predictedPrice2;
    private Long predictedPrice3;
    private Max highestPredictedPrice;
    private Min lowestPredictedPrice;

    public static ApartmentTypeResponseDto fromEntity(ApartmentType apartmentType) {
        Result result = getResult(apartmentType);
        return ApartmentTypeResponseDto.builder()
            .apartmentTypeId(apartmentType.getId())
            .size(apartmentType.getSize())
            .predictedPrice1(apartmentType.getPredictedPrice1())
            .predictedPrice2(apartmentType.getPredictedPrice2())
            .predictedPrice3(apartmentType.getPredictedPrice3())
            .highestPredictedPrice(new Max(result.highDate(), result.high()))
            .lowestPredictedPrice(new Min(result.lowDate(), result.low()))
            .build();
    }

    private static Result getResult(ApartmentType apartmentType) {
        List<Long> predictedPriceList = List.of(
            apartmentType.getPredictedPrice1(),
            apartmentType.getPredictedPrice2(),
            apartmentType.getPredictedPrice3()
        );

        Long high = Collections.max(predictedPriceList);
        int highDate = predictedPriceList.indexOf(high) + 1;

        Long low = Collections.min(predictedPriceList);
        int lowDate = predictedPriceList.indexOf(low) + 1;

        return new Result(high, highDate, low, lowDate);
    }

    private record Result(Long high, int highDate, Long low, int lowDate) {
    }
}
record Max(int date,Long price) {}

record Min(int date,Long price) {}
