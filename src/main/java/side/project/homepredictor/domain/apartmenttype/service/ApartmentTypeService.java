package side.project.homepredictor.domain.apartmenttype.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import side.project.homepredictor.domain.apartment.entity.Apartment;
import side.project.homepredictor.domain.apartment.repository.ApartmentRepository;
import side.project.homepredictor.domain.apartmenttype.dto.response.ApartmentTypeResponseDto;
import side.project.homepredictor.domain.apartmenttype.dto.response.LocationDto;
import side.project.homepredictor.domain.apartmenttype.repository.ApartmentTypeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApartmentTypeService {

    private final ApartmentTypeRepository apartmentTypeRepository;
    private final ApartmentRepository apartmentRepository;
    public List<ApartmentTypeResponseDto> findApartmentTypeList(Long apartmentId) {
        Apartment apartment = apartmentRepository.findById(apartmentId).orElseThrow(
            IllegalArgumentException::new
        );
         return apartmentTypeRepository.findAllByApartment(apartment)
            .stream()
            .map(ApartmentTypeResponseDto::fromEntity)
            .collect(Collectors.toList());
    }

    public LocationDto findApartmentLocation(Long apartmentId) {
        Apartment apartment = apartmentRepository.findById(apartmentId).orElseThrow(
            IllegalArgumentException::new
        );
        apartment.updateApartmentName(parseLastWord(apartment.getAddress()));
        return LocationDto.fromEntity(apartment);
    }

    private String parseLastWord(String input) {
        // 문자열을 공백으로 분리하여 배열로 변환
        String[] words = input.split("\\s+");

        // 배열이 비어있거나 null이면 빈 문자열 반환
        if (words.length == 0) {
            return "";
        }

        // 배열의 마지막 요소 반환
        return words[words.length - 1];
    }
}
