package solita.ennakko.Model;

import javax.persistence.*;

@Entity(name = "Manufacturer")
public class Manufacturer {

    @Id
    private String id;
    private int ordernumber;
    private String responsibleperson;
    private String healthcaredistrict;
    private String vaccine;
    private int injections;
    private String arrived;

    public Manufacturer(){}

    //just in case muokkausta varten
    public Manufacturer(String id, int ordernumber, String responsibleperson, String healthcaredistrict, String vaccine, int injections, String arrived){
        super();
        this.id = id;
        this.ordernumber = ordernumber;
        this.responsibleperson = responsibleperson;
        this.healthcaredistrict = healthcaredistrict;
        this.vaccine = vaccine;
        this.injections = injections;
        this.arrived = arrived;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(int ordernumber) {
        this.ordernumber = ordernumber;
    }

    public String getResponsibleperson() {
        return responsibleperson;
    }

    public void setResponsibleperson(String responsibleperson) {
        this.responsibleperson = responsibleperson;
    }

    public String getHealthcaredistrict() {
        return healthcaredistrict;
    }

    public void setHealthcaredistrict(String healthcaredistrict) {
        this.healthcaredistrict = healthcaredistrict;
    }

    public String getVaccine() {
        return vaccine;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }

    public int getInjections() {
        return injections;
    }

    public void setInjections(int injections) {
        this.injections = injections;
    }

    public String getArrived() {
        return arrived;
    }

    public void setArrived(String arrived) {
        this.arrived = arrived;
    }
}
