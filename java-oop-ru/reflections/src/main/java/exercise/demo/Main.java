package exercise.demo;

import exercise.Address;
import exercise.Validator;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Address address = new Address(null, "London", "1-st street", "7", "2");
        List<String> notValidFields = Validator.validate(address);
        System.out.println(notValidFields); // => [country]

        Address address2 = new Address("England", null, null, "7", "2");
        List<String> notValidFields2 = Validator.validate(address2);
        System.out.println(notValidFields2); // => [city, street]

        Address address3 = new Address("USA", "Texas", null, "7005", "2005");
        Map<String, List<String>> notValidFields3 = Validator.advancedValidate(address3);
        System.out.println(notValidFields3); // =>  {country=[length less than 4], street=[can not be null]}

    }

}
