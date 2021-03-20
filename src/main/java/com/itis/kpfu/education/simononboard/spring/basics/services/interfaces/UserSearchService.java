package com.itis.kpfu.education.simononboard.spring.basics.services.interfaces;

import com.itis.kpfu.education.simononboard.spring.basics.dto.SearchForm;
import com.itis.kpfu.education.simononboard.spring.basics.dto.UserDto;
import org.springframework.data.domain.Page;

public interface UserSearchService {
    Page<UserDto> findAllByRequestBody(SearchForm searchForm);
}
