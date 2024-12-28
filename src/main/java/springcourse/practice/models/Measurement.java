package springcourse.practice.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
/*
Одна деталь, мы тут используем не примитивные типы в полях double, а используем классы обёртки Double. Ни объяснение почему мы будем работать с обёртками.

Если примитивное:
private double value = 0.0; Так как оно примитивное если мы ничего не выставим, то выставится по умолчанию значение 0.0. Мы можем подумать что это температура что пришла от Sensor, пришла температура 0 и эту температуру положим в БД что не очень хорошо.

Класс обёртка:
private Double value = null; Здесь уже может быть null, и если придёт null от JSON то-есть Sensor не отправит значение value. То в этом поле будет лежать null и здесь уже сработает аннотация @NotNull нам не позволит сохранить такое измерение температуры без значения.
*/
@Entity
@Table(name = "Measurement")
public class Measurement {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "value")
    @NotNull
    @Min(-100)
    @Max(100)
    private Double value;

    @Column(name = "raining")
    @NotNull
    private Boolean isRaining;

    @Column(name = "measurement_date_time")
    @NotNull
    private LocalDateTime measurementDateTime;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "sensor", referencedColumnName = "name")
    private Sensor sensor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    // Jackson смотрит на название геттера, отсекает is и оставляет название поля
    public Boolean isRaining() {
        return isRaining;
    }

    public void setRaining(Boolean isRaining) {
        this.isRaining = isRaining;
    }

    public LocalDateTime getMeasurementDateTime() {
        return measurementDateTime;
    }

    public void setMeasurementDateTime(LocalDateTime measurementDateTime) {
        this.measurementDateTime = measurementDateTime;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
