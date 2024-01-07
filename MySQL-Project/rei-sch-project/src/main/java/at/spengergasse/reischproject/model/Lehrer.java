package at.spengergasse.reischproject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Lehrer {

    @Id
    private String lehrerId;
    private String lehrerName;
    private String lehrerKuerzel;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "lehrer_fach",
            joinColumns = @JoinColumn(name = "lehrer_id"),
            inverseJoinColumns = @JoinColumn(name = "fach_id"))
    private List<Fach> faecher;



    public Lehrer(){

    }

    public Lehrer(String lehrerName, String lehrerKuerzel, List<Fach> faecher) {
        this.lehrerName = lehrerName;
        this.lehrerKuerzel = lehrerKuerzel;
        this.faecher = faecher;
    }
}
