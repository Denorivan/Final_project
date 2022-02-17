package com.example.final_project.controller;
import com.example.final_project.domain.Massage;
import com.example.final_project.domain.User;
import com.example.final_project.repos.MassageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private MassageRepo massageRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
                return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Massage> massages = massageRepo.findAll();
        model.put("massages", massages);
        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag, Map<String, Object> model
    ) {
        Massage massage = new Massage(text, tag, user);

        massageRepo.save(massage);

        Iterable<Massage> massages = massageRepo.findAll();
        model.put("massages", massages);

        return "main";
    }
    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Massage> massages;

        if (filter != null && !filter.isEmpty()){
            massages =massageRepo.findByTag(filter);
        }else{
            massages=massageRepo.findAll();
        }

        model.put("massages", massages);

        return "main";
    }
}