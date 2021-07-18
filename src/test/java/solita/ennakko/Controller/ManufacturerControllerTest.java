package solita.ennakko.Controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import solita.ennakko.Model.ManufacturerRepository;
import solita.ennakko.Model.VaccineRepository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(ManufacturerController.class)
public class ManufacturerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ManufacturerRepository mockMrepository;
    @MockBean
    private VaccineRepository mockVrepository;

    @Test
    public void testRoot() throws Exception {
        // Setup
        when(mockMrepository.sumofallexpiredinjections()).thenReturn(0L);
        when(mockVrepository.countByVaccinationdateBefore("date")).thenReturn(0L);
        when(mockMrepository.sumOfAllVaccines()).thenReturn(0L);
        when(mockMrepository.sumofallexpiredinjectionsafter10days()).thenReturn(0L);
        when(mockMrepository.countByArrivedBefore("date")).thenReturn(0L);
        when(mockMrepository.countByVaccine("vaccine")).thenReturn(0L);
        when(mockMrepository.sumInjectionByAntiqua()).thenReturn(0);
        when(mockMrepository.sumInjectionBySolarBuddhica()).thenReturn(0);
        when(mockMrepository.sumInjectionByZerpfy()).thenReturn(0);
        when(mockMrepository.allexpiredbottlestotal()).thenReturn(0);
        when(mockMrepository.expiredbottlesoneday()).thenReturn(0L);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/")
                .accept(MediaType.TEXT_HTML))
                .andReturn().getResponse();

        // Verify the results
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }
}
