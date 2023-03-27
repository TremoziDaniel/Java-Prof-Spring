package spring.service;

import org.springframework.stereotype.Service;
import spring.domain.Person;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService extends TestService {
    private static List<Person> persons = new ArrayList<Person>();

    public PersonService() {
        add(new Person("Bill", "Gates"));
        add(new Person("Steve", "Jobs"));
    }

    public void add(Person person) {
        persons.add(person);
    }

    public Person findById(Integer id) {
        for (Person person : persons) {
            if(id == person.getId()) {
                return person;
            }
        }
        return null;
    }

    public void update(Person person) {
        Person updtPerson = findById(person.getId());
        if (updtPerson != null) {
            System.out.println("Complete");
            updtPerson.setFirstName(person.getFirstName());
            updtPerson.setLastName(person.getLastName());
        }
    }

    public void delete(Integer id) {
        for (Person person : persons) {
            if(id == person.getId()) {
                persons.remove(person);
                return;
            }
        }
    }

    public List<Person> findAll() {
        return persons;
    }
}