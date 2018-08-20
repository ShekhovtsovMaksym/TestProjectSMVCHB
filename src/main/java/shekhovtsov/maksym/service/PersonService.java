package shekhovtsov.maksym.service;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;
import shekhovtsov.maksym.domain.Person;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PersonService
{
    protected static Logger logger = Logger.getLogger("service");

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public List<Person> getAll()
    {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createSQLQuery("SELECT * FROM PERSON");

        return (ArrayList) query.list();
    }

    public Person get(Integer id)
    {
        logger.debug("set");
        Session session = sessionFactory.getCurrentSession();
        Person person = session.get(Person.class, id);

        return person;
    }

    public void add(Person person)
    {
        logger.debug("add");
        Session session = sessionFactory.getCurrentSession();
        session.save(person);
    }

    public void del(Person person)
    {
        logger.debug("del by obj");
        Session session = sessionFactory.getCurrentSession();
        session.delete(person);
    }

    public void del(Integer id)
    {
        logger.debug("del by id");
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.get(Person.class, id));
    }

    public void edit(Person person)
    {
        Session session = sessionFactory.getCurrentSession();
        session.update(person);
    }

}
