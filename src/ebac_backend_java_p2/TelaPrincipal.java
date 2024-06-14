/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ebac_backend_java_p2;

import dao.ClienteDAO;
import dao.IClienteDAO;
import domain.Cliente;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaPrincipal extends javax.swing.JFrame {

    private DefaultTableModel modelo = new DefaultTableModel();
    private IClienteDAO clienteDAO = new ClienteDAO();
    
    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        initCustomComponents();
    }

    // <editor-fold default state="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelNome = new javax.swing.JLabel();
        textoNome = new javax.swing.JTextField();
        buttonSalvar = new javax.swing.JButton();
        labelCpf = new javax.swing.JLabel();
        textoCpf = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableClientes = new javax.swing.JTable();
        buttonExcluir = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuItemSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelNome.setText("Nome:");

        buttonSalvar.setText("Salvar");
        buttonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    buttonSalvarActionPerformed(evt);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        labelCpf.setText("CPF:");

        tableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    tableClientesMouseClicked(evt);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        jScrollPane1.setViewportView(tableClientes);

        buttonExcluir.setText("Excluir");
        buttonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    buttonExcluirActionPerformed(evt);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        jMenu1.setText("Opções");

        menuItemSair.setText("Sair");
        menuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSairActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemSair);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonSalvar)
                        .addGap(28, 28, 28)
                        .addComponent(buttonExcluir)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(labelCpf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textoCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(labelNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(68, 68, 68))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNome)
                    .addComponent(textoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCpf)
                    .addComponent(textoCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSalvar)
                    .addComponent(buttonExcluir))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSairActionPerformed
        int result = JOptionPane.showConfirmDialog(
                this,
                "Deseja sair da aplicação?",
                "Sair",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
                );
        if(result == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_menuItemSairActionPerformed

    private void buttonSalvarActionPerformed(java.awt.event.ActionEvent evt) throws Exception {//GEN-FIRST:event_buttonSalvarActionPerformed
        String nome = textoNome.getText();
        Long cpf = Long.valueOf(textoCpf.getText());
        
        if(!isCamposValidos(nome)){
            JOptionPane.showMessageDialog(
                null, 
                "Existem campos a serem preenchidos!", 
                "Erro", 
                JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        Cliente cliente = new Cliente(cpf, nome, "98206", true);
        
        Boolean isCadastrado = this.clienteDAO.cadastrar(cliente);
        
        if(isCadastrado) {
            modelo.addRow(new Object[]{cliente.getNome(), cliente.getCpf()});
            limparCampos();
            
            JOptionPane.showMessageDialog(
                null, 
                "Cliente '" + nome +"' salvo com sucesso!", 
                "cadastrar", 
                JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(
                null, 
                "Cliente com CPF " + cpf +" já está cadastrado!", 
                "Erro cadastrar", 
                JOptionPane.INFORMATION_MESSAGE);
        }
        
        
    }//GEN-LAST:event_buttonSalvarActionPerformed

    private void tableClientesMouseClicked(java.awt.event.MouseEvent evt) throws Exception {//GEN-FIRST:event_tableClientesMouseClicked
        int linhaSelecionada = tableClientes.getSelectedRow();
        Long cpf = (Long) tableClientes.getValueAt(linhaSelecionada, 1);
        
        Cliente cliente = this.clienteDAO.buscar(cpf);
        
        textoNome.setText(cliente.getNome());
        textoCpf.setText(cliente.getCpf().toString());        
    }//GEN-LAST:event_tableClientesMouseClicked

    private void buttonExcluirActionPerformed(java.awt.event.ActionEvent evt) throws Exception {//GEN-FIRST:event_buttonExcluirActionPerformed
        int linhaSelecionada = tableClientes.getSelectedRow();
        
        if(linhaSelecionada >= 0){
            int result = JOptionPane.showConfirmDialog(
                    this, 
                    "Deseja realmente excluir este cliente?",
                    "Atenção",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
                    );
            
            if(result == JOptionPane.YES_OPTION){
                Long cpf = (Long) tableClientes.getValueAt(linhaSelecionada, 1);
                Cliente cliente = new Cliente(cpf);

                this.clienteDAO.excluir(cliente.getCpf());
                modelo.removeRow(linhaSelecionada);
                
                JOptionPane.showMessageDialog(
                        null, 
                        "Cliente excluido!",
                        "Excluir cliente",
                        JOptionPane.INFORMATION_MESSAGE                         
                        );
                limparCampos();
            }
        } else {
            JOptionPane.showMessageDialog(
                        null, 
                        "Nenhum cliente selecionado!",
                        "Erro ao excluir cliente",
                        JOptionPane.INFORMATION_MESSAGE                         
                        );
        }
    }//GEN-LAST:event_buttonExcluirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonExcluir;
    private javax.swing.JButton buttonSalvar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCpf;
    private javax.swing.JLabel labelNome;
    private javax.swing.JMenuItem menuItemSair;
    private javax.swing.JTable tableClientes;
    private javax.swing.JTextField textoCpf;
    private javax.swing.JTextField textoNome;
    // End of variables declaration//GEN-END:variables

    private boolean isCamposValidos(String ...campos) {
        for(String campo : campos){
            if(campos == null || "".equals(campo)){
                return false;
            }
        }
        return true;
    }

    private void initCustomComponents() {
        modelo.addColumn("Nome");
        modelo.addColumn("CPF");
        
        tableClientes.setModel(modelo);
    }

    private void limparCampos() {
        textoNome.setText("");
        textoCpf.setText("");
    }
}
