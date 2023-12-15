package com.example.project_reiter_schiesser.repository;

import com.example.project_reiter_schiesser.module.Lehrer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LehrerRepository extends MongoRepository<Lehrer, String> {
}
