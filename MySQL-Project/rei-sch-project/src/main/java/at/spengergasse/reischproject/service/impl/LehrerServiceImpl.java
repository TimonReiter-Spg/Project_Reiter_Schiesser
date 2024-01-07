package at.spengergasse.reischproject.service.impl;

import at.spengergasse.reischproject.model.Lehrer;
import at.spengergasse.reischproject.repository.LehrerRepository;
import at.spengergasse.reischproject.service.LehrerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LehrerServiceImpl implements LehrerService {
    LehrerRepository lehrerRepository;

    public LehrerServiceImpl(LehrerRepository lehrerRepository) {
        this.lehrerRepository = lehrerRepository;
    }

    @Override
    public String createLehrer(Lehrer lehrer) {
        lehrerRepository.save(lehrer);
        return "Lehrer successfully created";
    }

    @Override
    public String updateLehrer(Lehrer lehrer) {
        lehrerRepository.save(lehrer);
        return "Lehrer successfully updated";
    }

    @Override
    public String deleteLehrer(String lehrerId) {
        lehrerRepository.deleteById(lehrerId);
        return "Lehrer successfully deleted";
    }

    @Override
    public Lehrer getLehrer(String lehrerId) {
        return lehrerRepository.findById(lehrerId).get();
    }

    @Override
    public List<Lehrer> getAllLehrer() {
        return lehrerRepository.findAll();
    }
}
