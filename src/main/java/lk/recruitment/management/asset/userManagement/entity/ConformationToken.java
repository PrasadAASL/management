package lk.recruitment.management.asset.userManagement.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ConformationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String token;

    @Column(unique = true, nullable = false)
    private String email;

    private LocalDateTime createDate;

    private LocalDateTime endDate;

    public ConformationToken(String email) {
        this.email = email;
        this.token = UUID.randomUUID().toString();
        this.createDate = LocalDateTime.now();
        this.endDate = createDate.plusDays(1);
    }
}
