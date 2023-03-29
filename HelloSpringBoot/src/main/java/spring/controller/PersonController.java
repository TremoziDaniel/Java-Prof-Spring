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

@Controller
public class PersonController {

    @Autowired
    PersonService service;

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("persons", service.findAll());
        return "index";
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
        String firstName = person.getFirstname();
        String lastName = person.getLastname();

        if ((firstName != null && firstName.length() > 0) && (lastName != null && lastName.length() > 0)) {
            Person newPerson = new Person(person.getFirstname(), person.getLastname());
            service.add(newPerson);

            return "redirect:/";
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
        String firstName = person.getFirstname();
        String lastName = person.getLastname();

        if ((firstName != null && firstName.length() > 0) && (lastName != null && lastName.length() > 0)) {
            service.update(person);
            return "redirect:/";
        }
        model.addAttribute("errorMessage", "FirstName & LastName is required!");
        return "update";
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable final Integer id) {
        service.delete(id);
        return "redirect:/";
    }
}
