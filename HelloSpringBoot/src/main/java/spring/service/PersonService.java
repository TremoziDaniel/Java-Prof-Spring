package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.domain.Person;
import spring.repository.PersonRepository;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonRepository persons;

    public PersonService() {
//        add(new Person("Bill", "Gates"));
//        add(new Person("Steve", "Jobs"));
    }

    public void add(Person person) {
        persons.save(person);
    }

    public Person findById(Integer id) {
        return persons.findById(id).get();
    }

    public void update(Person person) {
        persons.save(person);
    }

    public void delete(Integer id) {
        persons.deleteById(id);
    }

    public List<Person> findAll() {
        return persons.findAll();
    }
}