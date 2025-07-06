package exercise.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;

import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.validation.constraints.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "guests")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Guest {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    // BEGIN
    @NotBlank(message = "Имя не может быть пустым")
    private String name;

    @Email(message = "Email должен быть в правильном формате")
    private String email;

    @Pattern(regexp = "^\\+\\d+$",
            message = "Телефон должен начинаться с +")
    @Size(min = 11, max = 13,
            message = "Телефон должен содержать 11-13 символов")
    private String phoneNumber;

    @Pattern(regexp = "\\d{4}$",
            message = "Клубная карта должна содержать 4 цифры")
    private String clubCard;

    @FutureOrPresent(message = "Срок действия карты не должен истечь")
    private LocalDate cardValidUntil;
    // END

    @CreatedDate
    private LocalDate createdAt;
}
