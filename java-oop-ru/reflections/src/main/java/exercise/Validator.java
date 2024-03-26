package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class Validator {
    public static List<String> validate(Object object) {
        List<String> result = new ArrayList<>();
        Class<?> aClass = object.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for(var field: fields) {
            if(field.isAnnotationPresent(NotNull.class)) {
                try {
                    field.setAccessible(true);
                    var value = field.get(object);
                    if (value == null) {
                        result.add(field.getName());
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        return result;
        //java.lang.String
    }
}
// END
