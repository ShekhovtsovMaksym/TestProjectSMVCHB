package shekhovtsov.maksym.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import shekhovtsov.maksym.domain.Person;
import shekhovtsov.maksym.service.PersonService;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/main")
public class MainController {

    protected static Logger logger = Logger.getLogger("controller");

    @Resource(name = "personService")
    private PersonService personService;

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public String getPersons(Model model)
    {
        logger.debug("mvc get persons");

        List<Person> persons = personService.getAll();

        model.addAttribute("persons", persons);

        return "personspage";
    }

    @RequestMapping(value = "/persons/add", method = RequestMethod.GET)
    public String getAdd(Model model)
    {
        logger.debug("get add");

        model.addAttribute("personAttribute", new Person());

        return "addpage";
    }

    @RequestMapping(value = "/persons/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("personAttribute") Person person)
    {
        logger.debug("add");

        personService.add(person);

        return "addedpage";
    }


}
