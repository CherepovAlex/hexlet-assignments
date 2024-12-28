package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {

    public static void swapKeyValue (KeyValueStorage storage1) {
        Map<String, String> map = storage1.toMap();
        var keys = map.keySet().toArray();
        for(var key : keys){
            var value = map.get(key);
            storage1.unset((String) key);
            storage1.set(value, (String) key);
        }
    }

    public static void main(String[] args) {
        KeyValueStorage storage = new InMemoryKV(Map.of("key", "10"));

        // Получение значения по ключу
        storage.get("key", "default"); // "10"
        storage.get("unknown", "default"); // "default"

        // Установка нового значения
        storage.set("key2", "value2");
        storage.get("key2", "default"); // "value2"

        // Удаление ключа
        storage.unset("key2");
        storage.get("key2", "default"); // "default"

        // Получение всех данных из базы
        Map<String, String> data = storage.toMap();
        System.out.println(data); // => {key=10};

        KeyValueStorage storage1 = new InMemoryKV(Map.of("key", "value", "key2", "value2"));
        App.swapKeyValue(storage1);
        storage1.get("key", "default"); // "default"
        storage1.get("value", "default"); // "key"

        System.out.println(storage1.toMap()); // => {value=key, value2=key2}

        KeyValueStorage storage2 = new FileKV("src/test/resources/file", Map.of("key", "value"));
        // Получение значения по ключу
        System.out.println(storage2.get("key", "default")); // "value"
    }
}
// END
