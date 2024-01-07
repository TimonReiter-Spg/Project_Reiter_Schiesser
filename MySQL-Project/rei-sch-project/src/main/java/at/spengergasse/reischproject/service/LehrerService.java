package at.spengergasse.reischproject.service;

import at.spengergasse.reischproject.model.Lehrer;

import java.util.List;

public interface LehrerService {
    public String createLehrer(Lehrer lehrer);
    public String updateLehrer(Lehrer lehrer);
    public String deleteLehrer(String lehrerId);
    public Lehrer getLehrer(String lehrerId);
    public List<Lehrer> getAllLehrer();
}
