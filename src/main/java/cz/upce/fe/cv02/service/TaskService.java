package cz.upce.fe.cv02.service;

import cz.upce.fe.cv02.domain.Task;
import cz.upce.fe.cv02.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public List<Task> findAllByAppUserId(final Long appUserId) {
        return taskRepository.findAllByAuthorId(appUserId);
    }
}
