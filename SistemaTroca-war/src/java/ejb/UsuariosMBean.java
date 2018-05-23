/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author giordani
 */
@Named(value = "usuariosMBean")
@RequestScoped
public class UsuariosMBean implements Serializable {

    @EJB
    private UsuariosFachada usuariosFachada;
    
    private static Usuarios usuario;
    
    private String email;
    private String senha;

    /**
     * Creates a new instance of UsuariosMBean
     */
    public UsuariosMBean() {
    }
    
    public String login() {
        usuario = usuariosFachada.login(this.email, this.senha);
        if (usuario == null) {
            return null;
        } else {
            return "/usuario";
        }
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
    
    
    
}
