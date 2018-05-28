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
    
    private int id;
    private String nome;
    private String telefone;    
    private String email;
    private String senha;
    
    private String emailLogin;
    private String senhaLogin;
    
    private String contatoNome;
    private String contatoTelefone;
    private String contatoEmail;

    /**
     * Creates a new instance of UsuariosMBean
     */
    public UsuariosMBean() {
    }
    
    public String login() {
        usuario = usuariosFachada.login(this.emailLogin, this.senhaLogin);
        if (usuario == null) {
            return null;
        } else {
            this.id = usuario.getId();
            return "/main";
        }
    }
    
    public String logout() {
        this.emailLogin = null;
        this.senhaLogin = null;
        return "/logout";
    }
    
    public int getIdLogin() {
        return this.id;
    }

    public void setEmailLogin(String email) {
        this.emailLogin = email;
    }
    
    public String getEmailLogin() {
        return emailLogin;
    }

    public void setSenhaLogin(String senha) {
        this.senhaLogin = senha;
    }

    public String getSenhaLogin() {
        return senhaLogin;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getEmail() {
        return email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setContatoNome(String nome) {
        this.contatoNome = nome;
    }

    public String getContatoNome() {
        return contatoNome;
    }
    
    public void setContatoTelefone(String telefone) {
        this.contatoTelefone = telefone;
    }

    public String getContatoTelefone() {
        return contatoTelefone;
    }
    
    public void setContatoEmail(String email) {
        this.contatoEmail = email;
    }

    public String getContatoEmail() {
        return contatoEmail;
    }
    
    public String contata(int idusuario) {
        Usuarios contatoUsuario = usuariosFachada.contata(idusuario);
        this.contatoNome = contatoUsuario.getNome();
        this.contatoTelefone = contatoUsuario.getTelefone();
        this.contatoEmail = contatoUsuario.getEmail();
        return "/contato";
    }
    
    public String cadastraUsuario() {
        int id = usuariosFachada.getMaxId() + 1;
        Usuarios cadastraUsuario = new Usuarios(id);
        String nomeCadastro = this.getNome();
        String telefoneCadastro = this.getTelefone();
        String emailCadastro = this.getEmail();
        String senhaCadastro = this.getSenha();
        if (nomeCadastro != null && telefoneCadastro != null 
                && emailCadastro != null && senhaCadastro != null) {
            cadastraUsuario.setNome(nomeCadastro);
            cadastraUsuario.setTelefone(telefoneCadastro);
            cadastraUsuario.setEmail(emailCadastro);
            cadastraUsuario.setSenha(senhaCadastro);
            
            usuariosFachada.cadastraUsuario(cadastraUsuario);
        }
        
        return "/index";
    }
    
    public String getUsuario(int id) {
        return usuariosFachada.getUsuario(id);
    }
    
}
