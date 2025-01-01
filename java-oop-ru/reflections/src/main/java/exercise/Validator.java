package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {
    public static List<String> validate(Object obj) {
        List<String> notValidFields = new ArrayList<>();
        try {
            for (Field field : obj.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(NotNull.class)) {
                    field.setAccessible(true);
                    Object value = field.get(obj);
                    if (value == null) {
                        notValidFields.add(field.getName());
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return notValidFields;
    }

    public static Map<String, List<String>> advancedValidate(Object obj) {
        Map<String, List<String>> notValidFields3 = new HashMap<>();
        try {
            for (Field field : obj.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(NotNull.class)
                        || field.isAnnotationPresent(MinLength.class)) {
                    field.setAccessible(true);
                    Object value = field.get(obj);
                    List<String> list = new ArrayList<>();
                    if (value == null) {
                        list.add("can not be null");
                    }
                    if (!(value == null) && value.toString().length() < 4) {
                        list.add("length less than 4");
                    }
                    if (!list.isEmpty()) {
                        notValidFields3.put(field.getName(), list);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return notValidFields3;
    }

}
// END
