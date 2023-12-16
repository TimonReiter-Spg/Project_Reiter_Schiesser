package com.example.dbiproj2324.Entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


public class Fach {

    private String FachName;
    private int unterrichtsstunden;

    public Fach(String FachName, int unterrichtsstunden) {
        this.FachName = FachName;
        this.unterrichtsstunden = unterrichtsstunden;
    }
}
