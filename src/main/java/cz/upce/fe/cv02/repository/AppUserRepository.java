package cz.upce.fe.cv02.repository;

import cz.upce.fe.cv02.domain.AppUser;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserRepository extends PagingAndSortingRepository<AppUser, Long> {
    List<AppUser> findAllByActiveEquals(boolean active);
}
