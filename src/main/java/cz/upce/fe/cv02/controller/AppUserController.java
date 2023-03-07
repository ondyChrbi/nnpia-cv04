package cz.upce.fe.cv02.controller;

import cz.upce.fe.cv02.domain.AppUser;
import cz.upce.fe.cv02.dto.AppUserResponseDtoV1;
import cz.upce.fe.cv02.dto.AppUserResponseInputDtoV1;
import cz.upce.fe.cv02.service.AppUserService;
import cz.upce.fe.cv02.service.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/app-user")
@AllArgsConstructor
public class AppUserController {
    private final AppUserService appUserService;

    @GetMapping("")
    public ResponseEntity<List<AppUserResponseDtoV1>> findAll() {
        var result = appUserService.findAllByActiveEquals();

        return ResponseEntity.ok(result
                .stream()
                .map(AppUser::toDto)
                .collect(Collectors.toList())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable final Long id) throws ResourceNotFoundException {
        var result = appUserService.findById(id);

        return ResponseEntity.ok(result.toDto());
    }

    @PostMapping("")
    public ResponseEntity<AppUserResponseDtoV1> create(@RequestBody @Validated final AppUserResponseInputDtoV1 input) {
        var result = appUserService.create(toEntity(input));

        return ResponseEntity.ok(result.toDto());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppUserResponseDtoV1> update(@PathVariable final Long id, @RequestBody final AppUserResponseInputDtoV1 input) {
        var result = appUserService.update(toEntity(id, input));

        return ResponseEntity.ok(result.toDto());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable final Long id) {
        appUserService.delete(id);

        return ResponseEntity.noContent().build();
    }

    private static AppUser toEntity(final AppUserResponseInputDtoV1 input) {
        return new AppUser(
                input.getUsername(),
                input.getPassword(),
                input.getActive(),
                input.getCreationDate(),
                input.getUpdateDate()
        );
    }

    private static AppUser toEntity(final Long id, final AppUserResponseInputDtoV1 input) {
        return new AppUser(
                id,
                input.getUsername(),
                input.getPassword(),
                input.getActive(),
                input.getCreationDate(),
                input.getUpdateDate()
        );
    }
}
