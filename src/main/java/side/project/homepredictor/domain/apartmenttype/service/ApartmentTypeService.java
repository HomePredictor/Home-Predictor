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
        return LocationDto.fromEntity(apartment);
    }
}
