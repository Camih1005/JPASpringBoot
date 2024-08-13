package com.jpa_orm_spring.tallerjpa_orm_spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa_orm_spring.tallerjpa_orm_spring.entities.Person;
import java.util.List;


public interface PersonRepository extends JpaRepository<Person,Long> {
List<Person> findByProgrammingLanguage(String programmingLanguage);
}
