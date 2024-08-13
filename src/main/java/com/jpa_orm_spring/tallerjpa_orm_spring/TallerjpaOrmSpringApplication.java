package com.jpa_orm_spring.tallerjpa_orm_spring;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpa_orm_spring.tallerjpa_orm_spring.entities.Person;
import com.jpa_orm_spring.tallerjpa_orm_spring.repositories.PersonRepository;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class TallerjpaOrmSpringApplication implements CommandLineRunner{

	@Autowired
	PersonRepository personRepository;
	public static void main(String[] args) {
		SpringApplication.run(TallerjpaOrmSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		listAll();
	}
	@Transactional
	public void create(){

		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el nombre");
		String name = scanner.next();
		System.out.println("Ingrese el apellido");
		String apellido = scanner.next();
		System.out.println("Ingrese el lenguaje de programacion");
		String lenguaje = scanner.next();

		Person person = new Person();
		person.setName(name);
		person.setLastName(apellido);
		person.setProgrammingLanguage(lenguaje);

		Person personAdd = personRepository.save(person);
		System.out.println(personAdd);

		personRepository.findById(personAdd.getId()).ifPresent(System.out::println);
	}

@Transactional
public List<Person> listAll(String programmingLanguage) {

    List<Person> list = personRepository.findByProgrammingLanguage(programmingLanguage);
    return list;
}

}