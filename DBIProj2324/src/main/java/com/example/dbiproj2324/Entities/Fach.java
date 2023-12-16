package com.example.dbiproj2324.Entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Fach {

    private String FachName;
    private int unterrichtsstunden;

    public Fach(String FachName, int unterrichtsstunden) {
        this.FachName = FachName;
        this.unterrichtsstunden = unterrichtsstunden;
    }

    public String getFachName() {
        return FachName;
    }

    public void setFachName(String fachName) {
        FachName = fachName;
    }

    public int getUnterrichtsstunden() {
        return unterrichtsstunden;
    }

    public void setUnterrichtsstunden(int unterrichtsstunden) {
        this.unterrichtsstunden = unterrichtsstunden;
    }
}
