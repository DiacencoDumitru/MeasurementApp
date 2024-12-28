package springcourse.practice.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

// Для DTO убираем @Column, и остается валидация полей. DTO работает только на уровне Controller.
// От Client приходит только name
public class SensorDTO {
    @Column(name = "name")
    @NotEmpty(message = "Название не должно быть пустым")
    @Size(min = 3, max = 30, message = "Название сенсора должно быть от 3 до 30 символов!")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
