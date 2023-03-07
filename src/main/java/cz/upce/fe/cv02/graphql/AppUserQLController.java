package cz.upce.fe.cv02.graphql;

import cz.upce.fe.cv02.dto.AppUserInputQLDto;
import cz.upce.fe.cv02.dto.AppUserResponseDtoV1;
import cz.upce.fe.cv02.service.AppUserService;
import cz.upce.fe.cv02.service.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class AppUserQLController {
    private final AppUserService appUserService;

    @QueryMapping
    public AppUserResponseDtoV1 appUser(@Argument Long id) throws ResourceNotFoundException {
        return appUserService.findById(id).toDto();
    }

    @MutationMapping
    public AppUserResponseDtoV1 createAppUser(@Argument AppUserInputQLDto appUser) {
        return appUserService.create(appUser.toEntity())
                .toDto();
    }
}
