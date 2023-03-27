package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.domain.Person;
import spring.repository.PersonRepository;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }

    public void add(Person person) {
        personRepository.save(person);
    }

    public Person findById(Integer id) {
        return personRepository.findById(id).get();
    }

    public void delete(Integer id) {
        personRepository.deleteById(id);
    }

    public void update(Integer id, Person updtPerson) {
        Person person = personRepository.findById(id).get();
        personRepository.delete(person);
        person.setFirstname(updtPerson.getFirstname());
        person.setLastname(updtPerson.getLastName());
// Недоработано, так как по сути просто удаляется старый и добавляется новый.
// Лучше бы через Query консоль изменять.

        personRepository.save(person);
    }
}
