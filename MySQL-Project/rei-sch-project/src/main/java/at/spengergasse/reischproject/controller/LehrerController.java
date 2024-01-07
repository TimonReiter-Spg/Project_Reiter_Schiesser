package at.spengergasse.reischproject.controller;

import at.spengergasse.reischproject.model.Lehrer;
import at.spengergasse.reischproject.service.LehrerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Lehrer")
public class LehrerController {

    LehrerService lehrerService;

    public LehrerController(LehrerService lehrerService) {
        this.lehrerService = lehrerService;
    }


    @GetMapping(value = "{lehrerId}")
    public Lehrer getLehrerById(@PathVariable("lehrerId") String lehrerId) {

        return lehrerService.getLehrer(lehrerId);
    }

    @GetMapping()
    public List<Lehrer> getAllLehrer() {
        return lehrerService.getAllLehrer();
    }

    @PostMapping
    public String createLehrer(@RequestBody Lehrer lehrer) {
        lehrerService.createLehrer(lehrer);
        return "Lehrer created successfully";
    }

    @PutMapping
    public String updateLehrer(@RequestBody Lehrer lehrer){
        lehrerService.updateLehrer(lehrer);
        return "Lehrer updated successfully";
    }

    @DeleteMapping("{lehrerId}")
    public String deleteLehrer(@PathVariable ("lehrerId") String lehrerId){
        lehrerService.deleteLehrer(lehrerId);
        return "Lehrer deleted successfully";
    }
}
