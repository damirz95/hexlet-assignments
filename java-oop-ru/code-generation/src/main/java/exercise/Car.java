package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Objects;

// BEGIN
@AllArgsConstructor
@Getter
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public String serialize() throws JsonProcessingException {
        ObjectMapper object = new ObjectMapper();
        return object.writeValueAsString(this);
    }
    public static Car unserialize(String json) throws IOException {
        ObjectMapper object = new ObjectMapper();
        return object.readValue(json,Car.class);
    }
    // END
}
