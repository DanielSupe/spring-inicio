package com.main.crudProgramacion.services;

import com.main.crudProgramacion.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO saveUser(UserDTO UserDTO);
    List<UserDTO> gerUser();
}
