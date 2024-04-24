package com.main.crudProgramacion.dao;

import com.main.crudProgramacion.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDAO extends JpaRepository<UsersEntity,Integer> {
    @Query(value = "SELECT u FROM UserEntity u WHERE u.name = ?1")//HSQL METODO PARA INTERACTUAR CON LA DB
    UsersEntity findByName(String name);
    @Query(value = "select * from users where name = ?1",nativeQuery = true)
    List<Object[]> findByUserName(String name);
}
