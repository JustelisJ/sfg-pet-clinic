package guru.springframework.sfgpetclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "specialties")
public class Speciality extends BaseEntity {

    @Column(name = "description")
    private String specialty;

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
