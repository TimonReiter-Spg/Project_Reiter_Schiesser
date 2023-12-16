package com.example.dbiproj2324;

import com.example.dbiproj2324.Repos.LehrerRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = "com.example.dbiproj2324.Repos")
@SpringBootApplication
public class DbiProj2324Application {

    public static void main(String[] args) {
        SpringApplication.run(DbiProj2324Application.class, args);
    }

}
