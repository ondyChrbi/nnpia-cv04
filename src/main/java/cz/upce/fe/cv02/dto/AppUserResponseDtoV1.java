package cz.upce.fe.cv02.dto;

import cz.upce.fe.cv02.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUserResponseDtoV1 {
    private Long id;

    private String username;

    private String password;

    private Boolean active;

    private LocalDateTime creationDate;

    private LocalDateTime updateDate;
    
    private List<Role> roles = Collections.emptyList();

    private List<TaskDtoV1> tasks = Collections.emptyList();

    public AppUserResponseDtoV1(Long id, String username, String password, Boolean active, LocalDateTime creationDate, LocalDateTime updateDate, List<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.active = active;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.roles = roles;
    }
}
