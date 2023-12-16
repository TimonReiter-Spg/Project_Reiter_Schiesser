package com.example.dbiproj2324.presentation;

import com.example.dbiproj2324.Entities.Lehrer;
import com.example.dbiproj2324.service.LehrerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

//    @RequestMapping("/all")
//    public String fillList(Model model)
//    {
//        return "AllLehrerSite";
//    }

    @GetMapping("/all" + "/{id}")
    public String fillSite(@PathVariable String id, Model model)
    {
        model.addAttribute("lehrer", lehrerService.getLehrerById(id));
        model.addAttribute("faecher", lehrerService.getFaecherByLehrer(id));
        return "LehrerSite";
    }

    @PostMapping("/{id}")
    public String lehrerSpeichern(@RequestBody Lehrer lehrer, Model model) {
        return "AllLehrerSite";
    }


}
