/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

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
public class UsuariosFachada {

    @PersistenceContext(unitName = "SistemaTroca-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public int getMaxId() {
        Query query = em.createNamedQuery("Usuarios.findMaxId");
        return Integer.parseInt(query.getResultList().get(0).toString());
    }
    
    public void cadastraUsuario(Usuarios usuario) {
        this.persist(usuario);
    }
    
    public Usuarios login(String email, String senha) {
        Query query = em.createNamedQuery("Usuarios.findByEmail");
        query.setParameter("email", email);
        try {
            Usuarios usuario = (Usuarios) query.getSingleResult();
            if (usuario.getSenha().equalsIgnoreCase(senha)) {
                return usuario;
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public Usuarios contata(int idusuario) {
        Query query = em.createNamedQuery("Usuarios.findById");
        query.setParameter("id", idusuario);
        try {
            Usuarios usuario = (Usuarios) query.getSingleResult();
            if (usuario.getId() == idusuario) {
                return usuario;
            }
        } catch (Exception e) {
        }
        return null;
    }
}
