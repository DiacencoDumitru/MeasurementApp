package springcourse.practice.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
/*
Здесь пришлось реализовать интерфейс Serializable, потому-что в Measurement в котором мы ссылаемся на Sensor.
Мы в качестве ключа у Sensor используем поля "name", выстраиваем связь OneToMany не на основании id а на основании поля name которое тоже уникальное.
Такая особенность Hibernate, что ему нужно в случае если мы работаем не с числовыми ключами, ему нужно в сущность указать implements Serializable.
 */
@Entity
@Table(name = "Sensor")
public class Sensor implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    @NotEmpty(message = "Название не должно быть пустым")
    @Size(min = 3, max = 30, message = "Название сенсора должно быть от 3 до 30 символов!")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
