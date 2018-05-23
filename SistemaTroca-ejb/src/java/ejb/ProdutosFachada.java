/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author giordani
 */
@Stateless
@LocalBean
public class ProdutosFachada {

    @PersistenceContext(unitName = "SistemaTroca-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public int getMaxId() {
        Query query = em.createNamedQuery("Produtos.findMaxId");
        return Integer.parseInt(query.getResultList().get(0).toString());
    }
    
    public List<ejb.Produtos> getListaProdutos() {
        Query query = em.createNamedQuery("Produtos.findAll");
        return query.getResultList();
    }
    
    public List<ejb.Produtos> getListaProdutosPorCategoria(String categoria) {
        Query query = em.createNamedQuery("Produtos.findByCategoria");
        query.setParameter("categoria", categoria);
        return query.getResultList();
    }

    void cadastraProduto(Produtos produto) {
        em.persist(produto);
    }
}
