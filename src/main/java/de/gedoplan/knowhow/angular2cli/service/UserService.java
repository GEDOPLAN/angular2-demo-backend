package de.gedoplan.knowhow.angular2cli.service;

import de.gedoplan.knowhow.angular2cli.model.User;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;


@Stateless
public class UserService implements Serializable {

    @Inject
    private HttpServletRequest httpRequest;

    private static final String[] availableRoles = {"admin", "customer"};

    public User loadUser() {
        User user = new User();
        user.setLogin(httpRequest.getUserPrincipal().getName());

        List<String> roles = Arrays.stream(availableRoles).filter(role -> httpRequest.isUserInRole(role)).collect(Collectors.toList());
        user.setRoles(roles);

        if (user.getRoles().contains("customer")) {
            user.setCustomerID(user.getLogin());
        }

        return user;
    }
}
