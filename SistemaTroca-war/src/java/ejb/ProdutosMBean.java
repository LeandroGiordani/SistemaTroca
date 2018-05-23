/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.io.Serializable;
import java.util.List;
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
@Named(value = "produtosMBean")
@SessionScoped
public class ProdutosMBean implements Serializable{

    @EJB
    private ProdutosFachada produtosFachada;

    private String categoria = "";
    
    private String itemCadastro;
    private String categoriaCadastro;
    private int idUsuario;
    

    /**
     * Creates a new instance of ProdutosMBean
     */
    public ProdutosMBean() {
    }

    public List<Produtos> getListaProdutos() {
        return produtosFachada.getListaProdutos();
    }

    public List<Produtos> buscar(String categoria) {
        return produtosFachada.getListaProdutosPorCategoria(categoria);
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }
    
    public void setItemCadastro(String item) {
        this.itemCadastro = item;
    }
    
    public String getItemCadastro() {
        return this.itemCadastro;
    }
    
    public void setCategoriaCadastro(String categoria) {
        this.categoriaCadastro = categoria;
    }
    
    public String getCategoriaCadastro() {
        return this.categoriaCadastro;
    }
    
    public void setIdUsuario(int id) {
        this.idUsuario = id;
    }
    
    public int getIdUsuario() {
        return this.idUsuario;
    }
    
    public String cadastraProduto(int idusuario) {
        int id = produtosFachada.getMaxId() + 1;
        Produtos cadastraProduto = new Produtos(id);
        String itemCadastrado = this.getItemCadastro();
        String categoriaCadastrada = this.getCategoria();
        int idusuarioCadastro = this.getIdUsuario();
        if (itemCadastrado != null && categoriaCadastrada != null 
                && idusuarioCadastro != 0) {
            cadastraProduto.setItem(itemCadastrado);
            cadastraProduto.setCategoria(categoriaCadastrada);
            cadastraProduto.setIdusuario(idusuarioCadastro);
            
            produtosFachada.cadastraProduto(cadastraProduto);
        }
        
        return "/main";
    }

}
