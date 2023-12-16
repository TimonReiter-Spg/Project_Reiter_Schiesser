package com.example.dbiproj2324.Repos;
import com.example.dbiproj2324.Entities.Lehrer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LehrerRepo extends MongoRepository<Lehrer, String>{

}
