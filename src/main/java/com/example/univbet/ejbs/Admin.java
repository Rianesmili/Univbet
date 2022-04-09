package com.example.univbet.ejbs;

import com.example.univbet.dtos.AdminDto;

import javax.ejb.Local;
import java.util.List;
@Local
public interface Admin {

    List<AdminDto> getEquipes();

    void insertEquipe(String equipe);
}

