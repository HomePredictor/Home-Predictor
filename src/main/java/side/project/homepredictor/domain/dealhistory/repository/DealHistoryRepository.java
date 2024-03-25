package side.project.homepredictor.domain.dealhistory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import side.project.homepredictor.domain.apartmenttype.entity.ApartmentType;
import side.project.homepredictor.domain.dealhistory.entity.DealHistory;

import java.util.List;

public interface DealHistoryRepository extends JpaRepository<DealHistory,Long> {

    List<DealHistory> findAllByApartmentTypeOrderByDealDate(ApartmentType apartmentType);
}
