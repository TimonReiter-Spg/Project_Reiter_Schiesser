package at.spengergasse.reischproject.service;

import at.spengergasse.reischproject.model.Fach;

import java.util.List;

public interface FachService {
    public String createFach(Fach fach);
    public String updateFach(Fach fach);
    public String deleteFach(String fachName);
    public Fach getFach(String fachName);
    public List<Fach> getAllFaecher();

}
