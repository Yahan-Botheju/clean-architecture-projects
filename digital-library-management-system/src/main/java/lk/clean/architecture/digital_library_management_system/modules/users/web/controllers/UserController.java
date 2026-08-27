package lk.clean.architecture.digital_library_management_system.modules.users.web.controllers;

import lk.clean.architecture.digital_library_management_system.modules.users.usecase.UserUseCase;
import lk.clean.architecture.digital_library_management_system.modules.users.web.webMappers.UserWebMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    //inject required dependencies
    private final UserUseCase userUseCase;
    private final UserWebMapper userWebMapper;

    public UserController(UserUseCase userUseCase, UserWebMapper userWebMapper) {
        this.userUseCase = userUseCase;
        this.userWebMapper = userWebMapper;
    }
}
