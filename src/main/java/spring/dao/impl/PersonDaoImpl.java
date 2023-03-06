package spring.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.dao.PersonDao;
import spring.model.Person;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonDaoImpl implements PersonDao {

    @Autowired
    private  SessionFactory sessionFactory;

    @Override
    public List<Person> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery( "select c from Person c", Person.class ).getResultList();
    }

    @Override
    public Person findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get( Person.class, id );
    }

    @Override
    public void save(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.save( person );
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery( "delete from Person where id=:personId" ).setParameter( "personId", id ).executeUpdate();
    }

    @Override
    public void updatePerson(int id,Person person) {
        Session session = sessionFactory.getCurrentSession();
        Person person1 =findById(id);
        person1.setName( person.getName() );
        person1.setAge( person.getAge() );
        session.merge(person1);
    }

    @Override
    public void clear() {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Person ").executeUpdate();
    }
}
