package cz.upce.fe.cv02.repository;

import cz.upce.fe.cv02.domain.Task;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {
    List<Task> findAllByAuthorId(final Long id);
}
