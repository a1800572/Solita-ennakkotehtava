package solita.ennakko.Model;

import org.springframework.data.repository.CrudRepository;

public interface VaccineRepository extends CrudRepository<Vaccine, String> {

    long countByVaccinationdateBefore(String date);
}
