package exercise;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;

// BEGIN
public class App {

    public static void save(Path path, Car car) throws IOException {
        Files.write(path, car.serialize().getBytes(StandardCharsets.UTF_8));
        System.out.println("записал");
    }

    public static Car extract(Path path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(Files.readAllBytes(path), Car.class);
    }

    public static void main(String[] args) throws IOException {
        User owner = new User(1, "Ivan", "P", 25);
        // Вызываем автоматически сгенерированный геттер
        System.out.println(owner.getFirstName()); // "Ivan"

        Path path1 = Paths.get("tmp/file1.json").toAbsolutePath().normalize();
        System.out.println(path1);
        Car car1 = new Car(1, "audi", "q3", "black", owner);
        App.save(path1, car1); // Сохраняет представление объекта в файл

        Path path2 = Paths.get("tmp/file2.json").toAbsolutePath().normalize();
        Car car2 = App.extract(path2); // Возвращает инстанс класса Car
        System.out.println(car2.getModel()); // "passat"


        Car car = new Car(1, "bmv", "x5", "black", owner);
        String jsonRepresentation = car.serialize();
        System.out.println(jsonRepresentation); // =>
          /*
          {
            "id":1,
            "brand":"bmv",
            "model":"x5",
            "color":"black",
            "owner":{
                "id":1,
                "firstName":"Ivan",
                "lastName":"P",
                "age":25
            }
          }
          */
//      String jsonRepresentation = // получаем JSON представление объекта
        Car instance = Car.deserialize(jsonRepresentation);
        System.out.println(instance.getBrand()); // "bmv"
        System.out.println(instance.getModel()); // "x5"



    }
}
// END
