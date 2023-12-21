package com.example.dbiproj2324.service.impl;

import com.example.dbiproj2324.Entities.Fach;
import com.example.dbiproj2324.Entities.Lehrer;
import com.example.dbiproj2324.Repos.LehrerRepo;
import com.example.dbiproj2324.service.LehrerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class LehrerServiceImpl implements LehrerService {

    @Autowired
    private LehrerRepo lehrerRepo;


    @Override
    public List<Lehrer> allLehrer() {
        return lehrerRepo.findAll();
    }

    @Override
    public Lehrer getLehrerById(String id) {
        return lehrerRepo.findById(id).get();
    }

    @Override
    public Lehrer addLehrer(Lehrer lehrer) {
        return lehrerRepo.save(lehrer);
    }

    @Override
    public Lehrer updateLehrer(Lehrer lehrer) {
        return null;
    }

    @Override
    public void deleteLehrer(String id) {
        lehrerRepo.deleteById(id);
    }

    @Override
    public void deleteAllLehrer() {
        lehrerRepo.deleteAll();
    }

    @Override
    public List<Lehrer> getLehrerByFach(String fach) {
        return null;
    }

    @Override
    public List<Fach> getFaecherByLehrer(String id) {
        Lehrer lehrer = lehrerRepo.findById(id).get();
        return lehrer.getFaecher();
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void addFach(String id, Fach fach) {
        Lehrer lehrer = lehrerRepo.findById(id).get();
        System.out.println(fach);
        List<Fach> faecher = lehrer.getFaecher();
        faecher.add(fach);
        lehrer.setFaecher(faecher);
        lehrerRepo.save(lehrer);
    }


    @Override
    public void deleteFach(String id, Fach fach) {
        Lehrer lehrer = lehrerRepo.findById(id).get();
        List<Fach> faecher = lehrer.getFaecher();
        for (Fach f : faecher) {
            String Fachname = f.getFachName();
            int unterrichtsstunden = f.getUnterrichtsstunden();
            if (f.getFachName().equals(Fachname) &&
                    f.getUnterrichtsstunden().equals(unterrichtsstunden)) {
                faecher.remove(f);
                break;
            }
        }
        lehrer.setFaecher(faecher);
        lehrerRepo.save(lehrer);
    }

}
