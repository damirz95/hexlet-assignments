package exercise;

import exercise.model.Address;
import exercise.annotation.Inspect;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        var address = new Address("London", 12345678);

        // BEGIN
        for(Method method: Address.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Inspect.class)) {
                try {
                    method.invoke(address);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String methodName = method.getName();
                String methodType = method.getReturnType().getSimpleName();
                System.out.println("Method " + methodName + " returns a value of type " + methodType);
            }
        }
        // END
    }
}
