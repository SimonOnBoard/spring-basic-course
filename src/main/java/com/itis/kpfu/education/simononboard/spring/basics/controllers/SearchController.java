package com.itis.kpfu.education.simononboard.spring.basics.controllers;

import com.itis.kpfu.education.simononboard.spring.basics.dto.SearchForm;
import com.itis.kpfu.education.simononboard.spring.basics.dto.UserDto;
import com.itis.kpfu.education.simononboard.spring.basics.security.details.UserDetailsImpl;
import com.itis.kpfu.education.simononboard.spring.basics.services.interfaces.UserSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {
    private final UserSearchService userSearchService;

    // TODO: 20.03.2021 показать возможности Spring exLang
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Page<UserDto> getUsersBySearchForm(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody SearchForm searchForm) {
        // TODO: 20.03.2021 c userDetails придумайте здесь что делать самостоятельно - например уменьшать количество запросов на поиск в час/минуту
        return userSearchService.findAllByRequestBody(searchForm);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String getSearchPage() {
        return "search";
    }
}
