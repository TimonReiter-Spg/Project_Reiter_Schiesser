package at.spengergasse.reischproject.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Fach {

    @Id
    private String fachName;
    private int unterrichtsstunden;

    public Fach(String name, int unterrichtsstunden) {
        this.fachName = name;
        this.unterrichtsstunden = unterrichtsstunden;
    }

    public Fach(){

    }

}
