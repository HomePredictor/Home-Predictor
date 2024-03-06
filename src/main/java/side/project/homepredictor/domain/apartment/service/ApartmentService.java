package side.project.homepredictor.domain.apartment.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import side.project.homepredictor.domain.apartment.dto.ApartmentSearchResponse;
import side.project.homepredictor.domain.apartment.repository.ApartmentRepository;

@Service
@RequiredArgsConstructor
public class ApartmentService {

    private final ApartmentRepository apartmentRepository;

    public List<ApartmentSearchResponse> searchApartments(String address) {
        return apartmentRepository.findByAddressContains(address)
            .stream()
            .map(ApartmentSearchResponse::from)
            .collect(Collectors.toList());
    }
}
