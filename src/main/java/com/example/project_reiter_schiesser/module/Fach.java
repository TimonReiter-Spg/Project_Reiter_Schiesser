package com.example.project_reiter_schiesser.module;

public class Fach {
    private String fachname;
    private int unterrichtsstunden;


    public Fach(String fachname, int unterrichtsstunden) {
        this.fachname = fachname;
        this.unterrichtsstunden = unterrichtsstunden;
    }

    public String getFachname() {
        return fachname;
    }

    public void setFachname(String fachname) {
        this.fachname = fachname;
    }

    public int getUnterrichtsstunden() {
        return unterrichtsstunden;
    }

    public void setUnterrichtsstunden(int unterrichtsstunden) {
        this.unterrichtsstunden = unterrichtsstunden;
    }
}
