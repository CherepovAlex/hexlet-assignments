package exercise.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

// BEGIN
@Getter
@Setter
public class GuestCreateDTO {
    @NotBlank(message = "Имя не может быть пустым")
    private String name;

    @Email(message = "Email должен быть в правильном формате")
    private String email;

    @Pattern(regexp = "^\\+\\d{11,13}$",
            message = "Телефон должен начинаться с + и содержать 11-13 цифр")
    private String phoneNumber;

    @Pattern(regexp = "^\\d{4}$",
            message = "Клубная карта должна содержать ровно 4 цифры")
    private String clubCard;

    @FutureOrPresent(message = "Срок действия карты не должен истечь")
    private LocalDate cardValidUntil;

}
// END
