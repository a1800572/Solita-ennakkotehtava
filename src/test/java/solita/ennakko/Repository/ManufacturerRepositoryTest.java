package solita.ennakko.Repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import solita.ennakko.Model.ManufacturerRepository;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ManufacturerRepositoryTest {

    @Autowired
    private ManufacturerRepository mrepository;

    @Test
    public void countByArrivedBefore() {
        long arrivedbefore = mrepository.countByArrivedBefore("2021-04-12T11:10:06");
        assertThat(arrivedbefore).isEqualTo(5000);
    }

    @Test
    public void countByVaccineAntiqua() {
        long countvaccine = mrepository.countByVaccine("Antiqua");
        assertThat(countvaccine).isEqualTo(1661).isLessThan(1662).isGreaterThan(1660);
    }

    @Test
    public void countByVaccineSolarBuddhica() {
        long countvaccine = mrepository.countByVaccine("SolarBuddhica");
        assertThat(countvaccine).isEqualTo(1676).isLessThan(1677).isGreaterThan(1675);
    }

    @Test
    public void countByVaccineZerpfy() {
        long countvaccine = mrepository.countByVaccine("Zerpfy");
        assertThat(countvaccine).isEqualTo(1663).isLessThan(1664).isGreaterThan(1662);
    }

    @Test
    public void sumInjectionByAntiqua() {
        int sumAntiquainjections = mrepository.sumInjectionByAntiqua();
        assertThat(sumAntiquainjections).isEqualTo(6644).isLessThan(6645).isGreaterThan(6643);
    }

    @Test
    public void sumInjectionBySolarBuddhica() {
        int sumSolarBuddhicainjections = mrepository.sumInjectionBySolarBuddhica();
        assertThat(sumSolarBuddhicainjections).isEqualTo(10056).isLessThan(10057).isGreaterThan(10055);
    }

    @Test
    public void sumInjectionByZerpfy() {
        int sumZerpfyinjections = mrepository.sumInjectionByZerpfy();
        assertThat(sumZerpfyinjections).isEqualTo(8315).isLessThan(8316).isGreaterThan(8314);
    }

    @Test
    public void allexpiredbottlestotal() {
        int allexpiredbottles = mrepository.allexpiredbottlestotal();
        assertThat(allexpiredbottles).isEqualTo(3457).isLessThan(3458).isGreaterThan(3456);
    }

    @Test
    public void expiredbottlesoneday() {
        long expiredbottlesoneday = mrepository.expiredbottlesoneday();
        assertThat(expiredbottlesoneday).isEqualTo(46).isLessThan(47).isGreaterThan(45);
    }

    @Test
    public void sumofallexpiredinjections() {
        long sumofallexpiredinjections = mrepository.sumofallexpiredinjections();
        assertThat(sumofallexpiredinjections).isEqualTo(17302).isLessThan(17303).isGreaterThan(17301);
    }

    @Test
    public void sumOfAllVaccines() {
        long sumofallinjections = mrepository.sumOfAllVaccines();
        assertThat(sumofallinjections).isEqualTo(25015).isLessThan(25016).isGreaterThan(25014);
    }

    @Test
    public void sumofallexpiredinjectionsafter10days() {
        long sumofexpiredinjections10days = mrepository.sumofallexpiredinjectionsafter10days();
        assertThat(sumofexpiredinjections10days).isEqualTo(20056).isLessThan(20057).isGreaterThan(20055);
    }
}
