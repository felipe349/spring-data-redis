package br.com.felipe.redislearn.controller;

import br.com.felipe.redislearn.entity.Person;
import br.com.felipe.redislearn.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class SimpleController {

    final PersonRepository personRepository;

    @GetMapping(value = "/person/")
    void addPerson() {
        Person person = new Person();
        int age = LocalTime.now().getMinute();
        person.setAge(age);
        person.setName(randomName());
        person.setId(String.valueOf(person.hashCode()));
        personRepository.save(person);
    }

    @GetMapping(value = "/persons/")
    ResponseEntity<List<Person>> getPersons() {
        List<Person> persons = personRepository.findAll();
        return ResponseEntity.ok(persons);
    }



    // class variable
    final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";

    final java.util.Random rand = new java.util.Random();

    final Set<String> identifiers = new HashSet<String>();

    public String randomName() {
        StringBuilder builder = new StringBuilder();
        while(builder.toString().length() == 0) {
            int length = rand.nextInt(5)+5;
            for(int i = 0; i < length; i++) {
                builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
            }
            if(identifiers.contains(builder.toString())) {
                builder = new StringBuilder();
            }
        }
        return builder.toString();
    }
}
