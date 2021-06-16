/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Clientes;
import Model.ContatoCliente;
import Services.Manager;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Carlos
 */
public class DAOContatoCliente {
    
    private EntityManager em;
    
    public DAOContatoCliente(){
        em = Manager.getInstance().getEm();
    }
    
    public void salvar(ContatoCliente cc){
        em.getTransaction().begin();
        if(cc.getId()>0){
            cc = em.merge(cc);
        }
        em.persist(cc);
        em.getTransaction().commit();
        
    }
      
    public void remover(ContatoCliente cc){
        
        em.getTransaction().begin();
        em.remove(cc);
        em.getTransaction().commit();
        
    }
}
