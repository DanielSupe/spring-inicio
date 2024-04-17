package com.main.crudProgramacion.dao;

import com.main.crudProgramacion.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<UsersEntity,Integer> {
}
