package com.example.dbiproj2324.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "lehrer")
public class Lehrer {

    @Id
    private String _id;
    private String name;
    private List<Fach> faecher;

    public Lehrer(String name, List<Fach> faecher) {
        this.name = name;
        this.faecher = faecher;
    }
}
