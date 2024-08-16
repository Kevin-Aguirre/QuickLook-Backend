package com.example.QuickLook.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
// this is a spring bean, basically referring to a class that MUST be isntantiated, dependecny injection just means
// i am declaring hey i qwill NEED this object and the spring framework will take care of it so you have an instance
// of this class when needed
import java.util.Optional;


// @service and @component do teh same thing here but service is better for readability, it is declaring her this is a service class
@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addNewUser(User user) {
        Optional<User> userByEmail = userRepository
                .findUserByEmail(user.getEmail());

        if (userByEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }

        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        boolean exists = userRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("user not found");
        }
        userRepository.deleteById(id);
    }

    public User getUserById(Long id) {
        Optional<User> userById = userRepository.findById(id);
        if (!userById.isPresent()) {
            throw new IllegalStateException("user not found");
        }
        return userById.get();
    }
}
