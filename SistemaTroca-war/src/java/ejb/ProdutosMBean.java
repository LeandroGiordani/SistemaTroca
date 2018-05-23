/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author giordani
 */
@ManagedBean
@Named(value = "produtosMBean")
@RequestScoped
public class ProdutosMBean {

    @EJB
    private ProdutosFachada produtosFachada;

    private String categoria = "";

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

}
