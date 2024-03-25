package side.project.homepredictor.domain.apartmenttype.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import side.project.homepredictor.domain.apartmenttype.service.ApartmentTypeService;

@RestController
@RequestMapping("/v1/apartmenttypes")
@RequiredArgsConstructor
public class ApartmentTypeController {
    private final ApartmentTypeService apartmentTypeService;

    @GetMapping("/{apartmentId}")
    public ResponseEntity<?> getApartmentTypeList(@PathVariable Long apartmentId) {
        return ResponseEntity
            .ok()
            .body(
                apartmentTypeService.findApartmentTypeList(apartmentId)
            );
    }

    @GetMapping("/locations/{apartmentId}")
    public ResponseEntity<?> getApartmentLocation(@PathVariable Long apartmentId) {
        return ResponseEntity
            .ok()
            .body(
                apartmentTypeService.findApartmentLocation(apartmentId)
            );
    }
}
