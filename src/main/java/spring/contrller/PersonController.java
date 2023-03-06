package spring.contrller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.dao.PersonDao;
import spring.model.Person;


@Controller
public class PersonController {

    private final PersonDao personDao;

    public PersonController(PersonDao personDao) {
        this.personDao = personDao;
    }


    @GetMapping("/")
    public String findAll(Model model){
        model.addAttribute( "all",personDao.findAll() );
        return "find-all";
    }

    @PostMapping("/saveStudent")
    private String saveStudent(@RequestParam("name") String name, @RequestParam("age") int age){
        Person person = new Person();
        person.setName(name);
        person.setAge(age);
        personDao.save(person);
        return "redirect:/";
    }

    @GetMapping("/studentForm")
    public String saveStudentPage(){
        return "person-save";
    }

    @GetMapping("/deleteStudent/{id}")
    public String deleteById(@PathVariable int id){
      Person person = personDao.findById(id);
      personDao.delete( person.getId() );
        return "redirect:/";
    }

    @GetMapping("/get/by/{id}")
    public  String getById(Model model, @PathVariable int id) {
        Person person = personDao.findById(id);
        model.addAttribute("person",person);
        return "find";
    }

    @GetMapping("/update/{id}")
    public String updatePersonForm(@PathVariable("id") int id, Model model) {
        Person person = personDao.findById(id);
        model.addAttribute("person", person);
        return "update-person-form";
    }

    @PostMapping("/real/update/{id}")
    public String updatePerson(@RequestParam("name") String name,@RequestParam("age") int age,@PathVariable int id) {
        Person person = new Person();
        person.setName( name );
        person.setAge( age );
        personDao.updatePerson(id,person);
        return "redirect:/";
    }

    @GetMapping("/clear")
    public String clear(){
        personDao.clear();
        return "redirect:/";
    }
}
