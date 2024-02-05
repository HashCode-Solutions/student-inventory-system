package com.example.student_managment_system.service.impl;

import com.example.student_managment_system.dto.RolesDto;
import com.example.student_managment_system.dto.UserDto;
import com.example.student_managment_system.entity.Roles;
import com.example.student_managment_system.entity.Users;
import com.example.student_managment_system.repository.UserRepository;
import com.example.student_managment_system.service.RegisterService;
import com.example.student_managment_system.utils.AESUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private static final String SECRET_KEY = "secrete";
    private final UserRepository userRepository;

    @Override
    public UserDto registerUser(UserDto userDto) {

        Users users = new Users();
        users.setFirstName(userDto.getFirstName());
        users.setLastName(userDto.getLastName());
        users.setUserName(userDto.getUserName());
        users.setPassword(AESUtils.encrypt(userDto.getPassword(), SECRET_KEY));
        users.setRole(new Roles(userDto.getRolesDto().getId(),userDto.getRolesDto().getRoleName(),
                userDto.getRolesDto().getRoleValue()));
        users.setCreateTime(new Date());

        Users saveUser = userRepository.save(users);

        return UserDto.builder()
                .userId(saveUser.getUserId())
                .firstName(saveUser.getFirstName())
                .lastName(saveUser.getLastName())
                .userName(saveUser.getUserName())
                .password(AESUtils.decrypt(saveUser.getPassword(),SECRET_KEY))
                .rolesDto(new RolesDto(saveUser.getRole().getId(), saveUser.getRole().getRoleName(),
                        saveUser.getRole().getRoleValue()))
                .build();
    }

}
