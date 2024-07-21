package org.example.entrainementspringperson.repository;

import org.example.entrainementspringperson.model.Person;
import org.example.entrainementspringperson.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
public class PersonRepository {
    private PersonService personService;

    public PersonRepository(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/")
    public String homeWithList(Model model) {
        List<Person> personList = personService.getPersons();
        model.addAttribute("personList", personList);
        return "home";
    }

    @GetMapping("/name/{nameperson}")
    public String namePerson(@PathVariable String nameperson, Model model) {
        List<Person> personList = personService.getPersonsByName(nameperson);
        model.addAttribute("personList", personList);
        System.out.println(model);
        return "home";
    }

    @GetMapping("/detail")
    public String detailId(@RequestParam UUID id, Model model) {
        List<Person> personListId = personService.getPersonsById(id);
        model.addAttribute("personListId", personListId);
        System.out.println(model);
        return "detail";
    }

}
