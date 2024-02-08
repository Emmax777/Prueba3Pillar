package com.interview.peoplemanager.service;

import com.interview.peoplemanager.model.Person;
import com.interview.peoplemanager.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPeople() {
        return (List<Person>) personRepository.findAll();
    }

    public List<Person> getAllPersons() {
        return (List<Person>) personRepository.findAll();
    }

    public Optional<Person> getPersonById(Integer id) {
        return personRepository.findById(id);
    }

    public Person updatePerson(Integer id, Person updatedPerson) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            Person person = optionalPerson.get();
            person.setName(updatedPerson.getName());
            person.setLastName(updatedPerson.getLastName());
            person.setBirthdate(updatedPerson.getBirthdate());
            return personRepository.save(person);
        } else {
            throw new IllegalArgumentException("Person not found with id: " + id);
        }
    }

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public void deletePerson(Integer id) {
        personRepository.deleteById(id);
    }
}
