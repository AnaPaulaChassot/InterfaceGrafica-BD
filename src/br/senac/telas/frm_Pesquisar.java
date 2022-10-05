/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.telas;

import br.senac.conexaoBD.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import br.senac.telas.frm_CadastroContatos;
import javax.swing.JFrame;

/**
 *
 * @author anapc
 */
public class frm_Pesquisar extends javax.swing.JFrame {
    Connection con = null; // começa com nulo
    PreparedStatement ps = null; //prepara a consulta para fornecer parametros
    ResultSet rs = null; // armazena resultado da consulta
    /**
     * Creates new form frm_Pesquisar
     */
    public frm_Pesquisar() {
        initComponents();
        con = conexao.Conector();
    }
    
    frm_CadastroContatos carrega = new frm_CadastroContatos();

    
    private void pesquisar_contato(){
        String sql = "SELECT * FROM contatos WHERE nome_contato LIKE ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, txtPesquisa.getText()+"%");
            rs = ps.executeQuery();
            tbContatos.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
        }
    }
    
        private void dadosRegistrados() {
        String sql = "select * from contatos";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            tbContatos.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
        
        
    private void carregaCampos() {

        int carregar = tbContatos.getSelectedRow();
        TableModel model = tbContatos.getModel();
        String id = model.getValueAt(carregar, 0).toString();
        String nome = model.getValueAt(carregar, 1).toString();
        String telefone = model.getValueAt(carregar, 2).toString();
        String email = model.getValueAt(carregar, 3).toString();
        String sexo = model.getValueAt(carregar, 4).toString();
        String endereco = model.getValueAt(carregar, 5).toString();
        String bairro = model.getValueAt(carregar, 6).toString();
        String cidade = model.getValueAt(carregar, 7).toString();
        String cep = model.getValueAt(carregar, 8).toString();
        String uf = model.getValueAt(carregar, 9).toString();
        
        carrega.setVisible(true);
        carrega.pack();
        carrega.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        carrega.txtID.setText(id);
        carrega.txtNome.setText(nome);
        carrega.txtTelefone.setText(telefone);
        carrega.txtEmail.setText(email);
        carrega.cmbSexo.getSelectedItem().toString();
        carrega.txtEndereco.setText(endereco);
        carrega.txtBairro.setText(bairro);
        carrega.txtCidade.setText(cidade);
        carrega.txtCEP.setText(cep);
        carrega.cmbUF.getSelectedItem().toString();
        
        switch(sexo){
            case "Masculino":
                carrega.cmbSexo.setSelectedIndex(0);
                break;
            case "Feminino":
                carrega.cmbSexo.setSelectedIndex(1);
                break;
            default:
                carrega.cmbSexo.setSelectedIndex(-1);
                break;
        }
        
        switch(uf){
            case "AC":
                carrega.cmbUF.setSelectedIndex(0);
                break;
            case "AM":
                carrega.cmbUF.setSelectedIndex(1);
                break;
            case "RR":
                carrega.cmbUF.setSelectedIndex(2);
                break;
            case "PA":
                carrega.cmbUF.setSelectedIndex(3);
                break;
            case "AP":
                carrega.cmbUF.setSelectedIndex(4);
                break;
            case "TO":
                carrega.cmbUF.setSelectedIndex(5);
                break;
            case "MA":
                carrega.cmbUF.setSelectedIndex(6);
                break;
            case "PI":
                carrega.cmbUF.setSelectedIndex(7);
                break;
            case "CE":
                carrega.cmbUF.setSelectedIndex(8);
                break;
            case "RN":
                carrega.cmbUF.setSelectedIndex(9);
                break;
            case "PB":
                carrega.cmbUF.setSelectedIndex(10);
                break;
            case "PE":
                carrega.cmbUF.setSelectedIndex(11);
                break;
            case "AL":
                carrega.cmbUF.setSelectedIndex(12);
                break;
            case "SE":
                carrega.cmbUF.setSelectedIndex(13);
                break;
            case "BA":
                carrega.cmbUF.setSelectedIndex(14);
                break;
            case "MG":
                carrega.cmbUF.setSelectedIndex(15);
                break;
            case "ES":
                carrega.cmbUF.setSelectedIndex(16);
                break;
            case "RJ":
                carrega.cmbUF.setSelectedIndex(17);
                break;
            case "SP":
                carrega.cmbUF.setSelectedIndex(18);
                break;
            case "PR":
                carrega.cmbUF.setSelectedIndex(19);
                break;
            case "SC":
                carrega.cmbUF.setSelectedIndex(20);
                break;
            case "RS":
                carrega.cmbUF.setSelectedIndex(21);
                break;
            case "MS":
                carrega.cmbUF.setSelectedIndex(22);
                break;
            case "MT":
                carrega.cmbUF.setSelectedIndex(23);
                break;
            case "GO":
                carrega.cmbUF.setSelectedIndex(24);
                break;
            case "DF":
                carrega.cmbUF.setSelectedIndex(25);
                break;
           default:
                carrega.cmbUF.setSelectedIndex(-1);
                break;
        }
                
        this.dispose();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBuscar = new javax.swing.JButton();
        txtPesquisa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbContatos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btnBuscar.setText("Selecionar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyReleased(evt);
            }
        });

        tbContatos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return(false);
            }
        };
        tbContatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbContatos.setFocusable(false);
        tbContatos.setGridColor(new java.awt.Color(204, 204, 204));
        tbContatos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbContatos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        dadosRegistrados();
    }//GEN-LAST:event_formWindowOpened

    private void txtPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyReleased
        pesquisar_contato();
    }//GEN-LAST:event_txtPesquisaKeyReleased

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        carregaCampos();
    }//GEN-LAST:event_btnBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(frm_Pesquisar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_Pesquisar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_Pesquisar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_Pesquisar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_Pesquisar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbContatos;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
