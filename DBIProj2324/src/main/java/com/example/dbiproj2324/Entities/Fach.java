package com.example.dbiproj2324.Entities;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Fach {

    private String FachName;
    @NotNull(message = "Unterrichtsstunden is required")
    @Min(value = 0, message = "Unterrichtsstunden must be a positive number")
    private Integer unterrichtsstunden;

    public Fach() {
    }
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

    public Integer getUnterrichtsstunden() {
        return unterrichtsstunden;
    }

    public void setUnterrichtsstunden(Integer unterrichtsstunden) {
        this.unterrichtsstunden = unterrichtsstunden;
    }

    @Override
    public String toString() {
        return "Fach{" +
                "fachName='" + FachName + '\'' +
                ", unterrichtsstunden=" + unterrichtsstunden +
                '}';
    }
}
