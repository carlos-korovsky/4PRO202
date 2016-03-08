/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.prog202.aula02;

import br.udesc.prog202.aula02.view.MainWindow;

/**
 *
 * @author Carlos Alberto Cipriano Korovsky <carlos.korovsky@gmail.com>
 */
public class Aula02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
    
}
