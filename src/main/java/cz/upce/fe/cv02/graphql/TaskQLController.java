package cz.upce.fe.cv02.graphql;

import cz.upce.fe.cv02.domain.Task;
import cz.upce.fe.cv02.dto.AppUserResponseDtoV1;
import cz.upce.fe.cv02.dto.TaskDtoV1;
import cz.upce.fe.cv02.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class TaskQLController {
    private final TaskService taskService;

    @SchemaMapping(typeName = "AppUser")
    public List<TaskDtoV1> tasks(final AppUserResponseDtoV1 appUser) {
        return taskService.findAllByAppUserId(appUser.getId())
                .stream()
                .map(Task::toDto)
                .collect(Collectors.toList());
    }
}
