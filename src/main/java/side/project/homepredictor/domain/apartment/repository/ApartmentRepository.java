package side.project.homepredictor.domain.apartment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import side.project.homepredictor.domain.apartment.entity.Apartment;
import side.project.homepredictor.domain.apartmenttype.entity.ApartmentType;

public interface ApartmentRepository extends JpaRepository<Apartment,Long> {
}
