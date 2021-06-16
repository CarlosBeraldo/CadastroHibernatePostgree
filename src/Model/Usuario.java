/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Carlos
 */

@Entity (name = "usuario")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id")
    private int id;
    @Column
    private String userName;
    @Column
    private String senha;

    public static final String PROP_SENHA = "senha";
    public static final String PROP_USERNAME = "userName";
    public static final String PROP_ID = "id";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        int oldId = this.id;
        this.id = id;
        propertyChangeSupport.firePropertyChange(PROP_ID, oldId, id);
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        String oldUserName = this.userName;
        this.userName = userName;
        propertyChangeSupport.firePropertyChange(PROP_USERNAME, oldUserName, userName);
    }
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        String oldSenha = this.senha;
        this.senha = senha;
        propertyChangeSupport.firePropertyChange(PROP_SENHA, oldSenha, senha);
    }



    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    
}
