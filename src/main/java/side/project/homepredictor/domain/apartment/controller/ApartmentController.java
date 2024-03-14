package side.project.homepredictor.domain.apartment.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import side.project.homepredictor.domain.apartment.dto.ApartmentSearchResponse;
import side.project.homepredictor.domain.apartment.service.ApartmentService;

@RestController
@RequestMapping("/apartments")
@RequiredArgsConstructor
public class ApartmentController {

    private final ApartmentService apartmentService;

    @GetMapping
    public List<ApartmentSearchResponse> searchApartments(
        @RequestParam(name = "address") String address
    ) {
        return apartmentService.searchApartments(address);
    }
}
