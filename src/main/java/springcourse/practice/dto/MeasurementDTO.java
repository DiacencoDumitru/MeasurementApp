package springcourse.practice.dto;

import springcourse.practice.models.Sensor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class MeasurementDTO {
    @NotNull
    @Min(-100)
    @Max(100)
    private Double value;

    @NotNull
    private Boolean isRaining;

    @NotNull
    private Sensor sensor;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Boolean getRaining() {
        return isRaining;
    }

    public void setRaining(Boolean isRaining) {
        this.isRaining = isRaining;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
