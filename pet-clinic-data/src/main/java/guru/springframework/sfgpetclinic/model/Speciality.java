package guru.springframework.sfgpetclinic.model;

public class Speciality extends BaseEntity {

    private String specialty;

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
