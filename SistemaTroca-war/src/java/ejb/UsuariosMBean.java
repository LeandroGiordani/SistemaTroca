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
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
/**
 *
 * @author giordani
 */
@ManagedBean
@Named(value = "usuariosMBean")
@SessionScoped
public class UsuariosMBean implements Serializable {

    @EJB
    private UsuariosFachada usuariosFachada;
    
    private static Usuarios usuario;
    
    private String email;
    private String senha;
    
    private String[] contato;

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
            return "/main";
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
    
    public String contata(int idusuario) {
        Usuarios contatoUsuario = usuariosFachada.contata(idusuario);
        this.contato = new String[]{contatoUsuario.getNome(), 
            contatoUsuario.getTelefone(), contatoUsuario.getEmail()};
        return "/contato";
    }
    
}
