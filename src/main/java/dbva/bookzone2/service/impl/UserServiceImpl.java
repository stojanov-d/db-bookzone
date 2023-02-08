package dbva.bookzone2.service.impl;

import dbva.bookzone2.model.Type;
import dbva.bookzone2.model.User;
import dbva.bookzone2.model.exceptions.InvalidTypeIdException;
import dbva.bookzone2.repository.TypeRepository;
import dbva.bookzone2.repository.UserRepository;
import dbva.bookzone2.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final TypeRepository typeRepository;

    public UserServiceImpl(UserRepository userRepository, TypeRepository typeRepository) {
        this.userRepository = userRepository;
        this.typeRepository = typeRepository;
    }


    @Override
    public User register(String name, String password, String surname, String phoneNumber, LocalDate joinedDate, Integer type) {
        Type userType = this.typeRepository.findById(type).orElseThrow(InvalidTypeIdException::new);
        User user = new User(name,surname,phoneNumber,joinedDate,password,userType);
        return this.userRepository.save(user);
    }


}
