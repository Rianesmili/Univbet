package com.example.univbet.ejbs.impl;

import com.example.univbet.dtos.AdminDto;
import com.example.univbet.dtos.UserDto;
import com.example.univbet.ejbs.Admin;
import com.example.univbet.entities.EquipeEntity;
import com.example.univbet.entities.UserEntity;
import com.example.univbet.listeners.ApplicationListener;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
@Stateless
public class AdminBean implements Admin {
    @Override
    public List<AdminDto> getEquipes() {
        EntityManagerFactory emf = ApplicationListener.getEmf();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createNamedQuery("findEquipes", EquipeEntity.class);
        List<EquipeEntity> equipes = query.getResultList();

        List<AdminDto> toReturn = new ArrayList<>();
        equipes.forEach(m -> {
            AdminDto adminDto = new AdminDto();
            adminDto.setEquipe(m.getEquipe());
            toReturn.add(adminDto);
        });
        return toReturn;
    }

    @Override
    public void insertEquipe(String equipe) {
        EquipeEntity e = new EquipeEntity();
        e.setEquipe(equipe);
        EntityManagerFactory emf = ApplicationListener.getEmf();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();

    }
}
