package side.project.homepredictor.domain.apartmenttype.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import side.project.homepredictor.domain.apartment.entity.Apartment;
import side.project.homepredictor.domain.apartmenttype.entity.ApartmentType;

import java.util.List;

public interface ApartmentTypeRepository extends JpaRepository<ApartmentType,Long> {

    List<ApartmentType> findAllByApartment(Apartment apartment);
}
