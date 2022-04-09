package com.example.univbet.ejbs.impl;

import com.example.univbet.dtos.UserDto;
import com.example.univbet.ejbs.User;
import com.example.univbet.entities.UserEntity;
import com.example.univbet.listeners.ApplicationListener;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
@Stateless
public class UserBean implements User  {
    @Override
    public List<UserDto> getUsers() {
        EntityManagerFactory emf = ApplicationListener.getEmf();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createNamedQuery("findUsers", UserEntity.class);
        List<UserEntity> users = query.getResultList();

        List<UserDto> toReturn = new ArrayList<>();
        users.forEach(m -> {
            UserDto userDto = new UserDto();
            userDto.setLogin(m.getLogin());
            userDto.setNom(m.getNom());
            userDto.setPrenom(m.getPrenom());
            userDto.setPassword(m.getPassword());
            userDto.setRole(m.getRole());
            toReturn.add(userDto);
        });
        return toReturn;
    }

    @Override
    public void doInsert(String login, String prenom, String nom,String password) {
        UserEntity user = new UserEntity();
        user.setLogin(login);
        user.setNom(nom);
        user.setPrenom(prenom);
        user.setPassword(password);
        user.setRole("User");
        EntityManagerFactory emf = ApplicationListener.getEmf();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }
}
