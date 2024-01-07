package at.spengergasse.reischproject.service.impl;

import at.spengergasse.reischproject.model.Fach;
import at.spengergasse.reischproject.repository.FachRepository;
import at.spengergasse.reischproject.service.FachService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FachServiceImpl implements FachService {

    FachRepository fachRepository;

    public FachServiceImpl(FachRepository fachRepository) {
        this.fachRepository = fachRepository;
    }


    @Override
    public String createFach(Fach fach) {
        fachRepository.save(fach);
        return "Fach successfully created";
    }

    @Override
    public String updateFach(Fach fach) {
        fachRepository.save(fach);
        return "Fach successfully updated";
    }

    @Override
    public String deleteFach(String fachName) {
        fachRepository.deleteById(fachName);
        return "Fach successfully deleted";
    }

    @Override
    public Fach getFach(String fachName) {
        return fachRepository.findById(fachName).get();
    }

    @Override
    public List<Fach> getAllFaecher() {
        return fachRepository.findAll();
    }
}
