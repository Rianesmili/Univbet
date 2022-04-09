package com.example.univbet.dtos;

import com.example.univbet.ejbs.Admin;
import com.example.univbet.ejbs.User;
import com.example.univbet.enums.Equipes;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("admin")
@SessionScoped
public class AdminDto implements Serializable {
    @EJB
    private Admin adminBean;
    String equipe;
    Equipes equipe1,equipe2;
    // String ligue;
    String match;
    String winner;
    String loser ;


    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    public Equipes getEquipe1() {
        return equipe1;
    }

    public void setEquipe1(Equipes equipe1) {
        this.equipe1 = equipe1;
    }

    public Equipes getEquipe2() {
        return equipe2;
    }

    public void setEquipe2(Equipes equipe2) {
        this.equipe2 = equipe2;
    }

   /* public String getLigue() {
        return ligue;
    }

    public void setLigue(String ligue) {
        this.ligue = ligue;
    }*/

    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        this.match = match;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getLoser() {
        return loser;
    }

    public void setLoser(String loser) {
        this.loser = loser;
    }


    public List<AdminDto> getEquipes() {
        return this.adminBean.getEquipes();
    }

    public String insertEquipe(){
        this.adminBean.insertEquipe(this.equipe);
        return "test";
    }


    public void insertMatch(){

    }
    public void insertResult(){

    }

}