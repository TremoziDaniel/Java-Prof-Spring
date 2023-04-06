package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.domain.Person;
import spring.domain.Position;
import spring.repository.PersonRepository;
import spring.repository.PositionRepository;

import java.util.List;

@Service
public class    PersonService {
    @Autowired
    PersonRepository persons;

    @Autowired
    PositionRepository positions;

    public PersonService() {
//        add(new Person("Bill", "Gates"));
//        add(new Person("Steve", "Jobs"));
    }

    public void add(Person person) {
        Person newPerson = new Person(person.getFirstName(), person.getLastName());
        Position newPosition = positions.findById(1).get();
        newPerson.setPosition(newPosition);
        persons.save(newPerson);
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