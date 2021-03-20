package com.itis.kpfu.education.simononboard.spring.basics.services.impletentations;

import com.itis.kpfu.education.simononboard.spring.basics.dto.SearchForm;
import com.itis.kpfu.education.simononboard.spring.basics.dto.UserDto;
import com.itis.kpfu.education.simononboard.spring.basics.models.User;
import com.itis.kpfu.education.simononboard.spring.basics.repositories.UsersRepository;
import com.itis.kpfu.education.simononboard.spring.basics.services.interfaces.UserSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSearchServiceImpl implements UserSearchService {
    private final UsersRepository usersRepository;

    @Override
    public Page<UserDto> findAllByRequestBody(SearchForm searchForm) {
        PageRequest pageRequest = PageRequest.of(searchForm.getPage() - 1, searchForm.getSize(), Sort.unsorted());
        Page<User> userList = usersRepository.findAllByUsernameIgnoreCase(searchForm.getName(), pageRequest);
        return userList.map(UserDto::fromUser);
    }
}
