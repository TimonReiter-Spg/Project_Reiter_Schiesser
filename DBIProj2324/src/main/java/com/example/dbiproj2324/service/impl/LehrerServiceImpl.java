package com.example.dbiproj2324.service.impl;

import com.example.dbiproj2324.Entities.Fach;
import com.example.dbiproj2324.Entities.Lehrer;
import com.example.dbiproj2324.Repos.LehrerRepo;
import com.example.dbiproj2324.service.LehrerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LehrerServiceImpl implements LehrerService {

    @Autowired
    private LehrerRepo lehrerRepo;


    @Override
    public List<Lehrer> allLehrer() {
        System.out.println(lehrerRepo.findAll());
        return lehrerRepo.findAll();
    }

    @Override
    public Lehrer getLehrerById(String id) {
        return lehrerRepo.findById(id).get();
    }

    @Override
    public Lehrer addLehrer(Lehrer lehrer) {
        System.out.println(lehrer);
        return lehrerRepo.save(lehrer);
    }

    @Override
    public Lehrer updateLehrer(Lehrer lehrer) {
        return null;
    }

    @Override
    public void deleteLehrer(String id) {

    }

    @Override
    public List<Lehrer> getLehrerByFach(String fach) {
        return null;
    }

    @Override
    public List<Fach> getFaecherByLehrer(String id) {
        Lehrer lehrer = lehrerRepo.findById(id).get();
        System.out.println(lehrer);
        return lehrer.getFaecher();
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void addFach(String id, Fach fach) {
        Lehrer lehrer = lehrerRepo.findById(id).get();
        lehrer.getFaecher().add(fach);
        System.out.println(fach);
        lehrerRepo.save(lehrer);
    }
}
