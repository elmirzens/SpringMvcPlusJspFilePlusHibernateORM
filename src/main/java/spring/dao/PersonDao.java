package spring.dao;

import spring.model.Person;

import java.util.List;

public interface PersonDao {

     List<Person> findAll();

     Person findById(int id);

     void save(Person person);

     void delete(int id);

     void updatePerson(int id,Person person);

     void clear();
}
