package springcourse.practice.FirstRestApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springcourse.practice.FirstRestApp.models.Person;
import springcourse.practice.FirstRestApp.services.PeopleService;
import springcourse.practice.FirstRestApp.util.PersonErrorResponse;
import springcourse.practice.FirstRestApp.util.PersonNotFoundException;

import java.util.List;

@RestController // @Controller + @ResponseBody над каждым методом
@RequestMapping("/people")
public class  PeopleController {

    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping()
    public List<Person> getPeople() {
        return peopleService.findAll(); // Jackson конвертирует эти объекты в JSON (Spring автоматически использует Jackson)
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable("id") int id) {
        return peopleService.findOne(id); // Jackson конвертирует в JSON (Spring автоматически использует Jackson)
    }

    @ExceptionHandler // аннотируем тот метод который в себя ловит исключение и возвращает необходимый JSON объект
    private ResponseEntity<PersonErrorResponse> handleException(PersonNotFoundException e) {
        PersonErrorResponse response = new PersonErrorResponse(
                "Person with this id wasn't found!",
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND); // NOT_FOUND 404 статус ответа
    }
}
