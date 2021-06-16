/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.DAOClientes;
import DAO.DAOContatoCliente;
import Model.Clientes;
import Model.ContatoCliente;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author Carlos
 */
public class TelaMostrarContato extends javax.swing.JFrame {

    private DAOClientes dc;
    private DAOContatoCliente dcc;
    private Clientes cliente;

    public static final String PROP_CLIENTE = "cliente";

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        Clientes oldCliente = this.cliente;
        this.cliente = cliente;
        firePropertyChange(PROP_CLIENTE, oldCliente, cliente);
    }


    public TelaMostrarContato(ActionListener al) {
        initComponents();
        dcc = new DAOContatoCliente();
        dc = new DAOClientes();
        botaoVoltar.addActionListener(al);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        listaMostraContato = ObservableCollections.observableList(new ArrayList<ContatoCliente>());
        botaoVoltar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaMostraContatos = new javax.swing.JTable();
        botaoApagarContato = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botaoVoltar.setText("Voltar");
        botaoVoltar.setActionCommand("botaoVoltar");

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listaMostraContato, tabelaMostraContatos);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${telefone}"));
        columnBinding.setColumnName("Telefone");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nome}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${email}"));
        columnBinding.setColumnName("Email");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fonte}"));
        columnBinding.setColumnName("Fonte");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${setor}"));
        columnBinding.setColumnName("Setor");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(tabelaMostraContatos);
        if (tabelaMostraContatos.getColumnModel().getColumnCount() > 0) {
            tabelaMostraContatos.getColumnModel().getColumn(0).setResizable(false);
            tabelaMostraContatos.getColumnModel().getColumn(1).setResizable(false);
            tabelaMostraContatos.getColumnModel().getColumn(2).setResizable(false);
            tabelaMostraContatos.getColumnModel().getColumn(3).setResizable(false);
            tabelaMostraContatos.getColumnModel().getColumn(4).setResizable(false);
            tabelaMostraContatos.getColumnModel().getColumn(5).setResizable(false);
        }

        botaoApagarContato.setText("Apagar Contato");
        botaoApagarContato.setActionCommand("botaoApagarContato");
        botaoApagarContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoApagarContatoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoApagarContato, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botaoVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(botaoApagarContato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoApagarContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoApagarContatoActionPerformed
        if(tabelaMostraContatos.getSelectedRowCount()==1){
                if(JOptionPane.showConfirmDialog(this, "Deseja Realmente remover!?","Confirmação",
                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                     
                int idTemporario = tabelaMostraContatos.getSelectedRow();
                
                ContatoCliente contatoCliente = listaMostraContato.get(idTemporario);
                dcc.remover(contatoCliente);
                listaMostraContato.remove(contatoCliente);
                JOptionPane.showMessageDialog(this, "Removido com sucesso");
            }
        }
            else{
                JOptionPane.showMessageDialog(this, "Selecione um cliente da tabela");
            }
    }//GEN-LAST:event_botaoApagarContatoActionPerformed

    public void atualizar(Clientes clientAtt){
        listaMostraContato.clear();
        listaMostraContato.addAll(dc.getDadosContato(clientAtt));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoApagarContato;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JScrollPane jScrollPane1;
    private java.util.List<ContatoCliente> listaMostraContato;
    private javax.swing.JTable tabelaMostraContatos;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
