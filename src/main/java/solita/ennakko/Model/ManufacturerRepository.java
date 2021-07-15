package solita.ennakko.Model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ManufacturerRepository extends CrudRepository<Manufacturer, String> {

    long countByArrivedBefore(String date);

    long countByVaccine(String vaccine);

    @Query("SELECT sum(m.injections) from Manufacturer m WHERE m.vaccine = 'Antiqua'")
    int sumInjectionByAntiqua();

    @Query("SELECT sum(m.injections) from Manufacturer m WHERE m.vaccine = 'SolarBuddhica'")
    int sumInjectionBySolarBuddhica();

    @Query("SELECT sum(m.injections) from Manufacturer m WHERE m.vaccine = 'Zerpfy'")
    int sumInjectionByZerpfy();

    @Query(value = "SELECT count(m.arrived) from Manufacturer m WHERE datediff(day, m.arrived, '2021-04-12T11:10:06') > 30", nativeQuery = true)
    int allexpiredbottlestotal();

    @Query(value = "SELECT count(m.arrived) from Manufacturer m WHERE datediff(day, m.arrived, '2021-04-12T11:10:06')=30", nativeQuery = true)
    long expiredbottlesoneday();

    @Query(value = "SELECT sum(m.injections) from Manufacturer m WHERE m.vaccine IN ('Antiqua', 'SolarBuddhica', 'Zerpfy') AND datediff(day, m.arrived, '2021-04-12T11:10:06') >30", nativeQuery = true)
    long sumofallexpiredinjections();

    @Query("SELECT sum(m.injections) from Manufacturer m WHERE m.vaccine IN ('Antiqua', 'SolarBuddhica', 'Zerpfy')")
    long sumOfAllVaccines();

    @Query(value = "SELECT sum(m.injections) from Manufacturer m WHERE datediff(day, m.arrived, dateadd(day, 10, '2021-04-12T11:10:06' ))>30;", nativeQuery = true)
    long sumofallexpiredinjectionsafter10days();
}
