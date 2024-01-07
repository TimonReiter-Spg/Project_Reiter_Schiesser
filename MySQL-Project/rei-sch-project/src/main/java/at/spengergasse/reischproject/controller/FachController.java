package at.spengergasse.reischproject.controller;

import at.spengergasse.reischproject.model.Fach;
import at.spengergasse.reischproject.service.FachService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Fach")
public class FachController {

    FachService fachService;

    public FachController(FachService fachService) {
        this.fachService = fachService;
    }

    @GetMapping(value = "{fachName}")
    public Fach getFach (@PathVariable ("fachName") String fachName) {
        return fachService.getFach(fachName);
    }

    @GetMapping()
    public List<Fach> getAllFaecher() {
        return fachService.getAllFaecher();
    }

    @PostMapping
    public String createFach (@RequestBody Fach fach){
        fachService.createFach(fach);
        return "Fach created successfully";
    }

    @PutMapping
    public String updateFach (@RequestBody Fach fach){
        fachService.updateFach(fach);
        return "Fach updated successfully";
    }

    @DeleteMapping("{fachName}")
    public String deleteFach (@PathVariable("fachName") String fachName){
        fachService.deleteFach(fachName);
        return "Fach deleted successfully";
    }

}
