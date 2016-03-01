/*
 * Copyright (C) 2016 Carlos Alberto Cipriano Korovsky <carlos.korovsky@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.udesc.prog202.aula01.views;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author Carlos Alberto Cipriano Korovsky <carlos.korovsky@gmail.com>
 */
public class NewClientWindow extends JInternalFrame implements ActionListener {
    /**
     * Construtor da classe NewClientWindow, chamada após a criação de uma instância 
     * dos componentes.
     * 
     */
    public NewClientWindow() {
      
        /*
         * Chama a função initComponents aque irá fazer a inicialização e 
         * configuração da tela e seus respectivos componentes.
         */
        this.initComponents();
    }
    
    /**
     * Função para iniciar a tela e seus respectivos componentes.
     * 
     */
    private void initComponents() {
        /*
         * Configura o título da janela.
         */
        this.setTitle("Novo cliente");
        this.setIconifiable(true);
        this.setMaximizable(true);
        this.setResizable(true);
        this.setClosable(true);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        /*
         * Configura o tamanho mínimo da janela. 400x300 pixels
         */
        this.setMinimumSize(new Dimension(200, 100));
        
        /*
         * Configura o tamanho preferencial da janela. 800x600 pixels
         */
        this.setPreferredSize(new Dimension(400, 200));

        
        this.pack();
               
    }
    
    /**
     * Processa as ações geradas pela janela.
     * @param e Evento que gerou uma ação
     */
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        /*
         * Recupera qual objeto que executou uma ação
         */
        Object source = e.getSource();
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
