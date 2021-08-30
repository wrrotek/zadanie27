package com.example.zadanie;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    private PersonRepository personRepository;

    public HomeController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Person> people = personRepository.findAll();
        model.addAttribute("people", people);
        model.addAttribute("newPerson", new Person());
        return "home";
    }

    @PostMapping("/add")
    public String add(Person person) {
        personRepository.save(person);
        return "redirect:/";
    }
}
