package shekhovtsov.maksym.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import shekhovtsov.maksym.aop.AopInterface;
import shekhovtsov.maksym.domain.Person;
import shekhovtsov.maksym.service.PersonService;

import javax.annotation.Resource;
import java.util.List;
import com.connecture.logging.exectime.LogExecutionTime;

@RestController
public class MainController {

    protected static Logger logger = Logger.getLogger("controller");

    @Resource(name = "personService")
    private PersonService personService;

    @Autowired
    private ExternalClass externalClass;

    @GetMapping(value = "/persons", produces = MediaType.APPLICATION_JSON_VALUE)
    @LogExecutionTime
    public ResponseEntity<List<Person>> getPersons()
    {
        externalClass.testMethod();

        logger.debug("mvc get persons");

        List<Person> persons = personService.getAll();

        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @GetMapping(value = "/persons/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> getAdd(@PathVariable("id") int id)
    {
        logger.debug("get add");

        Person person = personService.get(id);

        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @RequestMapping(value = "/persons/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("personAttribute") Person person)
    {
        logger.debug("add");

        personService.add(person);

        return "addedpage";
    }
}
