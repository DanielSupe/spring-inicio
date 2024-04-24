package com.main.crudProgramacion.services.impl;

import com.main.crudProgramacion.dao.UserDAO;
import com.main.crudProgramacion.dto.UserDTO;
import com.main.crudProgramacion.entity.UsersEntity;
import com.main.crudProgramacion.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        UsersEntity usersEntity = UsersEntity.builder()
                .idUser(userDTO.getIdUser())
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .birthdate(userDTO.getBirthdate())
                .build();
        UsersEntity savedUser = userDAO.save(usersEntity);
        return UserDTO.builder()
                .idUser(savedUser.getIdUser())
                .name(savedUser.getName())
                .email(savedUser.getEmail())
                .birthdate(savedUser.getBirthdate())
                .build();
    }

    @Override
    public List<UserDTO> getUsers() {
        List<UsersEntity> usersEntities = userDAO.findAll();
        return  usersEntities.stream()
                .map(usersEntity -> UserDTO.builder()
                        .idUser(usersEntity.getIdUser())
                        .name(usersEntity.getName())
                        .email(usersEntity.getEmail())
                        .birthdate(usersEntity.getBirthdate())
                        .build())
                .toList();
    }

    @Override
    public UserDTO getUserById(Integer id) {
        Optional <UsersEntity> usersEntity = userDAO.findById(id);
        return  UserDTO.builder()
                .idUser(usersEntity.get().getIdUser())
                .name(usersEntity.get().getName())
                .email(usersEntity.get().getEmail())
                .birthdate(usersEntity.get().getBirthdate())
                .build();
    }

    @Override
    public void deleteUser(Integer id) {
        userDAO.deleteById(id);
    }

    @Override
    public UserDTO getUserByName(String name) {

        UsersEntity usersEntity = userDAO.findByName(name);
        return  UserDTO.builder()
                .idUser(usersEntity.getIdUser())
                .name(usersEntity.getName())
                .email(usersEntity.getEmail())
                .birthdate(usersEntity.getBirthdate())
                .build();
    }

}
