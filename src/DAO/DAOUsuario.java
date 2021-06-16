/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Usuario;
import Services.Manager;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author Carlos
 */
public class DAOUsuario {
     private EntityManager em;
    
    public DAOUsuario(){
        em = Manager.getInstance().getEm();
    }
    
    public void salvar(Usuario user){
        em.getTransaction().begin();
        if(user.getId()>0){
            user = em.merge(user);
        }
        em.persist(user);
        em.getTransaction().commit();
        
    }
    
    public  List<Usuario> getAll(){
        Query qry = em.createQuery("Select u from Model.Usuario u");
        List listaUsuario = qry.getResultList();
        return(List<Usuario>) listaUsuario;
    }

    public Usuario confirmarLogin(String u, String s){
        try{
            Usuario user = (Usuario)em.createQuery("SELECT u FROM Model.Usuario u WHERE u.userName = '"+u+"' AND u.senha = '"+s+"'").getSingleResult();
            return user;
        }
        catch (Exception e) {
            return null;
        }
        
    }
    
    public void remover(Usuario user){
        
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
        
    }
}
