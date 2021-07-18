package solita.ennakko.Repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import solita.ennakko.Model.ManufacturerRepository;
import solita.ennakko.Model.VaccineRepository;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class VaccineRepositoryTest {

    @Autowired
    private VaccineRepository vrepository;

    @Test
    public void countByVaccinationdateBefore() {
        long allinjectionsarrivedbefore = vrepository.countByVaccinationdateBefore("2021-04-12T11:10:06");
        assertThat(allinjectionsarrivedbefore).isEqualTo(7000).isGreaterThan(6999).isLessThan(7001);
    }
}
