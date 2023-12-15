package com.example.project_reiter_schiesser.service;
import com.example.project_reiter_schiesser.module.Fach;
import com.example.project_reiter_schiesser.module.Lehrer;
import com.example.project_reiter_schiesser.repository.LehrerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LehrerServiceImpl implements LehrerService {

    private final LehrerRepository lehrerRepository;

    @Autowired
    public LehrerServiceImpl(LehrerRepository lehrerRepository) {
        this.lehrerRepository = lehrerRepository;
    }

    @Override
    public List<LehrerDTO> alleLehrerLesen() {
        List<Lehrer> lehrerList = lehrerRepository.findAll();
        return lehrerList.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LehrerDTO lehrerLesen(String id) {
        Lehrer lehrer = lehrerRepository.findById(id).orElse(null);
        return (lehrer != null) ? mapToDTO(lehrer) : null;
    }

    @Override
    public void lehrerHinzufuegen(LehrerDTO lehrerDTO) {
        Lehrer lehrer = mapToEntity(lehrerDTO);
        lehrerRepository.save(lehrer);
    }

    @Override
    public void lehrerAktualisieren(String id, LehrerDTO lehrerDTO) {
        Lehrer existingLehrer = lehrerRepository.findById(id).orElse(null);
        if (existingLehrer != null) {
            Lehrer updatedLehrer = mapToEntity(lehrerDTO);
            updatedLehrer.setId(existingLehrer.getId()); // Stelle sicher, dass die ID erhalten bleibt
            lehrerRepository.save(updatedLehrer);
        }
    }

    @Override
    public void lehrerLoeschen(String id) {
        lehrerRepository.deleteById(id);
    }

    private LehrerDTO mapToDTO(Lehrer lehrer) {
        return new LehrerDTO(
                lehrer.getId(),
                lehrer.getName(),
                lehrer.getFaecher().stream()
                        .map(this::mapToDTO)
                        .collect(Collectors.toList())
        );
    }

    private FachDTO mapToDTO(Fach fach) {
        return new FachDTO(
                fach.getFachname(),
                fach.getUnterrichtsstunden()
        );
    }

    private Lehrer mapToEntity(LehrerDTO lehrerDTO) {
        return new Lehrer(
                lehrerDTO.id(),
                lehrerDTO.name(),
                lehrerDTO.faecher().stream()
                        .map(this::mapToEntity)
                        .collect(Collectors.toList())
        );
    }

    private Fach mapToEntity(FachDTO fachDTO) {
        return new Fach(
                fachDTO.fachName(),
                fachDTO.unterrichtsstunden()
        );
    }

}
