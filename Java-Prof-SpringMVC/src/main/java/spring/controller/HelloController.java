package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import spring.domain.Person;
import spring.service.PersonService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    @Autowired
    PersonService service;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/hello")
    public String hello(Model model) {
        service.test();
        model.addAttribute("name", "boys");
        return "hello";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("persons", service.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String showAddPersonForm(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "add";
    }

    @PostMapping("/add")
    public String addPerson(Model model,
                            @ModelAttribute("person") Person person) {
        String firstName = person.getFirstName();
        String lastName = person.getLastName();

        if ((firstName != null && firstName.length() > 0) && (lastName != null && lastName.length() > 0)) {
            Person newPerson = new Person(person.getFirstName(), person.getLastName());
            service.add(newPerson);

            return "redirect:/list";
        }
        model.addAttribute("errorMessage", "FirstName & LastName is required!");
        return "add";
    }

    @GetMapping("/update/{id}")
    public String updateForm(Model model, @PathVariable final Integer id) {
        Person person = service.findById(id);
        model.addAttribute("person", person);
        return "update";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("person") Person person) {
        System.out.println(person.getId());
        String firstName = person.getFirstName();
        String lastName = person.getLastName();

        if ((firstName != null && firstName.length() > 0) && (lastName != null && lastName.length() > 0)) {
            service.update(person);
            return "redirect:/list";
        }
        model.addAttribute("errorMessage", "FirstName & LastName is required!");
        return "update";
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable final Integer id) {
        service.delete(id);
        return "redirect:/list";
    }
}
