package com.berryjelly.user_service.controller;

import com.berryjelly.user_service.mapper.UserApiModelMapper;
import com.berryjelly.user_service.model.apimodel.UserRequest;
import com.berryjelly.user_service.model.businessobject.UserBo;
import com.berryjelly.user_service.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final UserApiModelMapper userApiModelMapper;

    public UserController(UserService userService, UserApiModelMapper userApiModelMapper) {
        this.userService = userService;
        this.userApiModelMapper = userApiModelMapper;
    }

    @GetMapping("/{resourceId}")
    public UserBo getUser(@PathVariable String resourceId){
        return null;
    }

    @PostMapping
    public UserBo saveUser(@RequestBody UserRequest request){
        return userService.saveUser(userApiModelMapper.mapApiModelToBo(request));
    }
}
