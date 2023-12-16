package com.example.dbiproj2324.service;

import com.example.dbiproj2324.Entities.Fach;
import com.example.dbiproj2324.Entities.Lehrer;

import java.util.List;

public interface LehrerService {
    public List<Lehrer> allLehrer();

    public Lehrer getLehrerById(String id);

    public Lehrer addLehrer(Lehrer lehrer);

    public Lehrer updateLehrer(Lehrer lehrer);

    public void deleteLehrer(String id);

    public List<Lehrer> getLehrerByFach(String fach);

    public List<Fach> getFaecherByLehrer(String lehrer);

    public void deleteAll();

    public void addFach(String id, Fach fach);

}
