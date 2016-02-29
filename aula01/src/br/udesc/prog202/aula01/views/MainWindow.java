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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Carlos Alberto Cipriano Korovsky {@literal <carlos.korovsky at gmail.com>}
 */
public class MainWindow extends JFrame implements ActionListener {
    /*
     * Definição de constantes (palavra reservada final)
     */
    private final String IMAGE_PATH = "/br/udesc/prog202/img/";
    
    /*
     * Definição dos componentes da tela.
     */
    private JMenuBar menuBar;
    private Icon fileIcon;
    private JMenu fileMenu;
    private Icon exitIcon;
    private JMenuItem exitMenuItem;
    private Icon clientIcon;
    private JMenu clientMenu;
    private Icon newClientIcon;
    private JMenuItem newClientMenuItem;
    
    /**
     * Construtor da classe MainWindow, chamada após a criação de uma instância 
     * dos componentes.
     * 
     */
    public MainWindow() {
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
         * Configura a ação padrão ao finalizar a janela. 
         * Neste caso, sair ao fechar.
         */
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        /*
         * Configura o tamanho mínimo da janela. 400x300 pixels
         */
        this.setMinimumSize(new Dimension(400, 300));
        
        /*
         * Configura o tamanho preferencial da janela. 800x600 pixels
         */
        this.setPreferredSize(new Dimension(800, 600));
        
        /*
         * Configura o tamanho máximo da janela. 1024x768 pixels
         */
        this.setMaximumSize(new Dimension(1024, 768));
               
        /*
         * Configura o título da janela.
         */
        this.setTitle("Aula 01 - Janela Principal");
        
        /*
         * Cria o componente da barra de menus, onde as opções de menu serão
         * incorporadas.
         */
        menuBar = new JMenuBar();
        
        /*
         * Adiciona a barra de menus ao objeto instanciado (this) da classe 
         * MainWindow
         */
        this.setJMenuBar(menuBar);
        
        /*
         * Carrega o ícone do menu Arquivo, gera um erro caso o arquivo não seja
         * encontrado. Este método carrega arquivos de dentro do pacote jar.
         */
        fileIcon = this.carregaIconeDoJar(IMAGE_PATH, "file.png");
        
        /*
         * Cria o componente do menu Arquivo
         */
        fileMenu = new JMenu();
        
        /*
         * Atribuí o texto Arquivo ao menu criado anteriormente.
         */
        fileMenu.setText("Arquivo");
        
        /*
         * Atribuí o caracter de atalho 'A' ao componente do menu Arquivo.
         * Atenção o caracter deverá compor o texto adicionado pela função 
         * setText chamada anteriormente.
         * O menu será acessado utilizando a tecla Alt + Caracter configurado.
         */
        fileMenu.setMnemonic('A');
        
        /*
         * Adiciona um icone ao menu Arquivo se ele existir.
         */
        if (fileIcon != null)
            fileMenu.setIcon(fileIcon);
        /*
         * Cria o item de menu responsável pela saída do programa.
         */
        exitIcon = this.carregaIconeDoJar(IMAGE_PATH, "exit.png");
        exitMenuItem = new JMenuItem();
        exitMenuItem.setText("Sair");
        exitMenuItem.setMnemonic('S');
        if (exitIcon != null)
            exitMenuItem.setIcon(exitIcon);
        
        /*
         * Adiciona um "ouvinte" de ações executadas.
         */
        exitMenuItem.addActionListener(this);
        
        /*
         * Adiciona o item de menu Sair ao menu Arquivo.
         */
        fileMenu.add(exitMenuItem);
                
        /*
         * Adiciona a instância relativa ao menu Arquivo a barra de menus
         */
        menuBar.add(fileMenu);
        
        /*
         * Cria o menu cliente.
         */
        clientMenu = new JMenu("Cliente");
        clientMenu.setMnemonic('C');
        clientIcon = this.carregaIconeDoJar(IMAGE_PATH, "client.png");
        if (clientIcon != null)
            clientMenu.setIcon(clientIcon);
        
        /*
         * Cria o submenu "Novo..." do menu cliente e adiciona no menu "Cliente"
         */
        newClientMenuItem = new JMenuItem("Novo...", 'N');
        newClientIcon = this.carregaIconeDoJar(IMAGE_PATH, "new.png");
        if (newClientIcon != null)
            newClientMenuItem.setIcon(newClientIcon);
        newClientMenuItem.addActionListener(this);
        clientMenu.add(newClientMenuItem);
        
        /*
         * Adiciona o menu cliente na barra de menus.
         */
        this.getJMenuBar().add(clientMenu);
        
        /*
         * Calcula automaticamente o tamanho da janela conforme definido nas
         * funções setMinimumSize, setPreferredSize e setMaximumSize
         */
        this.pack();
        
        /*
         * Recupera as informações do tamanho da tela onde a aplicação está 
         * sendo executada.
         */
        double screenWidth = this.getGraphicsConfiguration().getBounds().getWidth();
        double screenHeight = this.getGraphicsConfiguration().getBounds().getHeight();
        
        /*
         * Calcula a posição onde a janela será posicionada.
         */
        int windowLeft = (int)(screenWidth - this.getWidth()) / 2;
        int windowTop = (int)(screenHeight - this.getHeight()) / 2;
        
        /*
         * Configura a posição onde a janela será visualizada inicialmente.
         */
        this.setLocation(windowLeft, windowTop);
    }

    /**
     * Carrega arquivos de imagens para ser utilizados como ícones do menu.
     * 
     * @param path Caminho dentro do arquivo jar onde o arquivo do ícone está 
     * armazenado
     * @param file Nome do arquivo do ícone
     * @return Os dados do ícone ou null caso o arquivo não seja encontrado.
     */
    private Icon carregaIconeDoJar(String path, String file) {
        Icon icone = null;
        java.net.URL imagemUrl = this.getClass().getResource(path.concat(file));
        if (imagemUrl != null) {
            icone = new ImageIcon(imagemUrl);
        }
        return icone;
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
        
        if (source.equals(exitMenuItem)) { // É o item de menu exitMenuItem?
            this.systemExit();
        } else if (source.equals(newClientMenuItem)) { // É um newClientMenuItem?
            this.newClientWindow();
        }
        
    }
    
    /**
     * Função que executa a saída do sistema.
     */
    private void systemExit() {
        int resposta = JOptionPane.showConfirmDialog(this, 
                "Deseja sair do sistema?", 
                "Sair do sistema", 
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
    
    /**
     * Abre a janela para cadastro de um novo cliente.
     */
    private void newClientWindow() {
        JOptionPane.showMessageDialog(this, "Abre nova janela de cliente.", 
                "Mensagem de aviso", 
                JOptionPane.INFORMATION_MESSAGE);
    }
    
}
