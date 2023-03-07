package cz.upce.fe.cv02.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDtoV1 {
    private Long id;

    private String title;

    private String description;

    private LocalDateTime creationDate;

    private LocalDateTime updateDate;
}
