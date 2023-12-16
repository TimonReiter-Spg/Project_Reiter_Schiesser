package com.example.dbiproj2324.presentation;

import com.example.dbiproj2324.Entities.Lehrer;
import com.example.dbiproj2324.service.LehrerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lehrer")
public class LehrerController {
    @Autowired
    private LehrerService lehrerService;

    @GetMapping("/all")
    public List<Lehrer> alleLehrer() {
        return lehrerService.allLehrer();
    }

    @GetMapping("/{id}")
    public String fillSite(@PathVariable Integer id, Model model)
    {
        return "AllLehrerSite";
    }

    @PostMapping("/{id}")
    public String lehrerSpeichern(@RequestBody Lehrer lehrer, Model model) {
        return "AllLehrerSite";
    }


}
