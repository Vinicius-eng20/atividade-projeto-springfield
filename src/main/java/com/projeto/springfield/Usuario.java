package com.projeto.springfield;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CAD_USUARIO")
public class Usuario {
    
    @Id
    private int id;  

    @Column(unique = true)
    private String username;  

    private String senha;  
    
    private boolean bloqueado = false;  // Indica se o usuário está bloqueado
    private int tentativasLogin = 0;  
    private LocalDate ultimoLogin = null;  
    private boolean senhaExpirada = false;  // Indica se a senha expirou
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public boolean isBloqueado() {
        return bloqueado;
    }
    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }
    public int getTentativasLogin() {
        return tentativasLogin;
    }
    public void setTentativasLogin(int tentativasLogin) {
        this.tentativasLogin = tentativasLogin;
    }
    public LocalDate getUltimoLogin() {
        return ultimoLogin;
    }
    public void setUltimoLogin(LocalDate ultimoLogin) {
        this.ultimoLogin = ultimoLogin;
    }
    public boolean isSenhaExpirada() {
        return senhaExpirada;
    }
    public void setSenhaExpirada(boolean senhaExpirada) {
        this.senhaExpirada = senhaExpirada;
    }
}
