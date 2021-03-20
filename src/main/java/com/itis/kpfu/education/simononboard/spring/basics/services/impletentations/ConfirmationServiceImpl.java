package com.itis.kpfu.education.simononboard.spring.basics.services.impletentations;

import com.itis.kpfu.education.simononboard.spring.basics.models.User;
import com.itis.kpfu.education.simononboard.spring.basics.repositories.UsersRepository;
import com.itis.kpfu.education.simononboard.spring.basics.services.interfaces.ConfirmationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConfirmationServiceImpl implements ConfirmationService {
    private final UsersRepository usersRepository;
    //@Transactional
    @Override
    public boolean confirmByCode(String code) {
        Optional<User> userCandidate = usersRepository.findByCurrentConfirmationCode(code);
        if (userCandidate.isPresent()) {
            User user = userCandidate.get();
            if(user.isActive()) throw new IllegalArgumentException("User is already activated");
            user.setState(User.State.ACTIVE);
            usersRepository.save(user);
        }
        return userCandidate.isPresent();
    }
}
