package at.spengergasse.reischproject.repository;

import at.spengergasse.reischproject.model.Lehrer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LehrerRepository extends JpaRepository<Lehrer, String> {
    //List<Lehrer> findByLehrer(String lehrer);
}
