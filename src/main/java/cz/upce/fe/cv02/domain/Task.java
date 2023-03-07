package cz.upce.fe.cv02.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cz.upce.fe.cv02.dto.TaskDtoV1;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Task {
    @Id
    private Long id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private LocalDateTime creationDate;

    @Column
    private LocalDateTime updateDate;

    @ManyToOne
    @JoinColumn(name="author_id", nullable=false)
    @ToString.Exclude
    @JsonIgnore
    private AppUser author;

    public TaskDtoV1 toDto() {
        return new TaskDtoV1(
            getId(),
            getTitle(),
            getDescription(),
            getCreationDate(),
            getUpdateDate()
        );
    }
}
