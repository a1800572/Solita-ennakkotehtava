package solita.ennakko.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import solita.ennakko.Model.ManufacturerRepository;
import solita.ennakko.Model.VaccineRepository;

@Controller
public class ManufacturerController {
    @Autowired
    private ManufacturerRepository mrepository;

    @Autowired
    private VaccineRepository vrepository;

    @RequestMapping(value = "/")
    public String root(Model model){
        //tehtävänannossa määritelty päivämäärä
        String date = "2021-04-12T11:10:06";
        //calculating all expired vaccines after after decreasing used vaccines
        long allexpiredinjections = mrepository.sumofallexpiredinjections();
        long allusedinjections = vrepository.countByVaccinationdateBefore(date);
        long allexpiredsubtraction = allexpiredinjections-allusedinjections;
        //calculating all vacines left for use
        long allvaccines = mrepository.sumOfAllVaccines();
        long vaccinesleftforusage = allvaccines-allexpiredsubtraction-allusedinjections;
        //calculating all vaccines which will expire within 10 days
        long allvaccinesexpiredafter10days = mrepository.sumofallexpiredinjectionsafter10days();
        long allvaccinesexpiredwithin10days = allvaccinesexpiredafter10days-allexpiredinjections;

        model.addAttribute("allorders", mrepository.countByArrivedBefore(date));
        model.addAttribute("allusedvaccines", allusedinjections);

        model.addAttribute("antiqua", mrepository.countByVaccine("Antiqua"));
        model.addAttribute("antiquainjections", mrepository.sumInjectionByAntiqua());

        model.addAttribute("solarbuddhica", mrepository.countByVaccine("SolarBuddhica"));
        model.addAttribute("solarbuddhicainjections", mrepository.sumInjectionBySolarBuddhica());

        model.addAttribute("zerpfy", mrepository.countByVaccine("Zerpfy"));
        model.addAttribute("zerpfyinjections", mrepository.sumInjectionByZerpfy());

        model.addAttribute("expiredbottlescount", mrepository.allexpiredbottlestotal());
        model.addAttribute("expiredbottlesoneday", mrepository.expiredbottlesoneday());
        model.addAttribute("allexpiredinjections", allexpiredsubtraction);

        model.addAttribute("allvaccinesleftforuse", vaccinesleftforusage);

        model.addAttribute("injectionsexpiredwithin10days", allvaccinesexpiredwithin10days);
        return "root";
    }
}
