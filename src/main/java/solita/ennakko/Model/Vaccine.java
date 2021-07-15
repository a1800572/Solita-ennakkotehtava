package solita.ennakko.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Vaccine")
public class Vaccine {

    @Id
    private String vaccinationid;
    private String sourcebottle;
    private String gender;
    private String vaccinationdate;

    public Vaccine(){}

    //just in case muokkausta varten
    public Vaccine(String vaccinationid, String sourceBottle, String gender, String vaccinationdate){
        super();
        this.vaccinationid=vaccinationid;
        this.sourcebottle=sourcebottle;
        this.gender=gender;
        this.vaccinationdate=vaccinationdate;
    }

    public String getVaccinationid() {
        return vaccinationid;
    }

    public void setVaccinationid(String vaccinationid) {
        this.vaccinationid = vaccinationid;
    }

    public String getSourcebottle() {
        return sourcebottle;
    }

    public void setSourcebottle(String sourcebottle) {
        this.sourcebottle = sourcebottle;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getVaccinationdate() {
        return vaccinationdate;
    }

    public void setVaccinationdate(String vaccinationdate) {
        this.vaccinationdate = vaccinationdate;
    }
}
