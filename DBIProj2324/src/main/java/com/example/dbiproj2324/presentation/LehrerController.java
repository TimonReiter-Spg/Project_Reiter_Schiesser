package com.example.dbiproj2324.presentation;

import com.example.dbiproj2324.Entities.Fach;
import com.example.dbiproj2324.Entities.Lehrer;
import com.example.dbiproj2324.service.LehrerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/lehrer")
public class LehrerController {
    @Autowired
    private LehrerService lehrerService;

    @GetMapping("/all")
    public String alleLehrer(Model model)
    {
        model.addAttribute("lehrer", lehrerService.allLehrer());
        return "AllLehrerSite";
    }

    @PostMapping("/all")
    public String fillList(@RequestParam("name") String name ,Model model)
   {
        Lehrer lehrer = new Lehrer(name, new ArrayList<>());
        lehrerService.addLehrer(lehrer);
        return "redirect:/lehrer/all";
    }

    @GetMapping("/{id}")
    public String fillSite(@PathVariable String id, Model model)
    {
        model.addAttribute("lehrer", lehrerService.getLehrerById(id));
        model.addAttribute("faecher", lehrerService.getFaecherByLehrer(id));
        return "Lehrer-Site";
    }

    @PostMapping("/{id}")
    public String saveFach(@PathVariable String id, @RequestParam("fachName") String name, @RequestParam("unterrichtsstunden") Integer stunden, Model model) {
        Fach fach = new Fach(name, stunden);
        System.out.println(fach);
        lehrerService.addFach(id, fach);
        return "redirect:/lehrer/" + id;
    }

    @GetMapping("/{id}/{fachName}/{unterrichtsstunden}/delete")
    public String deleteFach(@PathVariable String id, @PathVariable String fachName, @PathVariable Integer unterrichtsstunden) {
        Fach fach = new Fach(fachName, unterrichtsstunden);
        System.out.println(fach);
        lehrerService.deleteFach(id, fach);
        return "redirect:/lehrer/" + id;
    }

    @GetMapping("/delete/" + "{id}")
    public String lehrerLoeschen(@PathVariable String id) {
        lehrerService.deleteLehrer(id);
        return "redirect:/lehrer/all";
    }

}
