package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Map;



class ValidationTest {

    @Test
    void testValidate() {
        Address address1 = new Address("Russia", "Ufa", "Lenina", "54", null);
        List<String> result1 = Validator.validate(address1);
        List<String> expected1 = List.of();
        assertThat(result1).isEqualTo(expected1);

        Address address2 = new Address(null, "London", "1-st street", "5", "1");
        List<String> result2 = Validator.validate(address2);
        List<String> expected2 = List.of("country");
        assertThat(result2).isEqualTo(expected2);

        Address address3 = new Address("USA", null, null, null, "1");
        List<String> result3 = Validator.validate(address3);
        List<String> expected3 = List.of("city", "street", "houseNumber");
        assertThat(result3).isEqualTo(expected3);
    }

    // BEGIN
    @Test
    void testAdvancedValidate() {
        Address address4 = new Address("Russia", "Ufa", "Lenina", "1005", null);
        Map<String, List<String>> result4 = Validator.advancedValidate(address4);
        Map<String, List<String>> expected4 = Map.of("city", List.of("length less than 4"), "flatNumber", List.of("can not be null"));
        assertThat(result4).isEqualTo(expected4);

        Address address5 = new Address(null, "London", "1-st street", "5005", "1005");
        Map<String, List<String>> result5 = Validator.advancedValidate(address5);
        Map<String, List<String>> expected5 = Map.of("country", List.of("can not be null"));
        assertThat(result5).isEqualTo(expected5);

        Address address6 = new Address("USA", null, null, null, "1005");
        Map<String, List<String>> result6 = Validator.advancedValidate(address6);
        Map<String, List<String>> expected6 = Map.of("country", List.of("length less than 4"),
                "city", List.of("can not be null"),
                "street", List.of("can not be null"),
                "houseNumber", List.of("can not be null"));
        assertThat(result6).isEqualTo(expected6);
    }
    // END
}
