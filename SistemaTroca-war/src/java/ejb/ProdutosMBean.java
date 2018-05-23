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

/**
 *
 * @author giordani
 */
@Named(value = "produtosMBean")
@RequestScoped
public class ProdutosMBean {

    @EJB
    private ProdutosFachada produtosFachada;

    /**
     * Creates a new instance of ProdutosMBean
     */
    public ProdutosMBean() {
    }
    
    public List<Produtos> getListaProdutos() {
        return produtosFachada.getListaProdutos();
    }
    
}
