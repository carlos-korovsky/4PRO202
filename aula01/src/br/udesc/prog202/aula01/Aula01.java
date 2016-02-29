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
package br.udesc.prog202.aula01;

import br.udesc.prog202.aula01.views.MainWindow;

/**
 * Classe base para Aula 01
 * 
 * @author Carlos Alberto Cipriano Korovsky  {@literal <carlos.korovsky at gmail.com>}
 */
public class Aula01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
         * Cria uma instância (objeto) da classe MainWindow
         */
        MainWindow janelaPrincipal = new MainWindow();
        
        /*
         * Artifício técnico (xunxo) para tornar o aplicativo Thread Save
         * O que permite a substituíção do método paint nas classes JFrame,
         * permindo maior controle sobre a geração da tela.
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                janelaPrincipal.setVisible(true);
            }
        });
        
        /*
         * O trecho de código anterior pode ser substituído por:
         * janelaPrincipal.setVisible(true);
         * Porém a aplicação pode não funcionar como o desejado em ambientes 
         * multithread (multiprocessados).
         */
    }
    
}
