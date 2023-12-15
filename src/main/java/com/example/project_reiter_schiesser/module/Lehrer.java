package com.example.project_reiter_schiesser.module;

import java.util.List;
import java.util.UUID;

public class Lehrer {

    private UUID id;
    private String name;
    private List<Fach> faecher;


    public Lehrer(UUID id, String name, List<Fach> faecher) {
        this.id = id;
        this.name = name;
        this.faecher = faecher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Fach> getFaecher() {
        return faecher;
    }

    public void setFaecher(List<Fach> faecher) {
        this.faecher = faecher;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
