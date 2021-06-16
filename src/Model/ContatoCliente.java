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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Carlos
 */
@Entity(name="ContatoCliente")
public class ContatoCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;
    @Column
    private String nome;
    @Column    
    private String telefone;
    @Column
    private String email;
    @Column
    private String setor;
    @Column    
    private String fonte;
    @ManyToOne(fetch = FetchType.LAZY)
    private Clientes cliente;

    public static final String PROP_CLIENTE = "cliente";
    public static final String PROP_FONTE = "fonte";
    public static final String PROP_SETOR = "setor";
    public static final String PROP_EMAIL = "email";
    public static final String PROP_TELEFONE = "telefone";
    public static final String PROP_NOME = "nome";
    public static final String PROP_ID = "id";
    
    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        Clientes oldCliente = this.cliente;
        this.cliente = cliente;
        propertyChangeSupport.firePropertyChange(PROP_CLIENTE, oldCliente, cliente);
    }
    
    public String getFonte() {
        return fonte;
    }

    public void setFonte(String fonte) {
        String oldFonte = this.fonte;
        this.fonte = fonte;
        propertyChangeSupport.firePropertyChange(PROP_FONTE, oldFonte, fonte);
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        String oldSetor = this.setor;
        this.setor = setor;
        propertyChangeSupport.firePropertyChange(PROP_SETOR, oldSetor, setor);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        propertyChangeSupport.firePropertyChange(PROP_EMAIL, oldEmail, email);
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        String oldTelefone = this.telefone;
        this.telefone = telefone;
        propertyChangeSupport.firePropertyChange(PROP_TELEFONE, oldTelefone, telefone);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        propertyChangeSupport.firePropertyChange(PROP_NOME, oldNome, nome);
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
