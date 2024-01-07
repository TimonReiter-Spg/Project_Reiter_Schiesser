package at.spengergasse.reischproject.repository;

import at.spengergasse.reischproject.model.Fach;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FachRepository extends JpaRepository<Fach, String> {
    //List<Fach> findByFachName(String fachName);
}
