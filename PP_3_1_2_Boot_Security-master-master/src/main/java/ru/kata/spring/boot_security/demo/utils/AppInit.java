package ru.kata.spring.boot_security.demo.utils;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.RoleService;
import ru.kata.spring.boot_security.demo.services.UserService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class AppInit implements CommandLineRunner {
    private UserService userService;
    private RoleService roleService;

    public AppInit(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @Override
    public void run(String... args) throws Exception {
        Role userRole = new Role("ROLE_USER");
        Role adminRole = new Role("ROLE_ADMIN");

        roleService.save(userRole);
        roleService.save(adminRole);

        Set<Role> roles = new HashSet<>();
        Set<Role> rolesAdm = new HashSet<>();

        roles.add(userRole);
        rolesAdm.add(adminRole);

        User user = new User("user", 20, "user1",  roles);
        User admin = new User("admin", 30, "admin1", rolesAdm);

        userService.save(user);
        userService.save(admin);
    }
}
