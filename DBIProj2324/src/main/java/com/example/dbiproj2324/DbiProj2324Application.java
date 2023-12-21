package com.example.dbiproj2324;

import com.example.dbiproj2324.Entities.Fach;
import com.example.dbiproj2324.Entities.Lehrer;
import com.example.dbiproj2324.Repos.LehrerRepo;
import com.example.dbiproj2324.service.LehrerService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;
import java.util.Random;

@EnableMongoRepositories(basePackages = "com.example.dbiproj2324.Repos")
@SpringBootApplication
public class DbiProj2324Application {

    public static void main(String[] args) {
        SpringApplication.run(DbiProj2324Application.class, args);

    }
}
