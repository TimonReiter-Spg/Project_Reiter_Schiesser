package com.example.project_reiter_schiesser.restapi;

import com.example.project_reiter_schiesser.service.LehrerDTO;
import com.example.project_reiter_schiesser.service.LehrerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/lehrer")
public class LehrerController {

    @Autowired
    private LehrerService lehrerService;

    @GetMapping("/alle")
    public String alleLehrer(Model model) {
        model.addAttribute("lehrerList", lehrerService.alleLehrerLesen());
        return "alleLehrer";
    }

    @GetMapping("/{id}")
    public String lehrerLesen(@PathVariable String id, Model model) {
        model.addAttribute("lehrer", lehrerService.lehrerLesen(id));
        return "lehrerDetails";
    }

    @GetMapping("/hinzufuegen")
    public String lehrerHinzufuegenForm(Model model) {
        model.addAttribute("lehrerDTO", new LehrerDTO(null,null,null));
        return "lehrerHinzufuegen";
    }

    @PostMapping("/hinzufuegen")
    public String lehrerHinzufuegen(@ModelAttribute LehrerDTO lehrerDTO) {
        lehrerService.lehrerHinzufuegen(lehrerDTO);
        return "redirect:/lehrer/alle";
    }

    @GetMapping("/aktualisieren/{id}")
    public String lehrerAktualisierenForm(@PathVariable String id, Model model) {
        model.addAttribute("lehrerDTO", lehrerService.lehrerLesen(id));
        return "lehrerAktualisieren";
    }

    @PostMapping("/aktualisieren/{id}")
    public String lehrerAktualisieren(@PathVariable String id, @ModelAttribute LehrerDTO lehrerDTO) {
        lehrerService.lehrerAktualisieren(id, lehrerDTO);
        return "redirect:/lehrer/alle";
    }

    @GetMapping("/loeschen/{id}")
    public String lehrerLoeschen(@PathVariable String id) {
        lehrerService.lehrerLoeschen(id);
        return "redirect:/lehrer/alle";
    }
}
