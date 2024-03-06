package side.project.homepredictor.domain.apartment.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import side.project.homepredictor.domain.apartment.entity.Apartment;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {

    List<Apartment> findByAddressContains(String address);
}
