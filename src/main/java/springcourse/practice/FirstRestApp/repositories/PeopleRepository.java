package springcourse.practice.FirstRestApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springcourse.practice.FirstRestApp.models.Person;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {

}
