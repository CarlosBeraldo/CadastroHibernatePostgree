/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity (name = "Clientes")
public class Clientes {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;
    @Column
    private String razaoSocial;
    @Column
    private String nomeFantasia;
    
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "cliente_id")
    private List<ContatoCliente> contato = new ArrayList<>();
    
    public static final String PROP_ID = "id";
    public static final String PROP_RAZAOSOCIAL = "razaoSocial";
    public static final String PROP_NOMEFANTASIA = "nomeFantasia";
    public static final String PROP_CONTATO = "contato";

    public List<ContatoCliente> getContato() {
        return contato;
    }

    public void setContato(List<ContatoCliente> contato) {
        List<ContatoCliente> oldContato = this.contato;
        this.contato = contato;
        propertyChangeSupport.firePropertyChange(PROP_CONTATO, oldContato, contato);
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        String oldNomeFantasia = this.nomeFantasia;
        this.nomeFantasia = nomeFantasia;
        propertyChangeSupport.firePropertyChange(PROP_NOMEFANTASIA, oldNomeFantasia, nomeFantasia);
    }


    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        String oldRazaoSocial = this.razaoSocial;
        this.razaoSocial = razaoSocial;
        propertyChangeSupport.firePropertyChange(PROP_RAZAOSOCIAL, oldRazaoSocial, razaoSocial);
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        int oldId = this.id;
        this.id = id;
        propertyChangeSupport.firePropertyChange(PROP_ID, oldId, id);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
}
