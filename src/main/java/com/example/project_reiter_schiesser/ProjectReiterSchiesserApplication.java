package com.example.project_reiter_schiesser;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProjectReiterSchiesserApplication {

    public static void main(String[] args) {
        // Verbindung zur MongoDB-Datenbank herstellen
        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://TestUser:123abc@mongotesting.o2v3bcw.mongodb.net/?retryWrites=true&w=majority")) {

            // Datenbank und Sammlung auswählen
            MongoDatabase database = mongoClient.getDatabase("LehrerFachDb");
            MongoCollection<Document> lehrerFachCollection = database.getCollection("LehrerFachCollection");

            // Beispiel: Lehrer hinzufügen
            Document lehrer = new Document("name", "Joachim Grueneis")
                    .append("faecher", List.of(
                            new Document("fachName", "Informatik").append("unterrichtsstunden", 20)
                    ));

            lehrerFachCollection.insertOne(lehrer);
        }
    }

}
