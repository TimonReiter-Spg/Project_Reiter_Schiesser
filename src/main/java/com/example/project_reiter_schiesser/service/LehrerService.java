package com.example.project_reiter_schiesser.service;

import java.util.List;

public interface LehrerService {
    List<LehrerDTO> alleLehrerLesen();
    LehrerDTO lehrerLesen(String id);
    void lehrerHinzufuegen(LehrerDTO lehrerDTO);
    void lehrerAktualisieren(String id, LehrerDTO lehrerDTO);
    void lehrerLoeschen(String id);
}
