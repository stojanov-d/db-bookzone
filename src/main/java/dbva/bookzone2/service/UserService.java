package dbva.bookzone2.service;

import dbva.bookzone2.model.User;

import java.time.LocalDate;

public interface UserService {

    User register(String name, String password, String surname, String phoneNumber, LocalDate joinedDate, Integer type);

    User findByName(String username);

}
