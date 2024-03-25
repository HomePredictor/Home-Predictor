package side.project.homepredictor.domain.dealhistory.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import side.project.homepredictor.domain.apartmenttype.dto.response.ApartmentTypeResponseDto;
import side.project.homepredictor.domain.apartmenttype.entity.ApartmentType;
import side.project.homepredictor.domain.apartmenttype.repository.ApartmentTypeRepository;
import side.project.homepredictor.domain.dealhistory.dto.DealHistoryResponseDto;
import side.project.homepredictor.domain.dealhistory.entity.DealHistory;
import side.project.homepredictor.domain.dealhistory.repository.DealHistoryRepository;

import java.time.YearMonth;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DealHistoryService {
    private final DealHistoryRepository dealHistoryRepository;
    private final ApartmentTypeRepository apartmentTypeRepository;

    public DealHistoryResponseDto findDealHistory(Long apartmentTypeId) {
        ApartmentType apartmentType = apartmentTypeRepository.getReferenceById(apartmentTypeId);
        List<DealHistory> dealHistoryList = dealHistoryRepository.findAllByApartmentTypeOrderByDealDate(apartmentType);
        Map<String, Double> monthAvrgDealHistoryMap = dealHistoryList.stream()
            .collect(Collectors.groupingBy(
                dealHistory -> YearMonth.from(dealHistory.getDealDate()).toString(),
                Collectors.averagingDouble(DealHistory::getDealPrice)
            ));
        apartmentType.updateDealHistory(monthAvrgDealHistoryMap);
        return DealHistoryResponseDto.fromEntity(apartmentType);
    }
}
