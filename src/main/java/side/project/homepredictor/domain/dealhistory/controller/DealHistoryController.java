package side.project.homepredictor.domain.dealhistory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import side.project.homepredictor.domain.dealhistory.service.DealHistoryService;

@RestController
@RequestMapping("/v1/dealhistories")
@RequiredArgsConstructor
public class DealHistoryController {
    private final DealHistoryService dealHistoryService;

    @GetMapping("/{apartmentTypeId}")
    public ResponseEntity<?> getDealHistory(@PathVariable Long apartmentTypeId) {
        return ResponseEntity
            .ok()
            .body(
                dealHistoryService.findDealHistory(apartmentTypeId)
            );
    }
}
