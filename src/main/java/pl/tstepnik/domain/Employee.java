package pl.tstepnik.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import pl.tstepnik.reader.deserializer.FlexibleFloatDeserializer;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private Long id;
    private String name;
    private String surname;
    private String job;

    @JsonDeserialize(using = FlexibleFloatDeserializer.class)
    private double salary;
}

