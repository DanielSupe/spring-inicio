package com.main.crudProgramacion.services.impl;

import com.main.crudProgramacion.dao.UserDAO;
import com.main.crudProgramacion.dto.UserDTO;
import com.main.crudProgramacion.entity.UsersEntity;
import com.main.crudProgramacion.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;
    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        UserEntity userEntity = UserEntity.builder()
                .idUser(userDTO.getIdUser())
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .birthdate(userDTO.getBirthdate())
                .build();

        UsersEntity savedUser=userDAO.save(userEntity);
        return UserDTO.builder()
                .idUser(userDTO.getIdUser())
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .birthdate(userDTO.getBirthdate())
                .build();
    }

    @Override
    public List<UserDTO> getUsers() {
        List<UsersEntity> userEntities = userDAO.findAll();
        return (List<UserDTO>) userEntities.stream()
                .map(userEntity -> UserDTO.builder()
                        .idUser(userEntity.getIdUser())
                        .name(userEntity.getName())
                        .email(userEntity.getEmail())
                        .birthdate(userEntity.getBirthdate())
                        .build());

    }
}
