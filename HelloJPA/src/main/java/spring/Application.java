package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.config.AppConfig;
import spring.domain.Person;
import spring.service.PersonService;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("spring");
        context.refresh();

        PersonService personService = (PersonService) context.getBean("personService");

        Person person = new Person("Sidor", "Sidorovich");
//        personService.add(person);
//
//        Iterable<Person> persons = personService.findAll();
//        System.out.println(persons);
//        System.out.println(personService.findById(6));
//        personService.delete(9);
        personService.update(10, person);
    }
}
