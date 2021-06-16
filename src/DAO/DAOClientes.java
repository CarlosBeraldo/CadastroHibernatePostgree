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
public class DAOClientes {
    
    private EntityManager em;
    
    public DAOClientes(){
        em = Manager.getInstance().getEm();
    }
    
    public void salvar(Clientes cli){
        em.getTransaction().begin();
        if(cli.getId()>0){
            cli = em.merge(cli);
        }
        em.persist(cli);
        em.getTransaction().commit();
        
    }
    
    public  List<Clientes> getAll(){
        Query qry = em.createQuery("Select c from Model.Clientes c");
        List listaClientes = qry.getResultList();
        return(List<Clientes>) listaClientes;
    }
    public  List<ContatoCliente> getDadosContato(Clientes ci){
        int i = ci.getId();
        Query qry = em.createQuery("select p from ContatoCliente p where p.cliente = "+i+"");
        List listacontatoCliente = qry.getResultList();
        return(List<ContatoCliente>) listacontatoCliente;
    }
   
    public void remover(Clientes cli){
        
        em.getTransaction().begin();
        em.remove(cli);
        em.getTransaction().commit();
        
    }
    
}
