package com.example.univbet.ejbs;

import com.example.univbet.dtos.UserDto;

import javax.ejb.Local;
import java.util.List;
@Local
public interface User {
    List<UserDto> getUsers();

    void doInsert(String login, String nom, String prenom, String password);
}
