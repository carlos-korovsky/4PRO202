/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.prog202.aula03.view;

import br.udesc.prog202.aula03.servico.Calculadora;
import br.udesc.prog202.aula03.controller.Produtos;
import br.udesc.prog202.aula03.model.Produto;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Carlos Alberto Cipriano Korovsky <carlos.korovsky@gmail.com>
 */
public class MainWindow extends javax.swing.JFrame {

    private final Produtos produtos;   
    
    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        this.produtos = new Produtos();
        initComponents();
    }


    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 40));

        jButton2.setText("Adicionar pré cadastro");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);

        jButton3.setText("Adicionar Linha");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);

        jButton1.setText("Soma");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jLabel1.setText("Resultado");
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome do produto", "Valor do produto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Evento realizado quando se clica no botão soma
     * @param evt 
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int soma = realizaSomatorio();
        jLabel1.setText(String.valueOf(soma));
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Evento realizado quando se clica no botão Adicionar pré cadastro
     * @param evt 
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) this.jTable1.getModel();
        for (Produto p: this.produtos.getAllProdutos()) {
            Object[] rowData = new Object[]{p.getNome(), p.getValor()};
            modelo.addRow(rowData);
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    
    /**
     * Evento realizado quando se clica no botão Adicionar Linha
     * @param evt 
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) this.jTable1.getModel();
        Object[] rowData = new Object[]{"Novo produto", 0};
        modelo.addRow(rowData);
    }//GEN-LAST:event_jButton3ActionPerformed

    
    /**
     * Função que realiza o somatório de todos as linhas selecionadas.
     * Caso não existam linhas selecionadas ele soma o valor de toda a tabela.
     * @return a soma dos itens selecionados ou da tabela inteira
     */
    private Integer realizaSomatorio() {
        int soma = 0;
        TableModel modelo = this.jTable1.getModel();
        int[] selectedRows = this.jTable1.getSelectedRows();
        if (selectedRows.length == 0) {
            for (int i = 0; i < modelo.getRowCount(); i++) {
                int valor = (Integer) modelo.getValueAt(i, 1);
                soma = Calculadora.soma(soma, valor);
            }
        } else {
            for (int i = 0; i < selectedRows.length; i++) {
                int valor = (Integer) modelo.getValueAt(selectedRows[i], 1);
                soma = Calculadora.soma(soma, valor);
            }
        }
        return soma;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}